package com.hpl.ashe.mongo.dao;

import com.hpl.ashe.mongo.model.ModelDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>Title: ModelDemoDao</p>
 *
 * @author hupenglong
 * @date 2020-07-09 18:31
 */
@Component
public class ModelDemoDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(ModelDemo model) {
        mongoTemplate.save(model);
    }

}
