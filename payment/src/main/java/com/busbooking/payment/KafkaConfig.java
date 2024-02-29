package com.busbooking.payment;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;


@Configuration
public class KafkaConfig 
{
	
	  @Value("${spring.kafka.consumer.bootstrap-servers}")
	  private String bootstrapServers;
	
	  @Value("${spring.kafka.consumer.key-deserializer}")
	  private String keyClass;
	  
	  @Value("${spring.kafka.consumer.value-deserializer}")
	  private String valueClass;
	
	  @Value("${spring.kafka.consumer.properties.spring.json.trusted.packages}") 
	  private String jsonPackage;
	  
	  @Value("${spring.kafka.consumer.group-id}") 
	  private String groupId;
	  
	  @Value("${spring.kafka.topic.name.inventory}") 
	  private String topicName;
	  
	  @Value("${spring.kafka.topic.name.bookingstatus}")
	  private String bookingTopicName;
	  
	  @Bean
	  public Map<String, Object> consumerConfigs()
	  {
	    Map<String, Object> props = new HashMap<>();
		
		  props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		  props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		  props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	      props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
	      props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
	      props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		  return props;
	  }

	  @Bean
	  public ConsumerFactory<String, Object> consumerFactory() 
	  {
		 return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	  }
	  
	  @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, Map<String,Object>> kafkaListenerContainerFactory() {
	        ConcurrentKafkaListenerContainerFactory<String, Map<String,Object>> factory =
	                new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        factory.setErrorHandler((throwable, consumerRecord) ->
	                System.err.println("Error occurred while processing message: " + consumerRecord));
	        return factory;
	    }
	  
	  @Bean
	  public NewTopic topic()
	  {
		    return TopicBuilder.name(topicName)
		                .build();
	  }
	  
	  @Bean
	  public NewTopic bookingStatusTopic()
	  {
		    return TopicBuilder.name(bookingTopicName)
		                .build();
	  }
		 
		 @Bean
		    public KafkaTemplate<String, Map<String, Object>> kafkaTemplate() {
		        Map<String, Object> producerConfig = new HashMap<>();
		        
		        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

		        DefaultKafkaProducerFactory<String, Map<String, Object>> producerFactory =
		                new DefaultKafkaProducerFactory<>(producerConfig, new StringSerializer(),
		                        new JsonSerializer<>());

		        return new KafkaTemplate<>(producerFactory);
		    }
}
