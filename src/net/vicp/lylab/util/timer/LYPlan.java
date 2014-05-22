package net.vicp.lylab.util.timer;

import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Young Lee
 * 
 * 	LYPlan is a tiny schedule framework, could be apply to multitude purpose.<br>
 * 
 * 	Release Under GNU Lesser General Public License (LGPL).
 * 
 * @since 2014.5.21
 * @version 1.0.0
 * 
 */
public class LYPlan extends HttpServlet {

	private TimerJob[] jobs = null;
	
	private static final long serialVersionUID = 1L;
	private static boolean Scheduled = false;
	
	@Override
	public void init() throws ServletException {
		
		System.out.println("LYPlan - Initialization started");

		ApplicationContext apx = new ClassPathXmlApplicationContext("applicationContext*.xml");
		LYPlan plan = (LYPlan)apx.getBean("lyplan");
		
		LYPlan.BeginSchedule(plan);
		
		super.init();
	}
	
	public static void BeginSchedule(LYPlan plan) {
		if (Scheduled)
			return;
		else
			Scheduled = true;
		Timer timer = new Timer();
		for(TimerJob bj:plan.getJobs())
		{
			if(bj.getInterval()!=0)
				timer.schedule(bj, bj.getStartTime(), bj.getInterval());
			else
				timer.schedule(bj, bj.getStartTime());
			System.out.println("LYPlan - Load Schedule Job: " + bj.getClass().getName());
		}
	}
	
	public TimerJob[] getJobs() {
		return jobs;
	}
	
	public void setJobs(TimerJob[] jobs) {
		this.jobs = jobs;
	}
	
}
