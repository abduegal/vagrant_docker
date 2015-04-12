package nl.iska.aegal.excercise;

import io.dropwizard.Configuration;

/**
 * Created by vagrant on 12/7/14.
 */
public class ConsumerConfiguration extends Configuration {

    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
