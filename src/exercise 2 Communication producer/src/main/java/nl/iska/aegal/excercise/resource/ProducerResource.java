package nl.iska.aegal.excercise.resource;

import kafka.producer.ProducerConfig;

import javax.ws.rs.Path;

/**
 * Created by vagrant on 12/7/14.
 */
@Path("/")
public class ProducerResource {

    private final String topic;
    private final ProducerConfig producerConfig;

    public ProducerResource(String topic, ProducerConfig producerConfig) {
        this.topic = topic;
        this.producerConfig = producerConfig;
    }



}
