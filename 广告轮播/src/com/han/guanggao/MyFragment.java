package com.han.guanggao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyFragment extends Fragment {
	private ImageView iv;
	private int resId;
	public MyFragment(int resId) {
		this.resId = resId;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			View v = inflater.inflate(R.layout.fragment_item, null);
			iv = (ImageView) v.findViewById(R.id.iv);
			iv.setImageResource(resId);
		return v;
	}
}
