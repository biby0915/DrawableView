package com.zby.drawableviewdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zby.drawableview.DrawableTextView;
import com.zby.drawableview.background.TextDrawableBackground;
import com.zby.drawableview.background.TextDrawableBackgroundImpl;

public class MainActivity extends AppCompatActivity {

    private DrawableTextView tv;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        tv.setOnDrawableClickListener(new TextDrawableBackgroundImpl.OnDrawableClickListener() {
            @Override
            public void onClick(TextDrawableBackground.Position position) {
                Toast.makeText(getApplicationContext(), position.name(), Toast.LENGTH_SHORT).show();
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAnimation();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void playAnimation() {
        View tv = findViewById(R.id.tv);
        ObjectAnimator animator = ObjectAnimator.ofInt(tv, "cornerRadius", 0, 99);
        animator.setDuration(3000);
        animator.start();

        ObjectAnimator colorAnimator = ObjectAnimator.ofArgb(tv, "solidColor", 0xFFFF0000, 0xFF0000FF);
        colorAnimator.setDuration(3000);
        colorAnimator.start();
    }
}
