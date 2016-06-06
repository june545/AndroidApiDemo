package com.example.hp.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	RecyclerView recyclerView;

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
				final Snackbar snackbar = Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG);
						snackbar.setAction("Action", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
//								Toast.makeText(getApplicationContext(),"touch action", Toast.LENGTH_LONG).show();
								startActivity(new Intent(getApplicationContext(), CollapsingToolbarLayoutActivity.class));
							}
						}).show();
			}
		});

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);


//		recyclerView = (RecyclerView) findViewById(R.id.recyView);
//		recyclerView.setLayoutManager(new LinearLayoutManager(this));
//		recyclerView.setAdapter(new MyAdapter());

	}


	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.nav_camera) {
			// Handle the camera action
		} else if (id == R.id.nav_gallery) {

		} else if (id == R.id.nav_slideshow) {

		} else if (id == R.id.nav_manage) {

		} else if (id == R.id.nav_share) {

		} else if (id == R.id.nav_send) {
		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

		List<String> list = null;

		public MyAdapter() {
			list = new ArrayList<>();
			for (int i = 0; i < 50; i++) {
				list.add("" + i);
			}
		}

		@Override
		public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			TextView tv = new TextView(MainActivity.this);
			tv.setTag("tv");
			MyViewHolder myViewHolder = new MyViewHolder(tv);
			return myViewHolder;
		}

		@Override
		public void onBindViewHolder(MyViewHolder holder, int position) {
			holder.tv.setText(list.get(position));
		}

		@Override
		public int getItemCount() {
			return list.size();
		}

		class MyViewHolder extends RecyclerView.ViewHolder {
			TextView tv;

			public MyViewHolder(View itemView) {
				super(itemView);
				tv = (TextView) itemView.findViewWithTag("tv");
			}
		}
	}

	private void input() {
		Log.d("TTTT", "============== t1 " + System.currentTimeMillis());
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Log.d("TTTT", "============== t2 " + System.currentTimeMillis());
				test2();
			}
		}, 10000);
	}

	private void test() {
		try {
			Process process = Runtime.getRuntime().exec("su");

			process.waitFor();

			//            DataOutputStream dos = new DataOutputStream(process.getOutputStream());
			//            dos.writeChars("input keyevent 4 \n");
			//            dos.flush();

			//            process.waitFor();

			InputStream os = process.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(os);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			List<String> ret = new ArrayList<String>();
			String s;
			while ((s = bufferedReader.readLine()) != null) {
				ret.add(s + "\n");
			}
			Log.d("TTT", "============ " + ret);

			DataOutputStream dos = new DataOutputStream(process.getOutputStream());
			dos.writeChars("input keyevent 4 \n");
			dos.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void test2() {
		try {
			Runtime.getRuntime().exec("input keyevent 4");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
