package com.lumberjackdev.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.MapPropertySource;
import org.springframework.util.CollectionUtils;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class TemplateApp {

	public static void main(String... args) {
		var application = new SpringApplication(TemplateApp.class);
		if (shouldStartContainers(args)) {
			application.addInitializers(new ContainerInitializer());
		}
		application.run(args);
	}

	private static boolean shouldStartContainers(String... args) {
		return Arrays.asList(args).contains("start.containers");
	}
}
