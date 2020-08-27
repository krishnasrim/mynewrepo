package com.example.demo;

import java.util.Collections;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
@EnableCaching
@SpringBootApplication
@EnableScheduling
public class DemoApplication {
	//HTTP port
		//@Value("${http.port}")
		//private int httpPort;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("hello");
	}
	   @Bean(name = "appRestClient")
	    public RestTemplate getRestClient() {
	        RestTemplate restClient = new RestTemplate(
	                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

	        // Add one interceptor like in your example, except using anonymous class.
	        restClient.setInterceptors(Collections.singletonList((request, body, execution) -> {

	            return execution.execute(request, body);
	        }));

	        return restClient;
	    }
	   
	   @Bean
	    public CommandLineRunner mappingDemo(BooksRepository booksRepository,
	                                         SqlTableRepository sqlTableRepository) {
	        return args -> {

	            // create a new book
	            Books book = new Books(10,"Java01", "JohnDoe", 123456);

	            // save the book
	            booksRepository.save(book);

	            // create and save new pages
	            sqlTableRepository.save(new SqlTable(100, "Introduction contents", "Introduction", book));
	            sqlTableRepository.save(new SqlTable(65, "Java 8 contents", "Java 8", book));
	         
	        };
	    }
	   
	   
	   
	/* Let's configure additional connector to enable support for both HTTP and HTTPS
		@Bean
		public ServletWebServerFactory servletContainer() {
			TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
			tomcat.addAdditionalTomcatConnectors(createStandardConnector());
			return tomcat;
		}

		private Connector createStandardConnector() {
			Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
			connector.setPort(httpPort);
			return connector;
		}*/
	   
}


