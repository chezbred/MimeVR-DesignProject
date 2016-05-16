package com.potechlab.mimicvr;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class EyeView extends RelativeLayout{

	ToastView toastView;
	ContainerView containerView;
	
	public EyeView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initRel();
	}
	
	public EyeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initRel();
	}

	public void initRel(){

		containerView = new ContainerView(getContext());
		toastView = new ToastView(getContext());

		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		setLayoutParams(params);
		LayoutParams paramToast = new LayoutParams(LayoutParams.FILL_PARENT, 60);
		paramToast.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		toastView.setLayoutParams(paramToast);

		addView(containerView);
		addView(toastView);
	}
}
