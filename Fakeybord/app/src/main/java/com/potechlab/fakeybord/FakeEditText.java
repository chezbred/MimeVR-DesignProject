package com.potechlab.fakeybord;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FakeEditText extends TextView {
    private boolean mAttached;

    public String new_text;

    public FakeEditText(Context context){
        super(context);
        initlayout();
    }
    public FakeEditText(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        initlayout();
    }
    public void initlayout(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), getText().toString(), Toast.LENGTH_SHORT).show();
                clicked(getText().toString());

            }
        });
    }

    public void clicked(String text){
        Intent intent = new Intent();
        intent.setAction("com.potechVR.KEYBOARD");
        intent.putExtra("text", text);

        getContext().sendBroadcast(intent);
    }

    private final BroadcastReceiver mReceive = new BroadcastReceiver(){
        public void onReceive(Context context, Intent intent){
            new_text = intent.getExtras().getString("new_text"); //galing Keyboard
            setText(new_text);
        }
    };

    protected void onAttachedToWindow(){
        super.onAttachedToWindow();
        if (!mAttached){
            mAttached = true;
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("com.potechVR.KEYTEXT");
            getContext().registerReceiver(mReceive, localIntentFilter, null, getHandler());
        }
    }

    protected void onDetachedFromWindow(){
        super.onDetachedFromWindow();
        if (mAttached){
            getContext().unregisterReceiver(mReceive);
            mAttached = false;
        }
    }



}
