package nl.iska.aegal.exercise;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.discovery.DiscoveryFactory;
import io.dropwizard.setup.Environment;
import kafka.producer.ProducerConfig;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.*;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by vagrant on 12/6/14.
 */
public class ProducerConfiguration extends Configuration {

    public String topic;
    @JsonProperty("discovery")
    private DiscoveryFactory discovery = new DiscoveryFactory();

    public DiscoveryFactory getDiscoveryFactory() {
        return discovery;
    }

    public void setDiscoveryFactory(DiscoveryFactory discoveryFactory) {
        this.discovery = discoveryFactory;
    }

    public ProducerConfig getProducerConfig(){
        Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "1");
        return new ProducerConfig(props);
    }
}
