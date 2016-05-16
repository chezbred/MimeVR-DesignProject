package com.potechlab.mimicvr;

import android.os.Bundle;

import com.google.vrtoolkit.cardboard.CardboardActivity;
import org.rajawali3d.cardboard.RajawaliCardboardView;

public class MainActivity extends CardboardActivity {

    private RenderSphere renderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RajawaliCardboardView view = (RajawaliCardboardView)findViewById(R.id.cardboard_view);

        setCardboardView(view);

        renderer = new RenderSphere(this);
        view.setRenderer(renderer);
        view.setSurfaceRenderer(renderer);
    }
}
