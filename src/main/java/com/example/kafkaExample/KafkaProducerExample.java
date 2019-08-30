package com.example.kafkaExample;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerExample {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Properties properties=new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("acks", "all");
		properties.put("retries", 0);
		properties.put("batch.size", 16384);
		properties.put("linger.ms", 33554432);
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		Producer<String,String> producer=new KafkaProducer<String, String>(properties);
		for(int i = 1000; i < 2000; i++) {
		      producer.send(new ProducerRecord<String, String>("test2", "i'm lvyahong,i'm producing data "+Integer.toString(i)));
		 }
		 producer.close();
		System.out.println("数据生产完毕");
	}
}
