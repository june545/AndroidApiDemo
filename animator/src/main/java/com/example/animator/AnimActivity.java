package com.example.animator;

import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by June on 2016/6/22.
 */
public class AnimActivity extends AppCompatActivity {
	LinearLayout rootView;
	ImageView img;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a);

		rootView = (LinearLayout) findViewById(R.id.rootview);
		img = (ImageView) findViewById(R.id.imgView);

		img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				m();
			}
		});
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	void m() {
		ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 100);
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int value = (int) animation.getAnimatedValue();

				int left = value - img.getWidth() / 2;
				int top = value - img.getHeight() / 2;
				int width = left + img.getWidth();
				int height = top + img.getHeight();
				img.layout(left, top, width, height);
			}
		});
		valueAnimator.setDuration(5000);
		valueAnimator.start();
	}
}
