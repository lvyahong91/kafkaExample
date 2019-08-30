package com.example.kafkaExample;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerExample2 {

	public static void main(String[] args) {
		Properties properties=new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("group.id", "test300");
		properties.put("auto.offset.reset", "earliest");
//		properties.put("auto.offset.reset", "latest");
		properties.put("enable.auto.commit", "true");
		properties.put("auto.commit.interval.ms", "1000");
		properties.put("session.timeout.ms", "30000");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		@SuppressWarnings("resource")
		Consumer<String, String> consumer=new KafkaConsumer<String, String>(properties);
		consumer.subscribe(Arrays.asList("test2"));
		ConsumerRecords<String, String> consumerRecords=consumer.poll(80000);
		for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
			System.out.println("测试是否有数据");
			System.out.printf("partition=%d,offset = %s,  value = %s\n",consumerRecord.partition() ,consumerRecord.offset(), consumerRecord.value());
		}
		consumer.close();
		System.out.println("数据消费完毕");
		
	}

}
