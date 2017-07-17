package com.beebop;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * The application entry point, with configuration for the web initializer and the web descriptors for Spring.
 */
public class BeebopInitializer implements WebApplicationInitializer {

    private static final String ROOT_PACKAGE = "com.beebop";
    private static final String ALL_URLS_PATTERN = "/*";
    private static final String API_URLS_PATTERN = "/api/*";
    private static final String SPRING_SECURITY_FILTER_CHAIN = "springSecurityFilterChain";

    /**
     * Application initializer method configuring the Spring context, the {@link DispatcherServlet} and Spring Security
     *
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = createContext();
        servletContext.addListener(new ContextLoaderListener(context));

        // Dispatcher servlet
        Dynamic dispatcher = servletContext.addServlet(DispatcherServlet.class.getName(),
                new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(ALL_URLS_PATTERN);

        servletContext.addServlet("CamelServlet", new CamelHttpTransportServlet())
                .addMapping(API_URLS_PATTERN);

        // Spring security filter
        servletContext.addFilter(SPRING_SECURITY_FILTER_CHAIN, new DelegatingFilterProxy(SPRING_SECURITY_FILTER_CHAIN))
                .addMappingForUrlPatterns(null, false, ALL_URLS_PATTERN);
    }

    /**
     * Build the {@link WebApplicationContext} with a reference to the package containing Spring {@link Configuration}
     * classes
     */
    private WebApplicationContext createContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan(ROOT_PACKAGE);
        return context;
    }
}
