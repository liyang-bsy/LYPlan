package net.vicp.lylab.util.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * 
 * @author Young Lee
 * 
 * 	Extends TimerJob and reference to Plan(manager class).
 * 	Override run() to satisfy your needs.
 * 
 * 	Release Under GNU Lesser General Public License (LGPL).
 * 
 * @since 2014.5.21
 * @version 1.0.0
 * 
 */
public abstract class TimerJob extends TimerTask {

	protected static final int ONE_TIME_TASK = 0;
	protected static final int MILLISECOND = 1;
	protected static final int SECOND = 1000*MILLISECOND;
	protected static final int MINUTE = 60*SECOND;
	protected static final int HOUR = 60*MINUTE;
	protected static final int DAY = 24*HOUR;
	protected static final int WEEK = 7*DAY;
	
	/**
	 * Tell Plan when this job start to work.
	 * If the date is past, run() will be called immediately.
	 * 
	 * @return Date that this schedule will be first called
	 */
	public abstract Date getStartTime();
	/**
	 * Tell Plan how long should this job work again. i.e. this job will work repeatedly every a specific period since start time
	 * @return ONE_TIME_TASK/n*MILLISECOND/n*SECOND/n*MINUTE/n*HOUR/n*DAY/n*WEEK
	 * For Example: 3*HOUR + 16*MINUTE
	 */
	public abstract Integer getInterval();

	/**
	 * Override this method to perform your task!
	 */
	public abstract void run();

}
