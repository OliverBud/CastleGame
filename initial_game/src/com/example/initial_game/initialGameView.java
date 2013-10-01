package com.example.initial_game;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
	ArrayList<Bitmap> BitMap_array; 
	ArrayList<Point> BM_points;
	ArrayList<LineObject> line_array;
	boolean touched;
	Point line_touch;
	
	
	public initialGameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		line_touch = new Point();
		touched = false;
		p = new Paint();
		Bitmap.Config conf = Bitmap.Config.ARGB_8888;
		BitMap_array = new ArrayList<Bitmap>();
		BM_points = new ArrayList<Point>();
		line_array = new ArrayList<LineObject>();
		
		Bitmap first_bitMap = Bitmap.createBitmap(100, 100, conf);
		BitMap_array.add(first_bitMap);
		Bitmap second_bitMap = Bitmap.createBitmap(100, 100, conf);
		BitMap_array.add(second_bitMap);
		
		//initialize things
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		Point point = new Point();
        point.x = (int) event.getX();
        point.y = (int) event.getY();
        
        if (touched){
        	Bitmap.Config conf = Bitmap.Config.ARGB_8888;
        	Bitmap new_Bitmap = Bitmap.createBitmap(Math.abs(point.x - line_touch.x), Math.abs(point.y - line_touch.y), conf);
        	Point new_point = new Point();
        	new_point.x = (point.x >= line_touch.x ? line_touch.x : point.x);
        	new_point.y = (point.y >= line_touch.y ? line_touch.y : point.y);
        	boolean positive;
        	
        	
        	if (point.x >= line_touch.x){
        		if (point.y >= line_touch.y){
        			positive = false;
        		}
        		else{
        			positive = true;
        		}
        	}
        	else{
        		if (point.y >= line_touch.y){
        			positive = true;
        		}
        		else{
        			positive = false;
        		}
        	}
        	
        	line_array.add(new LineObject(new_Bitmap, new_point, positive));
        	
        	
        	touched = false;
        }
        else{
        	line_touch = point;
        
        	touched = true;
        }
        invalidate();
        return true;
	}
	
	@Override
	synchronized public void onDraw(Canvas canvas){
		p.setColor(Color.BLACK);
        p.setAlpha(255);
        p.setStrokeWidth(1);
        canvas.drawRect(0, 0, getWidth(), getHeight(), p);
        p.setColor(Color.WHITE);
        Point test_point1 = new Point();
        Point test_point2 = new Point();
        
        int maxX = canvas.getWidth();
        int maxY = canvas.getHeight();
        
        test_point1.x = ( 2 * (maxX - (maxX % 2) ) ) / 4;
        test_point1.y = ( 2 * (maxY - (maxY % 2) ) ) / 4;
        BM_points.add(test_point1);
        BM_points.add(test_point2);
        test_point2.x = (maxX - (maxX % 2) ) / 4;
        test_point2.y = (maxY - (maxY % 2) ) / 4;
       // canvas.drawCircle(test_point.x, test_point.y, 5, p);
        
        Canvas BM_canvas = new Canvas();
//        p.setColor(Color.GREEN);
//        BM_canvas.setBitmap(first_bitMap);
//        BM_canvas.drawRect(0, 0, first_bitMap.getWidth(), first_bitMap.getWidth(), p);
//        
//        p.setColor(Color.WHITE);
//        BM_canvas.drawRect(10, 10 , 20 , 20, p);
        
        
  //      canvas.drawBitmap(first_bitMap, test_point.x, test_point.y, null);

        int counter = 0;
        for (Bitmap BM : BitMap_array){
        	BM_canvas.setBitmap(BM); 
        	
        	p.setColor(Color.GREEN);
        	BM_canvas.drawRect(0, 0, BM.getWidth(), BM.getWidth(), p);
        	
        	p.setColor(Color.WHITE);
        	if (counter == 1){
            	p.setColor(Color.RED);
            }
            BM_canvas.drawRect(10, 10 , 20 , 20, p);
            
            if (counter == 1){
            	p.setColor(Color.RED);
            }
        	canvas.drawBitmap(BM, BM_points.get(counter).x, BM_points.get(counter).y, null);
        	
        	counter += 1;
        }
        
        Bitmap map;
        for (LineObject line : line_array){
        	
        	map = line.getBitmap();
        	Point line_point = line.getPoint();
        	BM_canvas.setBitmap(map);
        	p.setColor(Color.BLUE);
        	BM_canvas.drawRect(0, 0, map.getWidth(), map.getHeight(), p);
        	p.setColor(Color.WHITE);
        	if (line.getPositive()){
        		BM_canvas.drawLine(0, map.getHeight(), map.getWidth(), 0, p);
        	}
        	else{
        		BM_canvas.drawLine(0, 0, map.getWidth(), map.getHeight(), p);
        		
        	}
        	canvas.drawBitmap(map, line_point.x, line_point.y, null);
        	
        }
        
        
        
        
        
        //draw things
		
	}

}
