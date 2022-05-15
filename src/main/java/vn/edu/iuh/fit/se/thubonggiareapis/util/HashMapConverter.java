package vn.edu.iuh.fit.se.thubonggiareapis.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;

public abstract class HashMapConverter {
    public static HashMap<String, Object> toHashMap(Object object, Class<?> clazz) {
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                hashMap.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return hashMap;
    }
}
