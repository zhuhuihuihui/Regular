package com.regular.Model;

import java.util.Calendar;


/** Describe a period of time
 *  also represent the date of a cell.
 *  @category Data Model
 *  @author Scott.zhu
 *  */
public class Period 
{
	private Calendar start;
	private Calendar end;
	private Calendar length;
	private String details;

	public Period()
	{
		this.start = Calendar.getInstance();
		this.end   = Calendar.getInstance();
		this.length= Calendar.getInstance();
		countLength();
	}
	
	public Period(Calendar startCalendar, Calendar endCalendar, String detailString)
	{
		this.start = startCalendar;
		this.end   = endCalendar;
		this.details = detailString;
		countLength();
	}

	/**Return the float value of a time point
	 * @example 9:30AM equals 9.5*/
	public Float getStartWithFloat()
	{
		Float ret 	= (float) 0.0;
		int hour 	= this.start.get(Calendar.HOUR_OF_DAY);
		int minute 	= this.start.get(Calendar.MINUTE);
		ret = (float) ((minute / (float)60.0) + hour);
		return ret;
	}
	
	/**Return the float value of a time point
	 * @example 9:30AM equals 9.5*/
	public Float getEndWithFloat()
	{
		Float ret 	= (float) 0.0;
		int hour 	= this.end.get(Calendar.HOUR_OF_DAY);
		int minute 	= this.end.get(Calendar.MINUTE);
		ret = (float) ((minute / (float)60.0) + hour);
		return ret;
	}
	
	public Float getLengthWithFloat()
	{
		Float ret 	= (float) 0.0;
		int hour 	= this.length.get(Calendar.HOUR_OF_DAY);
		int minute 	= this.length.get(Calendar.MINUTE);
		ret = (float) ((minute / (float)60.0) + hour);
		return ret;
	}

	public void countLength()
	{
	    if (this.end.get(Calendar.MINUTE) >= this.start.get(Calendar.HOUR_OF_DAY))
	    {
	    	this.length.set(Calendar.HOUR_OF_DAY, this.end.get(Calendar.HOUR_OF_DAY) - this.start.get(Calendar.HOUR_OF_DAY));
	    	this.length.set(Calendar.MINUTE, this.end.get(Calendar.MINUTE) - this.start.get(Calendar.MINUTE));
	    }
	    else
	    {	/**½øÎ»²Ù×÷*/
	    	this.length.set(Calendar.HOUR_OF_DAY, this.end.get(Calendar.HOUR_OF_DAY) - this.start.get(Calendar.HOUR_OF_DAY) - 1);
	    	this.length.set(Calendar.MINUTE, this.end.get(Calendar.MINUTE) - this.start.get(Calendar.MINUTE) + 60);
	    }
	}

	public Calendar getStart() 
	{
		return this.start;
	}

	/**Set Start by Calendar*/
	public void setStart(Calendar start) 
	{
		this.start = start;
		countLength();
	}
	/**Set Start by field&value*/
	public void setStart(int field, int value) 
	{
		this.start.set(field, value);
		countLength();
	}

	public Calendar getEnd() 
	{
		return this.end;
	}

	/**Set End by Calendar*/
	public void setEnd(Calendar end) 
	{
		this.end = end;
		countLength();
	}
	/**Set End by field&value*/
	public void setEnd(int field, int value) 
	{
		this.end.set(field, value);
		countLength();
	}

	public String getDetails() 
	{
		return this.details;
	}

	public void setDetails(String details) 
	{
		this.details = details;
	}
	
	public Calendar getLength()
	{
		return this.length;
	}
	

}