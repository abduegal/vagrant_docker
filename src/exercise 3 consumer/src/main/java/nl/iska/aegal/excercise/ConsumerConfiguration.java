package nl.iska.aegal.excercise;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.discovery.DiscoveryFactory;

/**
 * Created by vagrant on 12/7/14.
 */
public class ConsumerConfiguration extends Configuration {

    public String topic;

    @JsonProperty("discovery")
    private DiscoveryFactory discovery = new DiscoveryFactory();

    public DiscoveryFactory getDiscoveryFactory() {
        return discovery;
    }

    public void setDiscoveryFactory(DiscoveryFactory discoveryFactory) {
        this.discovery = discoveryFactory;
    }
}
