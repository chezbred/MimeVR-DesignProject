package com.potechlab.mimicvr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class ToastView extends TextView {

    private boolean mAttached;
    AlphaAnimation textFadeAnimation;

    public ToastView(Context context) {
        super(context);
    }

    public ToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void shaw(String text, int duration){
        textFadeAnimation = new AlphaAnimation(1.0f, 0.0f);
        textFadeAnimation.setDuration(duration);

        setText(text);
        setGravity(Gravity.CENTER);
        setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        setTextColor(Color.parseColor("#FFFFFFFF"));
        setBackgroundColor(Color.BLACK);
        //setText(message);

        setVisibility(View.VISIBLE);
        textFadeAnimation.setAnimationListener(new EndAnimationListener() {
            public void onAnimationEnd(Animation animation) {
                setVisibility(View.GONE);
            }
        });
        startAnimation(textFadeAnimation);
    }

    private abstract class EndAnimationListener implements Animation.AnimationListener {
        @Override public void onAnimationRepeat(Animation animation) {}
        @Override public void onAnimationStart(Animation animation) {}
    }

    private final BroadcastReceiver mReceive = new BroadcastReceiver(){
        public void onReceive(Context context, Intent intent){
            String text =  intent.getExtras().getString("text");
            int duration =  intent.getExtras().getInt("duration");
            shaw(text, duration);
        }
    };

    protected void onAttachedToWindow(){
        super.onAttachedToWindow();
        if (!mAttached){
            mAttached = true;
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("com.mimicVR.SHOWTOAST");
            getContext().registerReceiver(mReceive, localIntentFilter, null, getHandler());
        }
        //Toast.makeText(getContext(), "Aryne Test", Toast.LENGTH_SHORT).show();
    }

    protected void onDetachedFromWindow(){
        super.onDetachedFromWindow();
        if (mAttached){
            getContext().unregisterReceiver(mReceive);
            mAttached = false;
        }
    }


}