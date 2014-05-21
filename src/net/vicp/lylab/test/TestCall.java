package net.vicp.lylab.test;

import java.util.Calendar;
import java.util.Date;

import net.vicp.lylab.util.timer.TimerJob;

public class TestCall extends TimerJob {
	
	@Override
	public void run() {
		System.out.println("====================Started!!====================");
	}
	
	@Override
	public Date getStartTime() {
		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.DATE, cl.get(Calendar.DATE));			//今日
		cl.set(Calendar.HOUR, 4);
		cl.set(Calendar.AM_PM, Calendar.PM);
		cl.set(Calendar.MINUTE, 10);
		cl.set(Calendar.SECOND, 0);
		cl.set(Calendar.MILLISECOND, 0);
		return cl.getTime();
	}

	@Override
	public Integer getInterval() {
		return 1*MINUTE;
	}

}
