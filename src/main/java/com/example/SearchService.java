package com.example;

import io.searchbox.client.JestClient;
import io.searchbox.indices.CreateIndex;
import org.elasticsearch.common.settings.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by donghoon on 2016. 7. 5..
 */
@Component
public class SearchService {

    private Logger logger = LoggerFactory.getLogger(SearchService.class);

    @Autowired
    private JestClient client;

    public void createIndex() throws IOException {
        String settings = "\"settings\" : {\n" +
                "        \"number_of_shards\" : 5,\n" +
                "        \"number_of_replicas\" : 1\n" +
                "    }\n";

        Settings.Builder settingsBuilder = Settings.settingsBuilder();
        settingsBuilder.put("number_of_shards", 5);
        settingsBuilder.put("number_of_replicas", 1);

        client.execute(new CreateIndex.Builder("iruen").settings(settingsBuilder.build().getAsMap()).build());
    }
}