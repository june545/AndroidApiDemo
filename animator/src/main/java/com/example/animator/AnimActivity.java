package com.example.animator;

import android.animation.ObjectAnimator;
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
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by June on 2016/6/22.
 */
public class AnimActivity extends AppCompatActivity {
	LinearLayout rootView;
	ImageView    img;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a);

		rootView = (LinearLayout) findViewById(R.id.rootview);
		img = (ImageView) findViewById(R.id.imgView);

		rootView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				m4();
			}
		});
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	void m() {
		// 属性动画，根据view属性值变化，自己手动刷新view位置、形态
		ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 500);
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int value = (int) animation.getAnimatedValue();

				int left = value + img.getWidth() / 2;
				int top = value + img.getHeight() / 2;
				int width = left + img.getWidth();
				int height = top + img.getHeight();
				img.layout(left, top, width, height);
			}
		});
		valueAnimator.setDuration(5000);
		valueAnimator.start();
	}

	/**
	 * 复合动画
	 */
	void m2() {

		ObjectAnimator animator = ObjectAnimator.ofFloat(img, "translationX", 0.0f, 350.0f, 0.0f);
		animator.setDuration(2500).start();
		ObjectAnimator animator1 = ObjectAnimator.ofFloat(img, "scaleX", 1.0f, 1.5f, 1.0f);
		animator1.setDuration(2000).start();

		ObjectAnimator animator3 = ObjectAnimator.ofFloat(img, "rotationX", 0.0f, 90.0f, 0.0F);
		animator3.setDuration(2000).start();

		ObjectAnimator animator4 = ObjectAnimator.ofFloat(img, "alpha", 1.0f, 0.3f, 1.0F);
		animator4.setDuration(2000).start();
	}

	void m3() {
		ObjectAnimator animator = ObjectAnimator.ofFloat(img, "alpha", 1.0f, 0.3f, 1.0F);
		animator.setDuration(2000);//动画时间
		animator.setInterpolator(new BounceInterpolator());//动画插值
		animator.setRepeatCount(-1);//设置动画重复次数
		animator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
		animator.setStartDelay(1000);//动画延时执行
		animator.start();
	}

	/**
	 * 旋转
	 */
	void m4(){
		ObjectAnimator animator = ObjectAnimator.ofFloat(img, "rotation", 0, 45, 90, 135, 180, 225, 270, 315, 360);
		animator.setDuration(2000);//动画时间
		animator.setInterpolator(new LinearInterpolator());//动画插值
		animator.setRepeatCount(-1);//设置动画重复次数
		animator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
		animator.setStartDelay(1000);//动画延时执行
		animator.start();
	}
}
