package com.britreasure.memoir.repository;

import com.britreasure.memoir.model.RabbitmqLastMessage;
import com.britreasure.memoir.model.RabbitmqMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午5:03
 */
public interface RabbitmqLastMessageRepository extends MongoRepository<RabbitmqLastMessage, String> {
    public RabbitmqMessage findByQueueName(String queueName);
}
