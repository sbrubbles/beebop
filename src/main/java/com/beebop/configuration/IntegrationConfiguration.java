package com.beebop.configuration;

import com.beebop.route.TransactionRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class IntegrationConfiguration extends CamelConfiguration {

    @Autowired
    private TransactionRoute transactionRoute;

    @Override
    public List<RouteBuilder> routes() {
        return Arrays.asList(transactionRoute);
    }
}
