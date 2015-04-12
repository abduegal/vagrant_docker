package nl.iska.aegal.excercise;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.discovery.DiscoveryFactory;

/**
 * Created by vagrant on 12/8/14.
 */
public class ApiGatewayConfiguration extends Configuration {

    public String consumer;
    public String producer;

    @JsonProperty("discovery")
    private DiscoveryFactory discovery = new DiscoveryFactory();

    public DiscoveryFactory getDiscoveryFactory() {
        return discovery;
    }

    public void setDiscoveryFactory(DiscoveryFactory discoveryFactory) {
        this.discovery = discoveryFactory;
    }

}
