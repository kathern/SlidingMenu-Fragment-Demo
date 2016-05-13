package com.comeon.slidingmenu;

import com.comeon.slidingmenu.fragment.LeftFragment;
import com.comeon.slidingmenu.fragment.MainFragment;
import com.comeon.slidingmenu.fragment.RightFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;

public class SlidingMenuMainActivity extends SlidingFragmentActivity {

	private Fragment mContent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState != null) {
			mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
		}
		if (mContent == null) {
			mContent = new MainFragment("First");
		}
		FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
		fm.replace(R.id.main, mContent);
		fm.commit();
		initSlidingMenu();
	}

	private void initSlidingMenu() {
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenWidth = dm.widthPixels;
		SlidingMenu sm = getSlidingMenu();// 获取slidingmenu
		setBehindContentView(R.layout.left);
		sm.setSecondaryMenu(R.layout.right);
		sm.setMode(SlidingMenu.LEFT_RIGHT);// 设置可滑动模式：LEFT左滑，RIGHT右滑，LEFT_RIGHT左右均可滑
		sm.setBehindOffset(screenWidth / 3);// 设置主界面偏移量
		sm.setFadeDegree(0.3f);// 设置淡入淡出比例
		sm.setShadowWidth(8);// 设置阴影宽度
		sm.setShadowDrawable(R.drawable.shadow);// 设置左菜单阴影样式
		sm.setSecondaryShadowDrawable(R.drawable.shadow);// 设置右菜单阴影样式
		sm.setFadeEnabled(true);// 设置滑动时菜单的是否淡入淡出
		sm.setBehindScrollScale(0.333f);// 设置滑动时拖拽效果
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		FragmentTransaction fm1 = getSupportFragmentManager().beginTransaction();
		fm1.replace(R.id.left, new LeftFragment());// 使用Fragment作为侧滑菜单的布局容器
		fm1.commit();
		FragmentTransaction fm2 = getSupportFragmentManager().beginTransaction();
		fm2.replace(R.id.right, new RightFragment());
		fm2.commit();

	}

	public void switchContent(Fragment fragment) {
		getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
		getSlidingMenu().showContent();
	}
}
