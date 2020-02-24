package com.bai.discoverjapan.startup;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bai.discoverjapan.Constant;
import com.bai.discoverjapan.R;
import com.bai.discoverjapan.cameradetect.CameraActivity;

public class StartActivity extends Activity {

	private Button startButton, downloadButton;
	private ImageView instructionView;
	private int clickCount=0;

	private final Handler dialogHandler = new Handler();
	private ProgressDialog dialog;
	private String message;
	private boolean visible;
	public void onCreate(Bundle savedInstanceState) 
	{		
		super.onCreate(savedInstanceState);
	}
	
	Runnable updateMessage = new Runnable() {
		@Override
		public void run() {
			dialog.setMessage(message);
		}
	};

	Runnable startDialog = new Runnable() {
		@Override
		public void run() {
			dialog.show();
		}
	};

	Runnable stopDialog = new Runnable() {
		@Override
		public void run() {
			dialog.dismiss();
		}
	};
	@Override
	protected void onPause() {
		if (visible && dialog.isShowing()) dialogHandler.post(stopDialog);
		visible = false;
		super.onPause();
	}

	@Override
	protected void onResume() 
	{
		setContentView(R.layout.startup_layout);
		dialog = new ProgressDialog(this);
		
		startButton 	= (Button) findViewById(R.id.startButton);
		downloadButton 	= (Button) 	findViewById(R.id.downloadButton);
		downloadButton	= (Button) 	findViewById(R.id.downloadButton);
		instructionView = (ImageView) findViewById(R.id.instructionView);
		
		instructionView.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{
				//check that makes the images go in a loop
				if(clickCount==0) {
					instructionView.setImageResource(R.drawable.instruction2);
					clickCount=1;
				} else if(clickCount==1) {
					instructionView.setImageResource(R.drawable.instruction3);
					clickCount=2;
				} else {
					instructionView.setImageResource(R.drawable.instruction1);
					clickCount=0;
				}
			}
		});
		
		startButton.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent newIntent = new Intent(getApplicationContext(), CameraActivity.class);
				startActivity(newIntent);
				setContentView(R.layout.loading_layout);
				overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
			}
		});

		downloadButton.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) {
				CheckNetwork cn = new CheckNetwork(getApplicationContext());
				if (cn.isConnectedToInternet()) {
				new Thread(new Runnable() 
				{
					public void run() 
					{
							dialogHandler.post(startDialog);
							message = getResources().getString(R.string.progress_dictionary);
							dialogHandler.post(updateMessage);
							// download both zipped trained db and zipped dictionary db sequentially
							DownloadContent dcdict = new DownloadContent(1);
							try {
								dcdict.downloadFile();
							} catch (Exception e) {
								e.printStackTrace();
							}
							message = getResources().getString(R.string.progress_library);
							dialogHandler.post(updateMessage);
							DownloadContent dctess = new DownloadContent(2);
							try {
								dctess.downloadFile();
							} catch (Exception e) {
								e.printStackTrace();
							}
							dialogHandler.post(stopDialog);
							dialogHandler.post(hideUnnecessaryButton);
					}
				}).start();
				} else {
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_network), Toast.LENGTH_LONG).show();
				}
			}	
		});
		
		dialogHandler.post(hideUnnecessaryButton);
		visible = true;
		super.onResume();
	}

	// a check for buttons if files are downloaded hide download button, if not - hide start button
	Runnable hideUnnecessaryButton = new Runnable() {
		@Override
		public void run() {
			if (ManageFileService.fileExists(Constant.DATA_PATH + Constant.DICT_FILENAME) && 
					ManageFileService.fileExists(Constant.DATA_PATH + Constant.TESS_FILENAME)) {
				downloadButton.setVisibility(View.GONE);
				startButton.setVisibility(View.VISIBLE);
			}
			else {
				downloadButton.setVisibility(View.VISIBLE);
				startButton.setVisibility(View.GONE);
			}
		}
	};
}
