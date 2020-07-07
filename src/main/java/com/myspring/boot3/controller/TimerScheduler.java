package com.myspring.boot3.controller;

import org.springframework.stereotype.Component;
import java.io.PrintStream;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@Component
public class TimerScheduler{
    private static final Logger log = LoggerFactory.getLogger(TimerScheduler.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Double counter =0.0;
    private Boolean Active =false;
	    public  Boolean getActive() {
		return Active;
	}
	public void setActive(Boolean active) {
		Active = active;
	}
		@Scheduled(fixedRate = 30*1000)
	    public void reportCurrentTime() {
	        log.info("The time is now {}", dateFormat.format(new Date()));
	        log.info(Active.toString());
	        counter +=0.5;
			if (counter ==1.0 || counter ==2.5) {
				//call powershell script 
				if(counter ==2.5) counter =0.0;
				//
	if (Active)runScript();
				}
			
		}
		
		
		
	    
		private void runScript() {
			
			try{
				
				//String cmd = "cmd C:\\users\\bvh8924\\msranabatch.bat";
				//String cmd = "C:\\users\\bvh8924\\msranabatch.bat";
				//String cmd ="cmd /c start C:\\Users\\bvh8924\\msranabatch.bat";
				String cmd ="cmd /c C:\\Users\\bvh8924\\msranabatch.bat";
				log.info("Came Exec script");
						Runtime runtime = Runtime.getRuntime();
						Process process = runtime.exec(cmd);
					 Integer retCode =process.waitFor();

						process.getOutputStream().close();
						log.info("Came Exec script after ");
						log.info(retCode.toString());


		}
			catch(Exception e){
				log.info(e.toString());
							}
		}


}
	
		
		

			
		



