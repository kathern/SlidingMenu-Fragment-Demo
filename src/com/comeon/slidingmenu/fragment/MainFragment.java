package com.comeon.slidingmenu.fragment;

import com.comeon.slidingmenu.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {

	private String name;
	private TextView tv;

	public MainFragment(String name) {
		this.name = name;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragmen_main, null);
		tv = (TextView) v.findViewById(R.id.name);
		tv.setText(name);
		return v;
	}

}
