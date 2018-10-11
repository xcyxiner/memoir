package com.britreasure.memoir.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * @author xcyxiner
 * @create: 2018-10-11 下午6:50
 */
public class BeanToMapUtil {
    
    public static Map objectToMap(Object obj) {
        if (obj == null)
            return null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.convertValue(obj, Map.class);
    }
}
