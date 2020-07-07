package com.myspring.boot3.controller;

import java.util.HashMap;
import java.text.*;
import java.util.Date;
import java.util.GregorianCalendar; 

import java.util.Map;
import yahoofinance.quotes.stock.StockQuote;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import yahoofinance.Utils;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;
public class AbcTimeSeries {
	private ArrayList<BigDecimal> Price = new ArrayList<BigDecimal>();
	private ArrayList<BigDecimal> Bid = new ArrayList<BigDecimal>();

	private ArrayList<BigDecimal> Ask = new ArrayList<BigDecimal>();
	private ArrayList<BigDecimal> High = new ArrayList<BigDecimal>();
	private ArrayList<BigDecimal> Low = new ArrayList<BigDecimal>();
	private List<String> LastTradeTime = new ArrayList<String>();

	private List<StockQuote> QuoteList = new ArrayList<StockQuote>();
	private List<QuoteLineVO> QuoteLineList=new ArrayList<QuoteLineVO>();
	private Map<Integer, String> HLCMap = new HashMap<Integer, String>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm") ;

	private static Logger analytics = LoggerFactory.getLogger("analytics");
	int currIndex;
	private BigDecimal DayLow =BigDecimal.ZERO;
	private BigDecimal DayHigh =BigDecimal.ZERO;
	private BigDecimal previousClose;
	private Boolean IsNewHigh = new Boolean(false);
	private Boolean IsNewLow = new Boolean(false);	

	private Double counter=0.0;

	public BigDecimal getDayLow() {
		return DayLow;
	}

	public void setDayLow(BigDecimal dayLow) {
		DayLow = dayLow;
	}

	public BigDecimal getDayHigh() {
		return DayHigh;
	}

	public void setDayHigh(BigDecimal dayHigh) {
		DayHigh = dayHigh;
	}

	public Integer addSeriesElement(BigDecimal bid, BigDecimal ask, BigDecimal price, String lasttradetime) {
		return 0;
	}

	public Double getStats() {
		return new Double(QuoteList.size());
	}

	public void addSeriesElement(StockQuote quote) {
		BigDecimal lbid, lask, lprice,LpREVlOW, LpREVhIGH;
		IsNewLow =	false;
		IsNewHigh =	false;
		String lst ="";

		lbid = quote.getBid();
		lask = quote.getAsk();
		lprice = quote.getPrice();

		int high, low;
		Date datenow = new Date() ;
		Date startDate = null ; 
		try {
			dateFormat.parse(dateFormat.format(datenow));
			startDate =dateFormat.parse("08:30");

		} catch (ParseException e) {e.printStackTrace();}
		

		Calendar C = new GregorianCalendar();
	    int hour = C.get( Calendar.HOUR_OF_DAY );
	    int minute = C.get( Calendar.MINUTE );
	    
	    
	    if (datenow.after(startDate))
	    {
	    		
	    if (DayLow.compareTo(BigDecimal.ZERO) ==0)DayLow =quote.getDayLow();
				else if(DayLow.compareTo(quote.getDayLow())==1) {
									DayLow =quote.getDayLow();
									IsNewLow =true;
									System.out.println("New Low is :"+DayLow.toString());
			}
				

			if (DayHigh.compareTo(BigDecimal.ZERO) ==0)DayHigh =quote.getDayHigh();
			else if ((DayHigh.compareTo(quote.getDayHigh()) ==-1)) {
								DayHigh =quote.getDayHigh();
								IsNewHigh  =true;
								System.out.println("New High is :"+DayHigh.toString());
}
	    
		}
	    

					Bid.add(lbid);
		Ask.add(lask);
		LastTradeTime.add(lst);
		if (QuoteList.isEmpty()) {
			High.add(lprice);
			Low.add(lprice);
			previousClose = quote.getPreviousClose();
			System.out.println("DayLow is :"+DayLow.toString());
			System.out.println("DayHigh is :"+DayHigh.toString());
			analytics.info("High,Low,Close");
		}
		else if (QuoteList.size() > 0) {
			int previndex = QuoteList.size()-1;
			if (lprice.compareTo(Price.get(previndex))==1){
				if(IsNewHigh) lprice =DayHigh;
				High.add(lprice);
				Low.add(Price.get(previndex));
				
				System.out.println("High,Low is :"+lprice.toString()+" ,"+Low.get(previndex).toString());
				}
				

			else if(lprice.compareTo(Price.get(previndex))==-1) {
				
				if(IsNewLow)lprice =DayLow;
				High.add(Price.get(previndex));
				Low.add(lprice);
				System.out.println("Low,High is :"+lprice.toString()+" ,"+High.get(previndex).toString());
				

				
			}
			else if(lprice.compareTo(Price.get(previndex))==0) {

				High.add(lprice);
				Low.add(lprice);
				
			}


		}
		
		
			Price.add(lprice);
	currIndex =Price.size()-1;
	
	
	QuoteList.add(quote);
	processLineVO();
		
		analytics.info(getLineAsCSV());
		
		

		

	}
	private String getLineAsCSV() {
		
		String outputStr = High.get(currIndex).toString()+","+Low.get(currIndex).toString();	
		outputStr +=","+Price.get(currIndex).toString();
		return outputStr;
	}
			public ArrayList<Object> getFulldata(){
			ArrayList<Object>InnerData= new ArrayList<Object>();
			InnerData.add(High);
			InnerData.add(Low);
			InnerData.add(Price);
			return InnerData;
		}
			
			private void processLineVO()
			{			
			QuoteLineVO Line = new QuoteLineVO();
			Line.setHigh(High.get(currIndex));
			Line.setLow(Low.get(currIndex));
			Line.setPrice(Price.get(currIndex));
			Line.setLastTradeTime(LastTradeTime.get(currIndex));
			QuoteLineList.add(Line);
			
			
			}
			
			public List<QuoteLineVO> getAllQuotes(){
				return QuoteLineList;
				
			}
}


		


			
			
		