package com.github.sacredrelict.data.config;

import org.apache.catalina.Context;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Configuration for Tomcat.
 */
@Configuration
public class TomcatHttpConnectorConfiguration {

    /**
     * Method, that create and return Tomcat configuration.
     * @return Tomcat configuration factory.
     */
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.setTomcatContextCustomizers(Arrays.asList(new CustomCustomizer()));
        return tomcat;
    }

    /**
     * Disable slash adding.
     */
    public static class CustomCustomizer implements TomcatContextCustomizer {
        public void customize(Context context) {
            context.setMapperContextRootRedirectEnabled(false);
        }
    }

}
