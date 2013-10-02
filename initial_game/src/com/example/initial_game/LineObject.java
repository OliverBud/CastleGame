package com.example.initial_game;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;

public class LineObject extends sprite{
	

	private boolean positive;
	private Point slope;
	
	public LineObject(Bitmap BM, Point point, boolean positive, Rect bounds, Point slope){
		super(BM, point, bounds);
		this.positive = positive;
		this.slope = slope;
	}
	
	public boolean getPositive(){
		return positive;
	}
	
	public void setPositive(boolean positive){
		this.positive = positive;
	}
	
	public Point getSlope(){
		return slope;
	}
	
	public void setSlope(Point new_slope){
		this.slope = new_slope;
	}
}
