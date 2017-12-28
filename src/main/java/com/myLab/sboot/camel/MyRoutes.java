package com.myLab.sboot.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoutes extends RouteBuilder{
	
	MyBeanProcessor myBean = new MyBeanProcessor();
	

	@Override
	public void configure() throws Exception {
		System.out.println(" i am inside configure");
		
		from("file://C:/MyLab/FileBox/in/?noop=true")
		.bean(myBean)
		.log("you are logging")
		.delay(1000)		
		.to("file://C:/MyLab/FileBox/out/");
		
		
		/*from("timer:mytimer?period={{timer.period}}")
        .setBody(simple("{{greeting.word}}, this is Camel running in Spring Boot!"))
        .to("log:out");	*/
		
	}

}
