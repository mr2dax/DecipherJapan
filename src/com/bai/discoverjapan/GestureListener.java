package com.bai.discoverjapan;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

//Class responding for detection of swipe event and checking the direction of this event
public abstract class GestureListener extends SimpleOnGestureListener {

	private final int MinimumSwipeDistance = 200;
    private final int SwipeThresholdVelocity = 100;
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
   	
        if(e1.getX() - e2.getX() > MinimumSwipeDistance && Math.abs(velocityX) > SwipeThresholdVelocity) 
        {
            toTheLeft();
        } 
        else if (e2.getX() - e1.getX() > MinimumSwipeDistance && Math.abs(velocityX) > SwipeThresholdVelocity) {
            toTheRight();
        }
        return false;
    }
    
    public abstract void toTheLeft();
    public abstract void toTheRight();
 }