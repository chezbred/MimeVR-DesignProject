package com.potechlab.mimicvr;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by asus on 4/11/2016.
 */
public class ContainerView extends RelativeLayout {

    Button toast;
    Button pointerX, pointerY;

    private ToastView toastView;
    LayoutInflater inflater;

    int countX = 0;
    int countY = 0;
    Handler handle = new Handler();

    Runnable s  = new Runnable() {
        public void run() {
            beastmodeCLICK_Y();
        }
    };

    public ContainerView(Context context){
        super(context);
        containlayout();
    }

    public ContainerView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        containlayout();
    }

    public void containlayout(){
        toastView = new ToastView(getContext());
        inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        addView(inflater.inflate(R.layout.container, null)); //dito papasok yung layout

        toast = (Button) findViewById(R.id.toast);
        pointerX = (Button) findViewById(R.id.pointerX);
        pointerY = (Button) findViewById(R.id.pointerY);

        toast.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                showToast("Aryne", 3000);
            }
        });
        pointerX.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                beastmodeCLICK_X();
            }
        });
        pointerY.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                beastmodeCLICK_Y();
            }
        });
    }

    /**
     * HORIZONTAL
     * 1 = 555 ==> 555 kasi yung screen ng phone ko 1280 bale
     * 1280/2 - 85 = 555
     * 2 = 556
     * 3 = 558
     * 4 = 560
     *
     * VERTICAL
     * 1 = 635
     * 720 - 85 ulit
     * 2 = 636
     * 3 = 638
     * 4 = 640
     *
     * ung 85 kinuha ko doon sa sinet ko sa overlayview
     */

    Runnable r  = new Runnable() {
        public void run() {
            beastmodeCLICK_X();
        }
    };

    public void beastmodeCLICK_X(){
        countX+=4;
        if(countX==560){
            countX = 0;
            handle.removeCallbacks(r);
        }else{
            handle.postDelayed(r, 1);
            Intent intent = new Intent();
            intent.setAction("com.mimicVR.POINTER");
            intent.putExtra("horizontal", countX);
            intent.putExtra("vertical", countY);
            getContext().sendBroadcast(intent);
        }
    }

    public void beastmodeCLICK_Y(){
        countY+=4;
        if(countY==640){
            countY = 0;
            handle.removeCallbacks(s);
        }else{
            handle.postDelayed(s, 1);
            Intent intent = new Intent();
            intent.setAction("com.mimicVR.POINTER");
            intent.putExtra("horizontal", countX);
            intent.putExtra("vertical", countY);
            getContext().sendBroadcast(intent);
        }
    }

    public void clicked(){
        Intent intent = new Intent();
        intent.setAction("com.mimicVR.POINTER");
        intent.putExtra("horizontal", 40);
        intent.putExtra("vertical", 0);
        getContext().sendBroadcast(intent);
    }

    public void showToast(String text, int duration){
        Intent intent = new Intent();
        intent.setAction("com.mimicVR.SHOWTOAST");
        intent.putExtra("text", text);
        intent.putExtra("duration", duration);
        getContext().sendBroadcast(intent);
    }


}
