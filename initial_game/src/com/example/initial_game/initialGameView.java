package com.example.initial_game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class initialGameView extends View implements OnTouchListener{

	private Paint p;
	
	
	public initialGameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		p = new Paint();
		
		//initialize things
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		Point point = new Point();
        point.x = (int) event.getX();
        point.y = (int) event.getY();
        return true;
	}
	
	@Override
	synchronized public void onDraw(Canvas canvas){
		p.setColor(Color.BLACK);
        p.setAlpha(255);
        p.setStrokeWidth(1);
        canvas.drawRect(0, 0, getWidth(), getHeight(), p);
        p.setColor(Color.WHITE);
        Point test_point = new Point();
        
        int maxX = canvas.getWidth();
        int maxY = canvas.getHeight();
        
        test_point.x = (maxX - (maxX % 2) ) / 2;
        test_point.y = (maxY - (maxY % 2) ) / 2;
        canvas.drawCircle(test_point.x, test_point.y, 5, p);
        
        //draw things
		
	}

}
