package com.zhy.viewpagerIndicator;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

import com.zhy.view.ColorTrackView;

public class ViewPagerUseActivity extends FragmentActivity
{
	private String[] mTitles = new String[] { "简介", "评价", "相关" };
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private TabFragment[] mFragments = new TabFragment[mTitles.length];
	private List<ColorTrackView> mTabs = new ArrayList<ColorTrackView>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vp_main);

		initViews();
		initDatas();
		initEvents();
	}

	private void initEvents()
	{
		mViewPager.setOnPageChangeListener(new OnPageChangeListener()
		{
			@Override
			public void onPageSelected(int position)
			{
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels)
			{
				if (positionOffset > 0)  
		        {  
					ColorTrackView left = mTabs.get(position);  
					ColorTrackView right = mTabs.get(position + 1);  
					
					left.setDirection(1);
					right.setDirection(0);
					Log.e("TAG", positionOffset+"");
		            left.setProgress( 1-positionOffset);  
		            right.setProgress(positionOffset);  
		        }  
			}

			@Override
			public void onPageScrollStateChanged(int state)
			{

			}
		});

	}

	private void initDatas()
	{

		for (int i = 0; i < mTitles.length; i++)
		{
			mFragments[i] = (TabFragment) TabFragment.newInstance(mTitles[i]);
		}

		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
		{
			@Override
			public int getCount()
			{
				return mTitles.length;
			}

			@Override
			public Fragment getItem(int position)
			{
				return mFragments[position];
			}

		};

		mViewPager.setAdapter(mAdapter);
		mViewPager.setCurrentItem(0);
	}

	private void initViews()
	{
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		
		mTabs.add((ColorTrackView) findViewById(R.id.id_tab_01));
		mTabs.add((ColorTrackView) findViewById(R.id.id_tab_02));
		mTabs.add((ColorTrackView) findViewById(R.id.id_tab_03));
	}

}
