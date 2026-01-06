package com.ron.inetpsa;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Method;
import java.util.*;

class MyService {
    public String greet(String name, String lastname, List<String> s) {
        return "Hello, " + name + " "+lastname+"!";
    }
}

public class Reflection {
    public static void main(String[] args) throws Exception {
        Map<String, Object> serviceMap = new HashMap<>();
        serviceMap.put("com.example.MyService", new MyService());

        // Step 1: Simulate headers from Kafka
        String serviceClassName = "com.example.MyService";
        String methodName = "greet";
        String[] argsClasses = { "java.lang.String", "java.lang.String", "java.util.List"}; // corresponds to method param
        String payloadJson = "[\"John\"]";
        List<String> list = new ArrayList<>();
        Object[] load = {"John","Abhrahim",list};
        Object serviceBean = serviceMap.get(serviceClassName);
        Class<?>[] paramTypes = Arrays.stream(argsClasses)
                .map(className -> {
                    try {
                        return Class.forName(className);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .toArray(Class[]::new);
        System.out.println(Arrays.toString(paramTypes));
        Method method = serviceBean.getClass().getMethod(methodName, paramTypes);
        System.out.println(method);
        ObjectMapper objectMapper = new ObjectMapper();
        Object[] argsArray = objectMapper.readValue(payloadJson, Object[].class);
        System.out.println(serviceBean.getClass());
        // Step 6: Invoke the method
        Object response = method.invoke(serviceBean, load);

        // Step 7: Print the result
        System.out.println("Response from method: " + response);
        System.out.println(Class.forName("java.lang.String"));

    }
}
