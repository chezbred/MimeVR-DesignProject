package com.potechlab.mimicvr;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.potechlab.mimicvr.fakeybord.FakeKeyboard;

public class SuperKeyboardView extends LinearLayout {

    FakeKeyboard right;
    FakeKeyboard left;

    public SuperKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        setLayoutParams(params);

        right = new FakeKeyboard(context);
        left = new FakeKeyboard(context);
        layout(right);
        layout(left);
        addView(left);
        addView(right);
    }

    public void layout(LinearLayout view){
        LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT,1.0f);
        params.setMargins(65,65,65,65);
        view.setLayoutParams(params);
    }
}
