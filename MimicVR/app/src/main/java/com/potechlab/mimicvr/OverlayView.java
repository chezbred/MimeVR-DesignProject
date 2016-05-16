package com.potechlab.mimicvr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class OverlayView extends FrameLayout{
	private boolean mAttached;

	int screenWidth = 0, screenHeight = 0;
	
	ImageView imageviewLeft;
	ImageView imageviewRight;
	
	public OverlayView(Context context){
		super(context);
		
	}
	
	public OverlayView(Context context, AttributeSet attrs) {
		super(context, attrs);
		imageviewLeft = new ImageView(context);
		imageviewRight = new ImageView(context);
	}
	
	private final BroadcastReceiver mReceive = new BroadcastReceiver(){
		public void onReceive(Context context, Intent intent){
			int horizontal =  intent.getExtras().getInt("horizontal");
			int vertical =  intent.getExtras().getInt("vertical");
			//Toast.makeText(context, "Intent Extra RICE", Toast.LENGTH_SHORT).show();
			coordinates(horizontal,vertical);
	    }
	};
	
	protected void onAttachedToWindow(){
		super.onAttachedToWindow();
		if (!mAttached){
			mAttached = true;
			IntentFilter localIntentFilter = new IntentFilter();
			localIntentFilter.addAction("com.mimicVR.POINTER");
			getContext().registerReceiver(mReceive, localIntentFilter, null, getHandler());
	    }
		//Toast.makeText(getContext(), "Aryne Test", Toast.LENGTH_SHORT).show();
		coordinates(200,400);
	}
	
	protected void onDetachedFromWindow(){
	    super.onDetachedFromWindow();
	    if (mAttached){
	    	getContext().unregisterReceiver(mReceive);
	    	mAttached = false;
	    }
	}
	
	//yung leftview ang base natin, since parehas naman sila, so bale iduduplicate natin yung 
	//view sa right correspond sa screen size.
	public void coordinates(int hor, int ver){
		//remove natin kasi everyupdate magaad siya ng views, FC lang punta kaya clear then go
		removeView(imageviewLeft);
		removeView(imageviewRight);
		
		if (Build.VERSION.SDK_INT >= 11) {
	        Point size = new Point();
	        try {
	        	WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
	            wm.getDefaultDisplay().getRealSize(size);
	            screenWidth = size.x;
	            screenHeight = size.y;
	        } catch (NoSuchMethodError e) {
	            Log.i("Crisis", "aray");
	        }

	    } else {
	        DisplayMetrics metrics = new DisplayMetrics();
	        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
	        wm.getDefaultDisplay().getMetrics(metrics);
	        screenWidth = metrics.widthPixels;
	        screenHeight = metrics.heightPixels;
	    }
		
		//papasok ang condition dito para sa paglimit ng size papunta sa kabila


		if ((screenWidth/2) <= hor){
			hor = ((screenWidth/2)-85);
		}
		if ((screenHeight) <= ver){
			ver = screenHeight - 85;
		}
		if (65 >= hor){
			hor = 65;
		}
		if (65 >= ver){
			ver = 65;
		}
		
		LayoutParams paramsLeft = new LayoutParams(20, 20);
		paramsLeft.leftMargin = hor;
		paramsLeft.topMargin  = ver;

		LayoutParams paramsRight = new LayoutParams(20,20);
		paramsRight.leftMargin = 640 + hor;
		paramsRight.topMargin  = ver;
		
		imageviewLeft.setImageResource(R.drawable.pointer);
		imageviewRight.setImageResource(R.drawable.pointer);

		addView(imageviewLeft, paramsLeft);
		addView(imageviewRight, paramsRight);	
	}
}