package com.testing.testarch;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws IOException {

		App app = new App();

		System.out.println("Hello World!");

		Properties prop = new Properties();
		InputStream input = App.class.getClassLoader().getResourceAsStream("config.properties");
		prop.load(input);

		// Before static values from properties file
		System.out.println("from properties file " + prop.getProperty("clamav.host"));
		System.out.println("from properties file " + prop.getProperty("clamav.port"));
		System.out.println("from properties file " + prop.getProperty("clamav.max"));
		System.out.println("from properties file " + prop.getProperty("clamav.max.timeout"));

		// do manipulation from Archaius
		// DynamicPropertyFactory.initWithConfigurationSource(myConfiguration);

		app.getStringProperty("clamav.host", "myhost");

		// display dynamic values
		System.out.println("from properties file " + prop.getProperty("clamav.host"));
	}

	public String getStringProperty(String key, String defaultValue) {

		final DynamicStringProperty prop = DynamicPropertyFactory.getInstance().getStringProperty(key, defaultValue);

		return prop.get();
	}
}
