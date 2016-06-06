package com.example.hp.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by June on 2016/6/6.
 */
public class CollapsingToolbarLayoutActivity extends AppCompatActivity {
	CollapsingToolbarLayout collapsingToolbarLayout;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2_);

		collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
		collapsingToolbarLayout.setTitle("Collapsing Title");
	}
}
