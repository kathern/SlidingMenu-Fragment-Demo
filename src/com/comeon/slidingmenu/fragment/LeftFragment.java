package com.comeon.slidingmenu.fragment;

import com.comeon.slidingmenu.R;
import com.comeon.slidingmenu.SlidingMenuMainActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LeftFragment extends Fragment {

	private View v;
	private ListView list;
	private Activity activity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragmen_left, null);
		list = (ListView) v.findViewById(R.id.list);
		return v;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = activity;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] name = { "First", "Two", "Three" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1,
				android.R.id.text1, name);

		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Fragment newContent = null;
				switch (position) {
				case 0:
					newContent = new MainFragment("First");
					break;
				case 1:
					newContent = new MainFragment("Two");
					break;
				case 2:
					newContent = new MainFragment("Three");
					break;

				default:
					break;
				}
				if (newContent != null) {
					switchFragment(newContent);
				}
			}
		});
	}

	public void switchFragment(Fragment fragment) {
		if (activity == null) {
			return;
		}
		SlidingMenuMainActivity mainActivity = (SlidingMenuMainActivity) activity;
		mainActivity.switchContent(fragment);
	}

}
