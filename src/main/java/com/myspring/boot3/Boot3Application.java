package com.myspring.boot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;




@SpringBootApplication
@EnableScheduling

public class Boot3Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Boot3Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Boot3Application.class);
    }
}

/*
@SpringBootApplication


//@SpringBootApplication(scanBasePackages = "com.example.controller")
@ComponentScan("com.myspring.boot3.controller")

public class Boot3Application {

	private  static final Logger LOGGER = LoggerFactory.getLogger(Boot3Application.class);
	public static void main(String[] args) {
	
		ApplicationContext applicationContext =SpringApplication.run(Boot3Application.class, args);
        for (String name: applicationContext.getBeanDefinitionNames()) {

            LOGGER.info(name);
}

		
		
		
        LOGGER.info("cAme in Boot2Application...");
		
	}

}
*/

