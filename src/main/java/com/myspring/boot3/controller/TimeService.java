package com.myspring.boot3.controller;
import java.util.*;

public interface TimeService {

	   
	   public abstract void start();
	   public abstract void stop();
	   
	   public abstract void startMonitor();
	   public abstract void stopMonitor();
	   
	   public abstract List<QuoteLineVO>getAllQuotes();
	   
	   
	   }
