package com.bai.discoverjapan.cameradetect;

import android.graphics.Color;
import android.util.Log;
import android.widget.TextView;



public class SwipeClass 
{
	private float coeficient;
	private TextView swipeView;
	private int displayWidth;
	private boolean leftToRight;
	
	public SwipeClass(TextView view, int displayWidth)
	{
		this.swipeView = view;
		this.displayWidth = displayWidth;
	}
	
	public void swipeColorChange(int f)
	{	
		if(f>0) leftToRight=true;
        else leftToRight=false;
		
		if(leftToRight)
		{
			swipeView.setPadding(0, 0, -Math.abs(f), 0);
		}
		else
		{
			swipeView.setPadding(-Math.abs(f), 0, 0, 0);	
		}
		
		coeficient = (float) f/displayWidth;
		swipeView.setBackgroundColor(Color.argb(99,(int) Math.abs(coeficient*255), 77, 204));
	}
}
