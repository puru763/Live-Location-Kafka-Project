package com.livelocationkafka.deliveryperson.service;


import com.livelocationkafka.deliveryperson.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    private KafkaTemplate<String ,String>kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);



    @Override
    public boolean updateLocation(String location) {
        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
        this.logger.info("message  produced ");
        return true;
    }
}
