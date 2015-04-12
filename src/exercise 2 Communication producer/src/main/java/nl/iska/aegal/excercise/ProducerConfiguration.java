package nl.iska.aegal.excercise;

import io.dropwizard.Configuration;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Created by vagrant on 12/7/14.
 */
public class ProducerConfiguration extends Configuration{

    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ProducerConfig getProducerConfig(){
        Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "1");
        return new ProducerConfig(props);
    }

}
