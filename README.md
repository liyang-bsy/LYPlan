#LYPlan
=====
Release under LGPL license, consult your right before using.

##How to use

### XMLs

		Setup web.xml like test case:
			<servlet>
				<servlet-name>LYPlan</servlet-name>
				<servlet-class>net.vicp.lylab.util.timer.LYPlan</servlet-class>
				<load-on-startup>10</load-on-startup>
			</servlet>
			<servlet-mapping>
				<servlet-name>LYPlan</servlet-name>
				<url-pattern>/LYPlan/LYPlan</url-pattern>
			</servlet-mapping>
		
		Setup your timer jobs like below in applicationContext.xml:
			<bean name="testjob" class="***.***.timer.AvgComment" scope="prototype" />
		 
		Setup Plan as beans like below in applicationContext.xml:
			<bean name="plan" class="net.vicp.lylab.util.timer.Plan" scope="prototype">
				<property name="jobs">
					<list>
						<ref bean="testjob" /> <!-- and reference your job here! -->
					</list>
				</property>
			</bean>

### Java
//extends TimerJob and complete some methods...

//Tell Plan when this job start to work.
public Date getStartTime();

//Tell Plan how long should this job work again
public Integer getInterval();

//Override this method to perform your task!
public void run();

## Reading Finished? Freak out!
Thanks for reading this document and using my source!