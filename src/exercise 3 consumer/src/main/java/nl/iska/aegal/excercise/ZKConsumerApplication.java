package nl.iska.aegal.excercise;

import io.dropwizard.Application;
import io.dropwizard.discovery.DiscoveryBundle;
import io.dropwizard.discovery.DiscoveryFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.iska.aegal.excercise.resource.ConsumerResource;

/**
 * Created by vagrant on 12/7/14.
 */
public class ZKConsumerApplication extends Application<ConsumerConfiguration> {

    public static void main(String[] args) throws Exception {
        new ZKConsumerApplication().run(args);
    }

    private final DiscoveryBundle<ConsumerConfiguration> discoveryBundle = new DiscoveryBundle<ConsumerConfiguration>() {
        @Override
        public DiscoveryFactory getDiscoveryFactory(ConsumerConfiguration configuration) {
            return configuration.getDiscoveryFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<ConsumerConfiguration> bootstrap) {
        bootstrap.addBundle(discoveryBundle);
    }

    @Override
    public void run(ConsumerConfiguration configuration, Environment environment) throws Exception {
        ConsumerListener.start(configuration.topic);

        environment.jersey().register(ConsumerResource.class);
    }
}
