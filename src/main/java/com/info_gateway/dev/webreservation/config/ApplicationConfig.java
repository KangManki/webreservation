package com.info_gateway.dev.webreservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration

  @ComponentScan(basePackages= {
   "com.info_gateway.dev.webreservation.dao"
  ,"com.info_gateway.dev.webreservation.dto" 
  ,"com.info_gateway.dev.webreservation.service" 
  ,"com.info_gateway.dev.webreservation.display.dao" 
  ,"com.info_gateway.dev.webreservation.display.dto" 
  ,"com.info_gateway.dev.webreservation.display.service"  
  })
 
/* @ComponentScan(basePackages= {"com.info_gateway.dev.webreservation"}) */
@Import({DBConfig.class})
public class ApplicationConfig {

}
