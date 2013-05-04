package com.regular.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/** Describe a list of period
 *  which is the data source of the ListView.
 *  @category Data Model
 *  @author Scott.zhu
 *  */
public class Periods 
{
	private List<Period> allPeriods;
	
	public Periods()
	{
		allPeriods = new ArrayList<Period>();
		
		Period p0 = new Period();
		p0.setStart(Calendar.HOUR_OF_DAY, 8);
		p0.setStart(Calendar.MINUTE, 30);
		p0.setEnd(Calendar.HOUR_OF_DAY, 9);
		p0.setEnd(Calendar.MINUTE, 30);
		allPeriods.add(p0);
		
		Period p1 = new Period();
		p1.setStart(Calendar.HOUR_OF_DAY, 9);
		p1.setStart(Calendar.MINUTE, 30);
		p1.setEnd(Calendar.HOUR_OF_DAY, 12);
		p1.setEnd(Calendar.MINUTE, 30);
		allPeriods.add(p1);
		
		Period p2 = new Period();
		p2.setStart(Calendar.HOUR_OF_DAY, 12);
		p2.setStart(Calendar.MINUTE, 30);
		p2.setEnd(Calendar.HOUR_OF_DAY, 13);
		p2.setEnd(Calendar.MINUTE, 30);
		allPeriods.add(p2);
		
		Period p3 = new Period();
		p3.setStart(Calendar.HOUR_OF_DAY, 13);
		p3.setStart(Calendar.MINUTE, 30);
		p3.setEnd(Calendar.HOUR_OF_DAY, 17);
		p3.setEnd(Calendar.MINUTE, 30);
		allPeriods.add(p3);
		
		Period p4 = new Period();
		p4.setStart(Calendar.HOUR_OF_DAY, 17);
		p4.setStart(Calendar.MINUTE, 30);
		p4.setEnd(Calendar.HOUR_OF_DAY, 18);
		p4.setEnd(Calendar.MINUTE, 30);
		allPeriods.add(p4);
		
		Period p5 = new Period();
		p5.setStart(Calendar.HOUR_OF_DAY, 18);
		p5.setStart(Calendar.MINUTE, 30);
		p5.setEnd(Calendar.HOUR_OF_DAY, 20);
		p5.setEnd(Calendar.MINUTE, 30);
		allPeriods.add(p5);
		
		Period p6 = new Period();
		p6.setStart(Calendar.HOUR_OF_DAY, 20);
		p6.setStart(Calendar.MINUTE, 30);
		p6.setEnd(Calendar.HOUR_OF_DAY, 22);
		p6.setEnd(Calendar.MINUTE, 30);
		allPeriods.add(p6);
		
		
	}
	
	/**Set the start of certain period*/
	public void setStartOfPeriod(Calendar start, int periodNum)
	{
		if (0 == periodNum)
		{
			Period oldOne = allPeriods.get(periodNum);
			oldOne.setStart(start);
			allPeriods.set(periodNum, oldOne);
		}
		else
		{
			Period oldOne    = allPeriods.get(periodNum);
			Period oldOnePre = allPeriods.get(periodNum - 1);
			oldOne.setStart(start);
			oldOnePre.setEnd(start);
			allPeriods.set(periodNum, oldOne);
			allPeriods.set(periodNum - 1, oldOnePre);
		}
	}
	
	/**Set the end of certain period*/
	public void setEndOfPeriod(Calendar end, int periodNum)
	{
		/**超出范围，非法输入*/
		if ((allPeriods.size() - 1) < periodNum) 
			return;
		
		if ((allPeriods.size() - 1) == periodNum)
		{
			Period oldOne = allPeriods.get(periodNum);
			oldOne.setEnd(end);
			allPeriods.set(periodNum, oldOne);
		}
		else
		{
			Period oldOne    = allPeriods.get(periodNum);
			Period oldOneNext = allPeriods.get(periodNum + 1);
			oldOne.setEnd(end);
			oldOneNext.setStart(end);
			allPeriods.set(periodNum, oldOne);
			allPeriods.set(periodNum + 1, oldOneNext);
		}
	}
	
	/**Set the details of certain period*/
	public void setDetailsOfPeriod(String detailsString, int periodNum)
	{
		if (periodNum < 0 || periodNum > (allPeriods.size() - 1))
			return;
		Period oldOne = allPeriods.get(periodNum);
		oldOne.setDetails(detailsString);
		allPeriods.set(periodNum, oldOne);
	}
	
	public Period getPeriodByIndex(int periodNum)
	{
		return allPeriods.get(periodNum);
	}
	
	public int count()
	{
		return allPeriods.size();
	}
	
	/**Return length of allPeriods*/
	public Period totalLengthPeriod()
	{
		Period ret = new Period();
		ret.setStart(allPeriods.get(0).getStart());
		ret.setEnd(allPeriods.get(count() - 1).getEnd());
		return ret;
	}

}
