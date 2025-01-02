package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {

	//Execution service. Manages multi-thread
	// thread pool size: 5, so as to not overload system
	static ExecutorService messageExecutioner = newFixedThreadPool(5);

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		//Properties Object for localized messages
		Properties properties = new Properties();

		//Thread for French Canadian locale
		messageExecutioner.execute(() -> {
			try {
				// ClassPathResource fetches welcome message within the properties file
				InputStream stream = new ClassPathResource("Translate_fr_CA.properties").getInputStream();
				properties.load(stream);
				System.out.println("French: " + properties.getProperty("welcome"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		//Thread for English US locale
		messageExecutioner.execute(() -> {
			try {
				InputStream stream = new ClassPathResource("Translate_en_US.properties").getInputStream();
				properties.load(stream);
				System.out.println("English: " + properties.getProperty("welcome"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		// shut down messageExecutioner after thread is completed
		messageExecutioner.shutdown();


	}

}
