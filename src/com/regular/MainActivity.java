package com.regular;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import com.regular.Model.Period;
import com.regular.Model.Periods;
import com.regular.View.TimeTableListView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	private final int TIMER_INTERVAL = 5000;
	/**每5秒钟，触发刷屏消息*/
	private final int MESSAGE_INTERVAL = 1;
	
	private TimeTableListView timeTableListView = null;
	TimeTableListAdapter timeTableListAdapter  = new TimeTableListAdapter(this);
	
	/**used to draw the time line*/
	Timer timer;
	Handler handler;
	/**Data Source*/
	private Periods periods = new Periods();
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);    
        requestWindowFeature(Window.FEATURE_NO_TITLE);     
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,       
                       WindowManager.LayoutParams. FLAG_FULLSCREEN);    
        
        setContentView(R.layout.main_activity);
        timeTableListView = (TimeTableListView) findViewById(R.id.mainActivity_timetableList);
		timeTableListView.setAdapter(timeTableListAdapter);
        
        timer = new Timer();
        
        
        handler = new Handler()
        {
        	@Override
        	public void handleMessage(Message msg) 
        	{
        		super.handleMessage(msg);
        		
        		switch (msg.what) 
        		{
				case MESSAGE_INTERVAL:
					//updateTimeLine();
					break;
				default:
					break;
				}
        	}
        };
        timer.schedule(new TimerTask() 
        {
			@Override
			public void run() 
			{
				/**每5秒钟发出一次刷新消息*/
				Log.i("Timer", "Bi..");
				Message msgMessage = new Message();
				msgMessage.what = MESSAGE_INTERVAL;
				handler.sendMessage(msgMessage);
			}
		}, 0, TIMER_INTERVAL);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	private  class TimeTableListAdapter extends BaseAdapter
    {

    	private Context context;
    	public TimeTableListAdapter(Context context) 
		{
			this.context = context;
		}
    	
		@Override
		public int getCount()
		{
			return periods.count();
		}

		@Override
		public Object getItem(int position) 
		{
			return periods.getPeriodByIndex(position);
		}

		@Override
		public long getItemId(int position) 
		{
			return position;
		}

	    private class TimeTableCellViewHolder extends View
	    {
	    	
			TextView startTimeTextView;
	    	TextView detailsTextView;
	    	public TimeTableCellViewHolder(Context context) 
	    	{
				super(context);
				startTimeTextView = new TextView(context);
				detailsTextView     = new TextView(context);
			}
	    }
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) 
		{
			/**Data for this cell*/
			Period period = periods.getPeriodByIndex(position);
			TimeTableCellViewHolder timeTableCellViewHolder = null;
			if (convertView == null) 
			{
				timeTableCellViewHolder = new TimeTableCellViewHolder(this.context);
				convertView = LayoutInflater.from(context).inflate(R.layout.cellof_mainactivity_timetablelist, null);
				timeTableCellViewHolder.startTimeTextView = (TextView) convertView.findViewById(R.id.startTimeTextView);
				timeTableCellViewHolder.detailsTextView = (TextView) convertView.findViewById(R.id.detailsTextView);
				convertView.setTag(timeTableCellViewHolder);
			} 
			else 
			{
				timeTableCellViewHolder = (TimeTableCellViewHolder) convertView.getTag();
			}
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			timeTableCellViewHolder.startTimeTextView.setText(timeFormat.format(period.getStart().getTime()));
			timeTableCellViewHolder.detailsTextView.setText(period.getDetails());
			
			/**Adjust the layout of the view*/
			DisplayMetrics displaymetrics = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
			int screenHeight = displaymetrics.heightPixels;
			float heightForThisItem = 0;
			float x = period.getLengthWithFloat();
			float y = periods.totalLengthPeriod().getLengthWithFloat();
			heightForThisItem = screenHeight * (period.getLengthWithFloat() / periods.totalLengthPeriod().getLengthWithFloat());
			convertView.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.FILL_PARENT, (int) heightForThisItem));
			return convertView;
		}
    	
    }
    

}
