package com.example.initial_game;



import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity{

	private Handler frame = new Handler();
	private static final int FRAME_RATE = 20;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Handler h = new Handler();
		

		h.postDelayed(new Runnable() {
            @Override
            public void run() {
                    initGfx();
            }
		}, 1000);
		
		initialGameView drawView = (initialGameView) findViewById(R.id.the_canvas);
        MyOnTouchListener listener = new MyOnTouchListener();
        drawView.setOnTouchListener(listener);
        drawView.requestFocus();
	}
	
	class MyOnTouchListener implements OnTouchListener{

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			switch(event.getAction()){
            case (MotionEvent.ACTION_DOWN):
            initialGameView drawView = (initialGameView) findViewById(R.id.the_canvas);
        	drawView.onTouch(v, event);
              break;
            }
			return false;
		}
		
	}
	
	synchronized public void initGfx(){
		
		//write stuff
		
		frame.removeCallbacks(frameUpdate);
        frame.postDelayed(frameUpdate, FRAME_RATE);
	}

	private Runnable frameUpdate = new Runnable(){

		@Override
		public void run() {
			frame.removeCallbacks(frameUpdate);
			//write stuff
			
			frame.postDelayed(frameUpdate, FRAME_RATE);
		}
		
		
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}
