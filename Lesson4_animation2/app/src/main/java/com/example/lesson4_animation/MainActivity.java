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
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
   /*private final ConstraintSet constSet = new ConstraintSet();
    private final ConstraintSet constSet2 = new ConstraintSet();*/

     ConstraintLayout constraint;
     //ConstraintSet currentSet;
    
    boolean show=false;

    ImageView imageV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
     
     constraint=(ConstraintLayout)findViewById(R.id.container);

     // constSet.clone(constraint);
     // constSet2.clone(MainActivity.this, R.layout.second_activity);

     // currentSet=constSet;


        imageV=findViewById(R.id.imageBack);
        imageV.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
      
            
            if(show){
                showComponents();
            }else{
                hideComponents();
            }


      /* currentSet=(currentSet== constSet ? constSet2 : constSet);

            TransitionManager.beginDelayedTransition(constraint);
            constSet.applyTo(constraint);*/
        }
    });
    }

    private void hideComponents() {
     show=false;
        ConstraintSet constSet = new ConstraintSet();
        constSet.clone(this, R.layout.activity_main);

        ConstraintLayout constraint= (ConstraintLayout)findViewById(R.id.container);
        Transition transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        transition.setDuration(1200);

        TransitionManager.beginDelayedTransition(constraint,transition);
        constSet.applyTo(constraint);

    }

    private void showComponents() {

     show=true;
     ConstraintSet constSet = new ConstraintSet();
        constSet.clone(this, R.layout.second_activity);

         ConstraintLayout constraint= (ConstraintLayout)findViewById(R.id.container2);
        Transition transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        transition.setDuration(1200);

        TransitionManager.beginDelayedTransition(constraint,transition);
        constSet.applyTo(constraint);
    }


}
