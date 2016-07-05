package com.example;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by donghoon on 2016. 7. 5..
 */
@Configuration
public class JestClientConfiguration {

    private String address = "http://52.79.173.7:9200/";

    private int maxTotalConnection = 10;

    private int connTimeout = 1000;

    private int readTimeout = 3000;

    @Bean
    public JestClient jestClient() {
        // Configuration
        HttpClientConfig clientConfig = new HttpClientConfig.Builder(address)
                .multiThreaded(true)
                .maxTotalConnection(maxTotalConnection)
                .connTimeout(connTimeout)
                .readTimeout(readTimeout)
                .build();

        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(clientConfig);
        JestClient client = factory.getObject();
        return client;
    }
}