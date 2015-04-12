package nl.iska.aegal.excercise;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Created by vagrant on 12/7/14.
 */
public class ConsumerListener {

    private static ConsumerListener INSTANCE;

    private List<String> messages = new ArrayList<>();

    private void run(String topic){
        Properties props = new Properties();

        props.put("zookeeper.connect", "localhost:2181");
        props.put("group.id", "1");
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        ConsumerConfig consumerConfig = new ConsumerConfig(props);

        ConsumerConnector connector = Consumer.createJavaConsumerConnector(consumerConfig);

        List<KafkaStream<byte[], byte[]>> streams =
                connector.createMessageStreams(Collections.singletonMap(topic, 1)).get(topic);


        for (final KafkaStream stream : streams) {
            ConsumerIterator<byte[], byte[]> it = stream.iterator();
            while (it.hasNext())
                messages.add(new String(it.next().message()));
        }

    }

    public static ConsumerListener start(final String topic) {
        INSTANCE = new ConsumerListener();
        new Thread(() -> INSTANCE.run(topic)).start();
        return INSTANCE;
    }

    public static ConsumerListener getInstance() {
        return INSTANCE;
    }

    public List<String> getMessages() {
        return messages;
    }
}
