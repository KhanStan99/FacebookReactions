package com.Example.khanstan.FacebookReactions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    private TextView txtPostStatus;
    private Button btnMain, btnLike, btnHaha, btnLove, btnCry, btnShock, btnAngry;
    private LinearLayout emojisLayout;
    private Animation animFadeIn, animFadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


    }

    private void initViews() {
        txtPostStatus = findViewById(R.id.txtPostStatus);
        btnMain = findViewById(R.id.btnClick);
        btnLike = findViewById(R.id.btnLike);
        btnHaha = findViewById(R.id.btnHaha);
        btnLove = findViewById(R.id.btnLove);
        btnCry = findViewById(R.id.btnCry);
        btnShock = findViewById(R.id.btnShock);
        btnAngry = findViewById(R.id.btnAngry);
        emojisLayout = findViewById(R.id.emojisLayout);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);

        animFadeIn.setAnimationListener(this);
        animFadeOut.setAnimationListener(this);

        emojisLayout.setVisibility(View.GONE);

        btnMain.setOnClickListener(this);
        btnLike.setOnClickListener(this);
        btnLove.setOnClickListener(this);
        btnHaha.setOnClickListener(this);
        btnCry.setOnClickListener(this);
        btnShock.setOnClickListener(this);
        btnAngry.setOnClickListener(this);

        btnMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                emojisLayout.startAnimation(animFadeIn);
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClick:
                txtPostStatus.setText(R.string.like);
                emojisLayout.setVisibility(View.GONE);
                btnMain.setText(R.string.like);
                break;
            case R.id.btnLike:
                txtPostStatus.setText(R.string.like);
                emojisLayout.startAnimation(animFadeOut);
                btnMain.setText(R.string.like);
                break;
            case R.id.btnLove:
                txtPostStatus.setText(R.string.love);
                emojisLayout.startAnimation(animFadeOut);
                btnMain.setText(R.string.love);
                break;
            case R.id.btnHaha:
                txtPostStatus.setText(R.string.haha);
                emojisLayout.startAnimation(animFadeOut);
                btnMain.setText(R.string.haha);
                break;
            case R.id.btnCry:
                txtPostStatus.setText(R.string.sad);
                emojisLayout.startAnimation(animFadeOut);
                btnMain.setText(R.string.sad);
                break;
            case R.id.btnShock:
                txtPostStatus.setText(R.string.shock);
                emojisLayout.startAnimation(animFadeOut);
                btnMain.setText(R.string.shock);
                break;
            case R.id.btnAngry:
                txtPostStatus.setText(R.string.angry);
                emojisLayout.startAnimation(animFadeOut);
                btnMain.setText(R.string.angry);
                break;
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation
        // check for fade in animation
        if (animation == animFadeOut) {
            emojisLayout.setVisibility(View.GONE);
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // Animation is repeating
    }

    @Override
    public void onAnimationStart(Animation animation) {
        // Animation started
        if (animation == animFadeIn) {
            emojisLayout.setVisibility(View.VISIBLE);
        }
    }
}
