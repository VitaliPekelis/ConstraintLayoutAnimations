package com.lpirro.constraintlayoutanimations;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class ImageJavaActivity extends AppCompatActivity
{

    ConstraintLayout parentConstraint;
    TimeInterpolator interpolator;
    boolean set = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_java);
        initViews();
    }

    private void initViews() {

        parentConstraint = findViewById(R.id.root);

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onImageClick();
            }
        });
    }

    private void onImageClick()
    {
        ChangeBounds  transition    = new ChangeBounds();
        ConstraintSet constraintSet = new ConstraintSet();

        //if(interpolator == null) interpolator = new OvershootInterpolator();
        if(interpolator == null) interpolator = new FastOutSlowInInterpolator();


        transition.setInterpolator(interpolator);
        transition.setDuration(800);

        if(set)
        {
            constraintSet.clone(this, R.layout.activity_image_java);
        }
        else
        {
            constraintSet.clone(this, R.layout.activity_image_java_alt);
        }

        set = !set;

        TransitionManager.beginDelayedTransition(parentConstraint, transition);
        constraintSet.applyTo(parentConstraint);
    }
}
