package com.example.demo.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="features")
public class FeaturesEndpoint {
    private final Map<String, Feature> featureMap= new ConcurrentHashMap<>();


    public FeaturesEndpoint() {
        featureMap.put("Department",new Feature(true));
    }

    @ReadOperation
    public Map<String, Feature> features(){
        return featureMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName){
        return featureMap.get(featureName);
    }

    @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Feature{

        private boolean IsEnabled;

            }
}
