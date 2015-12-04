package org.github.asamaraw.dwsse;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class KeyService extends Application<KeyServiceConfiguration> {

    public static final String SERVLET = "org.github.asamaraw.dwsse.SseEventSourceServlet";

    public static void main(String[] args) throws Exception {
        new KeyService().run(args);
    }

    @Override
    public String getName() {
        return "KeyService";
    }

    @Override
    public void initialize(Bootstrap<KeyServiceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(KeyServiceConfiguration configuration, Environment environment) {
        environment.jersey().register(new PublisherResource());
        environment.getApplicationContext().addServlet(SERVLET, "/sse");
    }
}
