package nl.iska.aegal.exercise;

import io.dropwizard.Application;
import io.dropwizard.discovery.DiscoveryBundle;
import io.dropwizard.discovery.DiscoveryFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.iska.aegal.exercise.resource.ProducerResource;

/**
 * Created by vagrant on 12/6/14.
 */
public class ZKProducerApplication extends Application<ProducerConfiguration> {

    public static void main(String[] args) throws Exception {
        new ZKProducerApplication().run(args);
    }

    private final DiscoveryBundle<ProducerConfiguration> discoveryBundle = new DiscoveryBundle<ProducerConfiguration>() {
        @Override
        public DiscoveryFactory getDiscoveryFactory(ProducerConfiguration configuration) {
            return configuration.getDiscoveryFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<ProducerConfiguration> bootstrap) {
        bootstrap.addBundle(discoveryBundle);
    }

    @Override
    public void run(ProducerConfiguration config, Environment environment) throws Exception {
        environment.jersey().register(new ProducerResource(config.topic, config.getProducerConfig()));
    }
}
