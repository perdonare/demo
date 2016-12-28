package com.lance.demo.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * Created by perdonare on 2016/12/15.
 */
public class KafkaProducerDemo {

    public void sendMessage() throws InterruptedException {
        Producer<String, String> producer = new KafkaProducer<>(createConfig());
        for(int i = 0; i < 1000; i++) {
            //方法为异步
            Thread.sleep(100);
            producer.send(new ProducerRecord<String, String>("my-topic1",Integer.toString(i), Integer.toString(i)));
            System.out.println("send successful");
        }
        producer.close();
    }

    public void sendMessageCallback() {
        Producer<String, String> producer = new KafkaProducer<>(createConfig());
        for(int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)), (recordMetadata, e) -> {
                if (e!=null) {
                    System.out.println(e.getMessage());
                } else {
                    System.out.println(recordMetadata.partition());
                }
            });
        producer.close();
    }

    private Properties createConfig() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.1.64:9092");
        /**
         *  0   代表不经过任何确认
         *  1   代表只要leader写入日志
         *  all 代表所有集群全部确认
         */
        props.put("acks", "all");
        /**
         * 设置重试次数会导致接受的顺序改变
         */
        props.put("retries", 0);
        /**
         * 针对partition进行请求缓存然后发送  byte 字节数
         */
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("max.block.ms", 1000);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }
}
