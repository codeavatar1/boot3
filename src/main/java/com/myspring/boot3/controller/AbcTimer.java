
package com.myspring.boot3.controller;
import yahoofinance.YahooFinance;
import java.util.*;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.ArrayList;
import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;
import java.util.Date;




import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AbcTimer {
	public Integer count =100;  
	Logger myLogger =LoggerFactory.getLogger(AbcTimer.class);
	Logger analytics = LoggerFactory.getLogger("analytics");
	AbcTimeSeries dts = new AbcTimeSeries();
	Timer timer;

	
	public void runTimer() {
		
		//TimerTask timerTask = new MyTimerTask();
    //running timer task as daemon thread
timer = new Timer(true);
    timer.scheduleAtFixedRate(new TimerTask() {
    	public void run() {        completeTask(); count++;}
    }, 0, 30*1000);
  
    System.out.println("TimerTask started");
    myLogger.info("Hello World");
    
    
    
 /*
    try {
        //Thread.sleep(120000*30);
    } catch (InterruptedException e) {
        e.printStackTrace();
        
    }
    timer.cancel();
    myLogger.info("TimerTask cancelled");
    */
    myLogger.info("++++dts.getStats");
    myLogger.info(dts.getStats().toString());
    
    
    
}
	//run method
    public void run() {

        completeTask();
        
    }

    private void completeTask() {
		YahooFinance yf = new YahooFinance();
		String symbol="esu20";
		//"^GSPC" ^SP500FTR
		try{
		
			Stock stock= yf.get(symbol);
		StockQuote quote = stock.getQuote();
this.dts.addSeriesElement(quote);

		
		}
		catch(java.io.IOException e){
			myLogger.info(e.toString());
		}
        
         
    }
    public void getStats() {
    	
    	
    }
    public void stop() {
    	timer.cancel();
    }
    public void start() {
    	this.runTimer();
    }
    
    public ArrayList<Object>getFulldata(){
    	return dts.getFulldata();
    }
    public List<QuoteLineVO>getAllQuotes()	{
    	return dts.getAllQuotes(); 
    }
    }

