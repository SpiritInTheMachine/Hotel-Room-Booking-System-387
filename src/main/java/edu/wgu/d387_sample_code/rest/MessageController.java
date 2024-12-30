package edu.wgu.d387_sample_code.rest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.*;

@RestController
public class MessageController {

    // Thread for executing tasks
    private static final ExecutorService messageExecutor = Executors.newFixedThreadPool(5);

    // Get message concurrently
    @GetMapping("/api/messages")
    public Map<String, String> getLocalMessages() {
        Map<String, String> messages = new ConcurrentHashMap<>();

        // locales and corresponding files
        Map<String, String> locales = Map.of(
                "English","Translate_en_US.properties",
                "French", "Translate_fr_CA.properties"
        );

        // tasks for each local
        List<Future<Void>> tasks = new ArrayList<>();
        locales.forEach((language, filename) -> {
                tasks.add(messageExecutor.submit(() -> {
                    try {
                        InputStream stream = new ClassPathResource(filename).getInputStream();
                        Properties properties = new Properties();
                        properties.load(stream);
                        messages.put(language, properties.getProperty("welcome"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }));
        });

        //Wait for tasks to complete
        for (Future<Void> task : tasks) {
            try {
                task.get(); //Block until completion
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // return JSON object
        return messages;
    }
}
