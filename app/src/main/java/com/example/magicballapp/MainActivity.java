package com.example.magicballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{




    private ImageView mImageViewBall;

    private Button mButtonGenerateAnswer;

    private int [] ballsID = {R.drawable.ball1, R.drawable.ball2,R.drawable.ball3,R.drawable.ball4,R.drawable.ball5};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageViewBall = (ImageView) findViewById(R.id.imageViewBall);

        mButtonGenerateAnswer = (Button) findViewById(R.id.buttonAnswer);
    }

    public void generateAnswer(View view)
    {
        int index = new Random().nextInt(5);

        Animation fadeIn = new AlphaAnimation(0 , 1);

        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(3000);



        AnimationSet animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeIn);

        mImageViewBall.setAnimation(animation);

        mImageViewBall.setImageResource(ballsID[index]);

        mButtonGenerateAnswer.setText(R.string.the_answer_is);

    }
}

