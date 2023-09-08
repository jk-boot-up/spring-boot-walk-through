package com.jk.explore.boot.logbackaccess.integration;

import ch.qos.logback.access.tomcat.LogbackValve;
import org.apache.catalina.Container;
import org.apache.catalina.Engine;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogbackAccessEventConfiguration {

    @Bean
    public TomcatContextCustomizer tomcatContextCustomizer() {
        return (customizer) -> {
            Container container = customizer.getPipeline().getContainer();
            LogbackValve logbackValve = new LogbackValve();
            logbackValve.setFilename("logback-access.xml");
            logbackValve.setContainer(container);
            container.getPipeline().addValve(logbackValve);
        };
    }

}