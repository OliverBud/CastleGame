package com.example.initial_game;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;

public class sprite {

	private Bitmap BM;
	private Point point;
	private Rect bounds;
	
	public sprite(Bitmap BM, Point point, Rect bounds){
		this.BM = BM;
		this.point = point;
		this.bounds = bounds;
		
	}
	
	public Bitmap getBitmap(){
		return BM;
	}
	
	public Point getPoint(){
		return point;
	}
	
	public int getPointX(){
		return point.x;
	}
	
	public int getPointY(){
		return point.y;
	}
	
	public Rect getBounds(){
		return bounds;
	}
	
	public int getSpriteWidth() {
        return bounds.width();
	}

	public int getSpriteHeight() {
        return bounds.height();
}
	
	public void setBitmap(Bitmap BM){
		this.BM = BM;
	}
	
	public void setPoint(Point point){
		this.point = point;
	}
	
	public void setBounds(Rect new_bounds){
		this.bounds = new_bounds;
	}
}
