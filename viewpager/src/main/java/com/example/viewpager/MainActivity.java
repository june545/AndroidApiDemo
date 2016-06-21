package com.example.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	ViewPager     viewPager;
	PagerTabStrip pagerTabStrip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		viewPager = (ViewPager) findViewById(R.id.viewPager);
		pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagerTabStrip);

		m();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	void m(){
		pagerTabStrip.setTabIndicatorColor(Color.BLUE);

		final ArrayList<View> viewContainter = new ArrayList<View>();
		final ArrayList<String> titleContainer = new ArrayList<String>();
		for(int i=0; i < 5; i++){
			View view = getLayoutInflater().inflate(R.layout.tab_content, null);
			TextView tv = (TextView) view.findViewById(R.id.text);
			tv.setText("Content " + i);
//			TextView textView = new TextView(this);
//			textView.setText("Content " + i);
//			textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
			viewContainter.add(view);
			titleContainer.add("content" + i);
		}


		viewPager.setAdapter(new PagerAdapter() {
			@Override
			public int getCount() {
				return viewContainter.size();
			}

			@Override
			public boolean isViewFromObject(View view, Object object) {
				return view == object;
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				container.addView(viewContainter.get(position));
				return viewContainter.get(position);
			}

			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				container.removeView(viewContainter.get(position));
			}

			@Override
			public CharSequence getPageTitle(int position) {
				return titleContainer.get(position);
			}
		});


	}

}
