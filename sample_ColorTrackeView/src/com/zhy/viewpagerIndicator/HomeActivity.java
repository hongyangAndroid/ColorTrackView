package com.zhy.viewpagerIndicator;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeActivity extends ListActivity
{
	private String[] mStrs = new String[] { "Simple Use", "ViewPager Use" };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		getListView().setAdapter(
				new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1, mStrs));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		Intent intent = null;
		switch (position)
		{
		case 0:
			intent = new Intent(this,SimpleUseActivity.class);
			break;
		case 1:
			intent = new Intent(this,ViewPagerUseActivity.class);
			break;
		}
		
		if(intent != null ) startActivity(intent);
	}

}
