package com.potechlab.mimicvr.fakeybord;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

public class CustomKeyboardButton extends Button {

    public CustomKeyboardButton(Context context){
        super(context);
        init();
    }

    public CustomKeyboardButton(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init();
    }

    public void init(){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(45, 70);
        setLayoutParams(layoutParams);

        setTextColor(Color.WHITE);
        setTextSize(10);
        setBackgroundColor(Color.parseColor("#FF212121"));
    }
}
