package com.han.guanggao;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	private ViewPager vp;
	private int[] resId = { R.drawable.a, R.drawable.b, R.drawable.c,
			R.drawable.d };
	private List<Fragment> listFragment = new ArrayList<Fragment>();
	private int index;
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			int w = msg.what;
			vp.setCurrentItem(w);
		};
	};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		vp = (ViewPager) findViewById(R.id.vp);
		for (int i = 0; i < 100; i++) {
			int j = i%4;
			MyFragment myFragment = new MyFragment(resId[j]);
			listFragment.add(myFragment);
		}
		MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
		vp.setAdapter(myAdapter);
		vp.setCurrentItem(0);

		new Thread() {
			public void run() {
				while(true){
					SystemClock.sleep(1500);
					
					index++;
					if(index==100){
						index=0;
					}
					handler.sendEmptyMessage(index);
					
				}
			};
		}.start();

	}

	private class MyAdapter extends FragmentPagerAdapter {

		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			return listFragment.get(arg0);
		}

		@Override
		public int getCount() {
			return listFragment == null ? 0 : listFragment.size();
		}

	}

}
