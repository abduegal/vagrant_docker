package nl.iska.aegal.excercise;

import io.dropwizard.Application;
import io.dropwizard.discovery.DiscoveryBundle;
import io.dropwizard.discovery.DiscoveryFactory;
import io.dropwizard.discovery.client.DiscoveryClient;
import io.dropwizard.discovery.client.DiscoveryClientManager;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.iska.aegal.excercise.resource.ConsumerGateway;
import nl.iska.aegal.excercise.resource.ProducerGateway;

/**
 * Created by vagrant on 12/8/14.
 */
public class ApiGatewayApplication extends Application<ApiGatewayConfiguration> {

    public static void main(String[] args) throws Exception {
        new ApiGatewayApplication().run(args);
    }

    private final DiscoveryBundle<ApiGatewayConfiguration> discoveryBundle = new DiscoveryBundle<ApiGatewayConfiguration>() {
        @Override
        public DiscoveryFactory getDiscoveryFactory(ApiGatewayConfiguration configuration) {
            return configuration.getDiscoveryFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<ApiGatewayConfiguration> bootstrap) {
        bootstrap.addBundle(discoveryBundle);
    }

    @Override
    public void run(ApiGatewayConfiguration configuration, Environment environment) throws Exception {
        final DiscoveryClient producerClient = discoveryBundle.newDiscoveryClient(configuration.producer);
        environment.lifecycle().manage(new DiscoveryClientManager(producerClient));

        final DiscoveryClient consumerClient = discoveryBundle.newDiscoveryClient(configuration.consumer);
        environment.lifecycle().manage(new DiscoveryClientManager(consumerClient));

        environment.jersey().register(new ConsumerGateway(consumerClient));
        environment.jersey().register(new ProducerGateway(producerClient));

    }
}
