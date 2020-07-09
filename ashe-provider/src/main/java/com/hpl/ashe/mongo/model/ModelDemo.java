package com.hpl.ashe.mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <p>Title: ModelDemo</p>
 *
 * @author hupenglong
 * @date 2020-07-09 19:10
 */
@Data
@Document(collection = "model_demo")
public class ModelDemo {
    private String name;
    private String code;
}
