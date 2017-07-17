package com.beebop.route;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class TransactionRoute extends RouteBuilder {

    @Value("restlet:${transaction.host}:${transaction.port}${transaction.path}")
    private String restletEndpoint;

    @Override
    public void configure() throws Exception {
        // @formatter:off
        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true")
            .apiContextPath("/api-doc")
                .apiProperty("api.title", "Transactions API")
                .apiProperty("api.version", "1.0");

        rest("/transactions")
            .description("Transaction handling API")
            .consumes(APPLICATION_JSON.toString())
            .produces(APPLICATION_JSON.toString())

            .get()
                .description("List all transactions")
                .outType(List.class)
                .responseMessage()
                    .code(200)
                    .endResponseMessage()
                .route()
                    .transform(new Expression() {@Override
                        public <T> T evaluate(Exchange exchange, Class<T> type) {
                            System.out.println(exchange.getIn().getBody());
                            return null;
                        }})
            .to("direct:listTransactions");

        from("direct:listTransactions")
        .to(restletEndpoint);

        // @formatter:on
    }
}
