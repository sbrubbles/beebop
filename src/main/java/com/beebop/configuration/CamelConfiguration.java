package com.beebop.configuration;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfiguration {
    @Bean
    public CamelContext createCamelContext() throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
//        camelContext.addRoutes(new net.krg.kneip.routing.Routes());
        camelContext.start();
        return camelContext;
    }
}
