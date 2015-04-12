package nl.iska.aegal.excercise;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.iska.aegal.excercise.resource.ProducerResource;

/**
 * Created by vagrant on 12/6/14.
 */
public class ProducerApplication extends Application<ProducerConfiguration> {

    public static void main(String[] args) throws Exception {
        new ProducerApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ProducerConfiguration> bootstrap) {

    }

    @Override
    public void run(ProducerConfiguration config, Environment environment) throws Exception {
        environment.jersey().register(new ProducerResource(config.getTopic(), config.getProducerConfig()));
    }
}
