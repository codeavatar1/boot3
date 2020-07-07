package com.myspring.boot3.controller;

import java.util.*;

import com.myspring.boot3.controller.TimeService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService{

	@Autowired
	private TimeSeriesComponent TS; 
	public void start() {
		TS.start();
	}
	public void stop() {
		TS.stop();
	}
	
	public void startMonitor() {
		TS.startFileMonitor();
	}
	

public void stopMonitor() {
	TS.stopFileMonitor();
}

public List<QuoteLineVO>getAllQuotes(){
	return TS.getAllQuotes();
}
}
	

