package com.britreasure.memoir.repository;

import com.britreasure.memoir.model.Memoir;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午6:06
 */
public interface MemoirRepository extends MongoRepository<Memoir, String> {
    List<Memoir> findByTitleLike(String title);
}
