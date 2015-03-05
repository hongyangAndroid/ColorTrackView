package com.zhy.viewpagerIndicator;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.zhy.view.ColorTrackView;

public class SimpleUseActivity extends Activity
{

	ColorTrackView mView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_main);
		mView = (ColorTrackView) findViewById(R.id.id_changeTextColorView);
		

	}

	@SuppressLint("NewApi")
	public void startLeftChange(View view)
	{
		mView.setDirection(0);
		ObjectAnimator.ofFloat(mView, "progress", 0, 1).setDuration(2000)
				.start();
	}

	@SuppressLint("NewApi")
	public void startRightChange(View view)
	{
		mView.setDirection(1);
		ObjectAnimator.ofFloat(mView, "progress", 0, 1).setDuration(2000)
				.start();
	}

}
