package com.bai.discoverjapan.dictionary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bai.discoverjapan.Constant;
import com.bai.discoverjapan.GestureListener;
import com.bai.discoverjapan.R;
import com.bai.discoverjapan.cameradetect.SwipeClass;


public class TranslationActivity extends Activity {
	
	private String 			searchPhrase;
	private Button 			transButton;
	private TextView 		resultText, swipeView;
	private EditText 		searchText;
	private RadioGroup 		changeLang;
	private RadioButton 	radioLangButton;
	private GestureDetector gestureDetector;
	private DatabaseAdapter db;
	
	private int x1,x2, distance;
	private SwipeClass swipeClass;
	private int displayWidth;
	private int currentapiVersion		= android.os.Build.VERSION.SDK_INT;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dictionary_layout);

		resultText 	= (TextView)	findViewById(R.id.resultText);
		searchText 	= (EditText)	findViewById(R.id.searchText);
		transButton = (Button)		findViewById(R.id.transButton);
		changeLang 	= (RadioGroup)	findViewById(R.id.changeLang);
		swipeView 	= (TextView)	findViewById(R.id.swipeView);
		
		transButton.setOnClickListener(new TranslationButtonClickHandler());
		
		//Detects if the swipe on swipeView has been to the left or right, finishes activity and adds the corresponding transition
		gestureDetector = new GestureDetector(getApplicationContext(), new GestureListener(){
			@Override
			public void toTheRight() {
				finish();
				overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
			}
			
			@Override
			public void toTheLeft() {
				finish();
				overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
			}
		});
		//This calculate display width in Translation Activity depending on API
		if (currentapiVersion < 13)
		{			
			Display display = getWindowManager().getDefaultDisplay();
			displayWidth = display.getWidth();
		}
		else
		{
			Point size = new Point();
			Display display = getWindowManager().getDefaultDisplay();
			display.getSize(size);
			displayWidth = size.x; 
		}
		//Initializing SwipeClass
		swipeClass = new SwipeClass(swipeView, displayWidth);
		//Ading the listener to the swipeView
		swipeView.setOnTouchListener(new OnTouchListener() 
		{
			@Override
			public boolean onTouch(final View view, final MotionEvent event) 
			{
				int action = event.getActionMasked();
				switch (action) 
				{
					case MotionEvent.ACTION_MOVE:	
					{
						  x2 = (int) event.getX();
						  distance = x2-x1;
						  swipeClass.swipeColorChange(distance);
					} 
					break;
					case MotionEvent.ACTION_UP:	
					{
						x1 = 0; 
						x2=0;
						swipeClass.swipeColorChange(0);
					} 
					break;
					case MotionEvent.ACTION_DOWN:
					{
						   x1 = (int) event.getX();
					} 
					break;
				}
				gestureDetector.onTouchEvent(event);
				return true;
			}
		});
	}
		
	public class TranslationButtonClickHandler implements View.OnClickListener {
		public void onClick(View view) {
			
			// eng2jap or jap2eng?
			int radioButton = changeLang.getCheckedRadioButtonId();		
			radioLangButton = (RadioButton) findViewById(radioButton);
			String selectedLang = (String) radioLangButton.getText();
			radioButton = changeLang.getCheckedRadioButtonId();
			String language = selectedLang;
			
			// clear the result Textview and reset the counter for the results
			resultText.setText("");
			
			// get the textfield from the  that needs to be translated
			searchPhrase = searchText.getText().toString();
			
			if (language.equalsIgnoreCase("jpn")) {
				jap2EngTranslation(searchPhrase);
			} else {
				eng2JapTranslation(searchPhrase);
			}
		}
	}
	
	private void jap2EngTranslation(String searchPhrase){
		formattedResult = "";
		numberOfTranslationResults = 0;
		Cursor results = db.getExactMatchJapEng(searchPhrase);
		// if there were no exact matches
		if (results.getCount()==0){
			results=db.getExactMatchOnReadingJapEng(searchPhrase);
		}
		displayTranslationResults(results);
		
		results = db.getSuggestionJapEng(searchPhrase);
		displayTranslationResults(results);
	}
	
	private void eng2JapTranslation(String searchPhrase){
		formattedResult = "";
		numberOfTranslationResults = 0;
		Cursor results = db.getExactMatchEngJap(searchPhrase);
		displayTranslationResults(results);
		results = db.getSuggestionJapEng(searchPhrase);
		displayTranslationResults(results);
	}
	
	private String formattedResult="";
	private int numberOfTranslationResults;
	private void displayTranslationResults(Cursor resultCursor){
		int wordColumnIndex		= resultCursor.getColumnIndex("word");
		int readingColumndIndex	= resultCursor.getColumnIndex("reading");
		int meaningColumnIndex	= resultCursor.getColumnIndex("meaning");
		

		while (resultCursor.moveToNext() && numberOfTranslationResults<=Constant.MAX_TRANS_RESULTS){
			//FORMAT THE RESULTS
			formattedResult += 
					resultCursor.getString(wordColumnIndex) + " (" + 
					resultCursor.getString(readingColumndIndex) + ")\n" +
					resultCursor.getString(meaningColumnIndex) + "\n\n";
			numberOfTranslationResults++;
		}
		resultText.setText(formattedResult);
	}
		
	@Override
	protected void onPause() {
		if ((db!=null) && (db.isOpen())) db.close();
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		if (db==null) {
			db = new DatabaseAdapter(getApplicationContext());
			db.open();
		}
		super.onResume();
	}	
}