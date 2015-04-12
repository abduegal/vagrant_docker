package nl.iska.aegal.exercise.resource;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by vagrant on 12/6/14.
 */
@Path("/")
public class ProducerResource {

    private final String topic;
    private final ProducerConfig producerConfig;
    private final double random = Math.random();

    public ProducerResource(String topic, ProducerConfig producerConfig) {
        this.topic = topic;
        this.producerConfig = producerConfig;
    }

    @GET
    @Path("send/{message}")
    public String sendMessage(@PathParam("message") String message) {
        Producer<String, String> producer = new Producer<>(producerConfig);

        KeyedMessage<String, String> data = new KeyedMessage<>(topic, message);
        producer.send(data);

        producer.close();

        return "ok, for service: "+ random;
    }

}
