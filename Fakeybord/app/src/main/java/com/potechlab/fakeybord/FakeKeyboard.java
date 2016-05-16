package com.potechlab.fakeybord;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FakeKeyboard extends LinearLayout {
    private boolean mAttached;

    public String global_text;

    LinearLayout l1; //ang laman done at textfield
    LinearLayout l2; //button ala keyboard okisaba na okinana!!!!
    LinearLayout l2_r1;
    LinearLayout l2_r2;
    LinearLayout l2_r3;

    //laman ng L1
    Button done;
    TextView text;

    //laman ng L2_r1
    Button q_button;
    Button w_button;
    Button e_button;
    Button r_button;
    Button t_button;
    Button y_button;
    Button u_button;
    Button i_button;
    Button o_button;
    Button p_button;

    //l2_r2
    Button a_button;
    Button s_button;
    Button d_button;
    Button f_button;
    Button g_button;
    Button h_button;
    Button j_button;
    Button k_button;
    Button l_button;

    //l2_r3
    Button z_button;
    Button x_button;
    Button c_button;
    Button v_button;
    Button b_button;
    Button n_button;
    Button m_button;

    public FakeKeyboard(Context context){
        super(context);
        init();
    }

    public FakeKeyboard(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init();
    }

    public void init(){
        removeAllViews();
        setVisibility(GONE);
        LinearLayout.LayoutParams superparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(superparams);
        setBackgroundColor(Color.WHITE);
        setOrientation(LinearLayout.VERTICAL);

        l1 = new LinearLayout(getContext());
        l2 = new LinearLayout(getContext());
        l2_r1 = new LinearLayout(getContext());
        l2_r2 = new LinearLayout(getContext());
        l2_r3 = new LinearLayout(getContext());

        LinearLayout.LayoutParams l1params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        l1.setLayoutParams(l1params);

        LinearLayout.LayoutParams l2params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        l2.setLayoutParams(l2params);
        l2.setOrientation(LinearLayout.VERTICAL);
        l2.setWeightSum(2.0f);

        LinearLayout.LayoutParams l2_r1params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 75, 1.0f);
        l2_r1.setLayoutParams(l2_r1params);
        l2_r2.setGravity(Gravity.CENTER);
        l2_r1.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams l2_r2params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 75, 1.0f);
        l2_r2.setGravity(Gravity.CENTER);
        l2_r2.setLayoutParams(l2_r2params);
        l2_r2.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams l2_r3params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 75, 1.0f);
        l2_r3.setGravity(Gravity.CENTER);
        l2_r3.setLayoutParams(l2_r3params);
        l2_r3.setOrientation(LinearLayout.HORIZONTAL);

        done = new Button(getContext());
        text = new TextView(getContext());
        l1.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams donel1params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 70, 4.0f);
        done.setLayoutParams(donel1params);
        done.setText("OK");
        done.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked(global_text);
                setVisibility(View.GONE);
            }
        });

        LinearLayout.LayoutParams textl1params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        text.setLayoutParams(textl1params);

        l1.addView(text);
        l1.addView(done);

        l2.addView(l2_r1);
        l2.addView(l2_r2);
        l2.addView(l2_r3);

        qwertyuiop();
        asdfghjkl();
        zxcvbnm();

        addView(l1);
        addView(l2);

    }

    public void qwertyuiop(){
        q_button = new Button(getContext());
        keybuttons(q_button, "Q");
        l2_r1.addView(q_button);

        w_button = new Button(getContext());
        keybuttons(w_button, "W");
        l2_r1.addView(w_button);

        e_button = new Button(getContext());
        keybuttons(e_button, "E");
        l2_r1.addView(e_button);

        r_button = new Button(getContext());
        keybuttons(r_button, "R");
        l2_r1.addView(r_button);

        t_button = new Button(getContext());
        keybuttons(t_button, "T");
        l2_r1.addView(t_button);

        y_button = new Button(getContext());
        keybuttons(y_button, "Y");
        l2_r1.addView(y_button);

        o_button = new Button(getContext());
        keybuttons(o_button, "O");
        l2_r1.addView(o_button);

        u_button = new Button(getContext());
        keybuttons(u_button, "U");
        l2_r1.addView(u_button);

        i_button = new Button(getContext());
        keybuttons(i_button, "I");
        l2_r1.addView(i_button);

        o_button = new Button(getContext());
        keybuttons(o_button, "O");
        l2_r1.addView(o_button);

        p_button = new Button(getContext());
        keybuttons(p_button, "P");
        l2_r1.addView(p_button);
    }

    public void asdfghjkl(){
        a_button = new Button(getContext());
        keybuttons(a_button, "A");
        l2_r2.addView(a_button);

        s_button = new Button(getContext());
        keybuttons(s_button, "S");
        l2_r2.addView(s_button);

        d_button = new Button(getContext());
        keybuttons(d_button, "D");
        l2_r2.addView(d_button);

        f_button = new Button(getContext());
        keybuttons(f_button, "F");
        l2_r2.addView(f_button);

        g_button = new Button(getContext());
        keybuttons(g_button, "G");
        l2_r2.addView(g_button);

        h_button = new Button(getContext());
        keybuttons(h_button, "H");
        l2_r2.addView(h_button);

        j_button = new Button(getContext());
        keybuttons(j_button, "J");
        l2_r2.addView(j_button);

        k_button = new Button(getContext());
        keybuttons(k_button, "K");
        l2_r2.addView(k_button);

        l_button = new Button(getContext());
        keybuttons(l_button, "L");
        l2_r2.addView(l_button);

    }

    public void zxcvbnm(){
        z_button = new Button(getContext());
        keybuttons(z_button, "Z");
        l2_r3.addView(z_button);

        x_button = new Button(getContext());
        keybuttons(x_button, "X");
        l2_r3.addView(x_button);

        c_button = new Button(getContext());
        keybuttons(c_button, "C");
        l2_r3.addView(c_button);

        v_button = new Button(getContext());
        keybuttons(v_button, "V");
        l2_r3.addView(v_button);

        b_button = new Button(getContext());
        keybuttons(b_button, "B");
        l2_r3.addView(b_button);

        n_button = new Button(getContext());
        keybuttons(n_button, "N");
        l2_r3.addView(n_button);

        m_button = new Button(getContext());
        keybuttons(m_button, "M");
        l2_r3.addView(m_button);
    }


    private final BroadcastReceiver mReceive = new BroadcastReceiver(){
        public void onReceive(Context context, Intent intent){
            setVisibility(VISIBLE);
            global_text = intent.getExtras().getString("text");
            text.setText(global_text);
        }
    };

    protected void onAttachedToWindow(){
        super.onAttachedToWindow();
        if (!mAttached){
            mAttached = true;
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("com.potechVR.KEYBOARD");
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

    public void clicked(String text){
        Intent intent = new Intent();
        intent.setAction("com.potechVR.KEYTEXT");
        intent.putExtra("new_text", text);
        getContext().sendBroadcast(intent);
    }

    public void keybuttons(final Button button, String characters){
        button.setText(characters);
        LinearLayout.LayoutParams a_buttonl1params = new LinearLayout.LayoutParams(60, 70);
        button.setLayoutParams(a_buttonl1params);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                global_text += button.getText().toString();
                text.setText(global_text);
            }
        });
    }

}
