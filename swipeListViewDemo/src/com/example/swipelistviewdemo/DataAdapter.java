package com.example.swipelistviewdemo;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhy_swipelistview02.R;
import com.fortysevendeg.swipelistview.SwipeListView;

public class DataAdapter extends BaseAdapter
{

	private List<String> mDatas;
	private LayoutInflater mInflater;
	private SwipeListView mSwipeListView ;

	public DataAdapter(Context context, List<String> datas , SwipeListView swipeListView)
	{
		this.mDatas = datas;
		mInflater = LayoutInflater.from(context);
		mSwipeListView = swipeListView;
	}

	@Override
	public int getCount()
	{
		return mDatas.size();
	}

	@Override
	public Object getItem(int position)
	{
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		convertView = mInflater.inflate(R.layout.item, null);

		TextView tv = (TextView) convertView.findViewById(R.id.id_text);
		Button del = (Button) convertView.findViewById(R.id.id_remove);
		tv.setText(mDatas.get(position));
		del.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				mDatas.remove(position);
				notifyDataSetChanged();
				mSwipeListView.closeOpenedItems();
			}
		});
		
		return convertView;
	}

}
