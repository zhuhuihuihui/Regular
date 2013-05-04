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

/**ר�����ڻ���ʱ�����ࣨ�̳���ListView��
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
		int mov_x = 0;//�����������
  	    int mov_y = 100;
  	    Paint paint;//��������
  	    Bitmap bitmap;//λͼ
  	    paint=new Paint(Paint.DITHER_FLAG);//����һ������
  	    bitmap = Bitmap.createBitmap(480, 854, Bitmap.Config.ARGB_8888); //����λͼ�Ŀ��
  	    canvas.setBitmap(bitmap);
  	    
  	    paint.setStyle(Style.STROKE);//���÷����
  	    paint.setStrokeWidth(5);//�ʿ�5����
  	    paint.setColor(Color.RED);//����Ϊ���
  	    paint.setAntiAlias(true);//��ݲ���ʾ
  	    canvas.drawLine(mov_x, mov_y, 100, 100, paint);//����
	}
}
