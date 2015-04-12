package nl.iska.aegal.excercise;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.iska.aegal.excercise.resource.ConsumerResource;

/**
 * Created by vagrant on 12/7/14.
 */
public class ConsumerApplication extends Application<ConsumerConfiguration> {

    public static void main(String[] args) throws Exception {
        new ConsumerApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ConsumerConfiguration> bootstrap) {
    }

    @Override
    public void run(ConsumerConfiguration configuration, Environment environment) throws Exception {
        ConsumerListener.start(configuration.getTopic());

        environment.jersey().register(ConsumerResource.class);
    }
}
