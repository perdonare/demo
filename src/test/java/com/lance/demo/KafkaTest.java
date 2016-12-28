package com.lance.demo;

import com.lance.demo.kafka.KafkaConsumerDemo;
import com.lance.demo.kafka.KafkaProducerDemo;
import org.junit.Test;

/**
 * Created by perdonare on 2016/12/20.
 */
public class KafkaTest {
    @Test
    public void testKafkaProducer() throws InterruptedException {
        KafkaProducerDemo producer = new KafkaProducerDemo();
        producer.sendMessage();
    }

    @Test
    public void testKafkaConsumer() throws InterruptedException {
        KafkaConsumerDemo consumer = new KafkaConsumerDemo();
        consumer.automaticConsume();
    }
}
