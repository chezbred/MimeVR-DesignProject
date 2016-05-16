package com.potechlab.mimicvr;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class SuperView extends LinearLayout{

	EyeView right;
	EyeView left;	

	public SuperView(Context context, AttributeSet attrs) {
		super(context, attrs);

		setOrientation(LinearLayout.HORIZONTAL);
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		setLayoutParams(params);
		
		right = new EyeView(context);
		left = new EyeView(context);
		layout(right);
		layout(left);
		addView(left);
		addView(right);
	}
	
	public void layout(RelativeLayout view){
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT,1.0f);
		params.setMargins(65,65,65,65);
		view.setLayoutParams(params);
		//view.setOrientation(LinearLayout.VERTICAL);
		//view.setBackgroundColor(Color.BLACK);
		//view.setBackgroundColor(Color.MAGENTA);
	}

	
}
