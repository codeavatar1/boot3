package com.myspring.boot3.controller;
import org.springframework.web.bind.annotation.RestController;
import com.myspring.boot3.controller.QuoteLineVO;
 import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;








import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.*;


@RestController
public class TimerController {


	@Autowired
	private TimeServiceImpl  ServiceImpl;
	@RequestMapping("/timer/{ActionTag}")
    public String ActionHandler(@PathVariable String ActionTag) {
    	
		System.out.println("In ActionHandler method ");
		if (ActionTag.equals("start")) {
	System.out.println("Tag is start");
	ServiceImpl.start();
	System.out.println("After Tag is start");
}
	
    else if (ActionTag.equals("stop")){
    	System.out.println("Tag is stop");
    	ServiceImpl.stop();
    	System.out.println("After Tag is stop");
    }
    else if (ActionTag.equals("startmonitor")){
    	System.out.println("Tag istartmonitor");
    	ServiceImpl.startMonitor();    	
    }
    else if (ActionTag.equals("stopmonitor")){
    	System.out.println("Tag istopmonitor");
    	ServiceImpl.stopMonitor();
}  	
    else if (ActionTag.equals("data")){
    	System.out.println("Tag is data");
    	//return ServiceImpl.getAllQuotes();
}    	

    	

    	
    else return "Greetings from Spring Boot!="+ActionTag;
   
   return "ActionTag---"+ActionTag+"-Handled successfully.";
    	
    
    }
    
    	
	@GetMapping("/timer/data/getdata")
	public List<QuoteLineVO>getAllQuotes(){

		List<QuoteLineVO> quotes; 
		System.out.println("In getdata actionhandler");
	quotes =	ServiceImpl.getAllQuotes();
	System.out.println("In after quotes "+ quotes.size());
	return quotes;
	
	}	
}

