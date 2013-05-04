package com.regular.View;

import java.util.jar.Attributes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.ListView;

/**专门用于绘制时间表的类（继承自ListView）
 * @author Scott.Zhu*/
public class TimeTableListView extends ListView
{

	public TimeTableListView(Context context) 
	{
		super(context);
	}

	public TimeTableListView(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
	}
	
	public TimeTableListView(Context context, AttributeSet attrs, int defStyle) 
	{
		super(context, attrs, defStyle);
	}
	
	@Override
	protected void onDraw(Canvas canvas) 
	{
		super.onDraw(canvas);
		int mov_x = 0;//声明起点坐标
  	    int mov_y = 100;
  	    Paint paint;//声明画笔
  	    Bitmap bitmap;//位图
  	    paint=new Paint(Paint.DITHER_FLAG);//创建一个画笔
  	    bitmap = Bitmap.createBitmap(480, 854, Bitmap.Config.ARGB_8888); //设置位图的宽高
  	    canvas.setBitmap(bitmap);
  	    
  	    paint.setStyle(Style.STROKE);//设置非填充
  	    paint.setStrokeWidth(5);//笔宽5像素
  	    paint.setColor(Color.RED);//设置为红笔
  	    paint.setAntiAlias(true);//锯齿不显示
  	    canvas.drawLine(mov_x, mov_y, 100, 100, paint);//画线
	}
}
