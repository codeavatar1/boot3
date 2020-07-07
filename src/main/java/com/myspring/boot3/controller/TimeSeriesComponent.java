package com.myspring.boot3.controller;

import com.myspring.boot3.controller.AbcTimer;
import java.util.*;
import java.util.*;
import com.myspring.boot3.controller.TimerScheduler;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.context.annotation.Scope;

@Component
@Scope(value="application")
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)

public class TimeSeriesComponent{
	@Autowired
	private ApplicationContext context;
	TimerScheduler schedule30;
	private static final Logger log = LoggerFactory.getLogger(TimeSeriesComponent.class);

	private AbcTimer abcTimer = new AbcTimer();
	private Timer T30;
	private Double counter =0.0;    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	
	public void start() {
		System.out.println("Timeseries component came in before timer start");
		log.info("Timeseries component came in before timer start");
		abcTimer.runTimer();
		
		System.out.println("Timeseries component came in Aftere timer start");
			
	}
	public void stop() {
	
		System.out.println("Timeseries component came in before timer stop");
abcTimer.stop();
	}
	
	public void startFileMonitor() {
 
/*
		T30 =new Timer();
		
	T30	.scheduleAtFixedRate(new TimerTask() {
	    	public void run() {        completeTask(); }
	    }, 0, 30*1000);
	    */
schedule30 =(TimerScheduler)context.getBean(TimerScheduler.class);
schedule30.setActive(true);
		log.info("Timerscheduler");
		log.info(schedule30.toString());
		}
	private void completeTask() {
		counter +=0.5;
		if (counter ==1.0 || counter ==2.5) {
			//call powershell script 
			if(counter ==2.5) counter =0.0;
			//
runScript();
			}
		
	}
	
	
	public void stopFileMonitor() {
		//T30.cancel();
		schedule30.setActive(false);
		log.info("In stopfile monitor");
	}

	
		private void runScript() {
			
			try{
				
				//String cmd = "cmd C:\\users\\bvh8924\\msranabatch.bat";
				String cmd = "C:\\users\\bvh8924\\msranabatch.bat";
				//analytics.info("Came Exec script");
						Runtime runtime = Runtime.getRuntime();
						Process process = runtime.exec(cmd);
						process.getOutputStream().close();
						//analytics.info("Came Exec script after ");


		}
			catch(Exception e){
				log.info(e.toString());
							}
		}
			
			public List<QuoteLineVO> getAllQuotes(){
				return abcTimer.getAllQuotes();
				
				
			}
		}
