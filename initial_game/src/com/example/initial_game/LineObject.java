package com.example.initial_game;

import android.graphics.Bitmap;
import android.graphics.Point;

public class LineObject {
	
	private Bitmap BM;
	private Point point;
	private boolean positive;
	
	public LineObject(Bitmap BM, Point point, boolean positive){
		this.BM = BM;
		this.point = point;
		this.positive = positive;
		
	}
	
	public Bitmap getBitmap(){
		return BM;
	}
	
	public Point getPoint(){
		return point;
	}
	
	public boolean getPositive(){
		return positive;
	}
	
	public void setBitmap(Bitmap BM){
		this.BM = BM;
	}
	
	public void setPoint(Point point){
		this.point = point;
	}
	
	public void setPositive(boolean positive){
		this.positive = positive;
	}

}
