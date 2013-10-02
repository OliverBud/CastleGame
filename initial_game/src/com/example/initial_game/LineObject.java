package com.example.initial_game;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;

public class LineObject extends sprite{
	

	private boolean positive;
	private Point deltas;
	
	public LineObject(Bitmap BM, Point point, boolean positive, Rect bounds, Point deltas){
		super(BM, point, bounds);
		this.positive = positive;
		this.deltas = deltas;
	}
	
	public boolean getPositive(){
		return positive;
	}
	
	public void setPositive(boolean positive){
		this.positive = positive;
	}
	
	public double getSlope(){
		return (double)(this.deltas.y/this.deltas.x);
	}
	
	public void setDeltas(Point new_deltas){
		this.deltas = new_deltas;
	}
}
