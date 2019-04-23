package com.example.lesson4_animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onButtonClick(View view) {


        ConstraintSet constSet = new ConstraintSet();
        constSet.clone(this, R.layout.second_activity);

        ConstraintLayout constraint= (ConstraintLayout)findViewById(R.id.container);
        Transition transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        transition.setDuration(1200);

        TransitionManager.beginDelayedTransition(constraint,transition);
        constSet.applyTo(constraint);
    }
}
