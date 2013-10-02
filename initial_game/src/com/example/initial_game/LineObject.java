package com.example.initial_game;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;

public class LineObject extends sprite{
	

	private boolean positive;
	
	public LineObject(Bitmap BM, Point point, boolean positive, Rect bounds){
		super(BM, point, bounds);
		this.positive = positive;
	}
	
	public boolean getPositive(){
		return positive;
	}
	
	public void setPositive(boolean positive){
		this.positive = positive;
	}
	
}
