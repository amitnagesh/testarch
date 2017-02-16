package com.testing.testarch;

import org.junit.Test;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

import junit.framework.Assert;
import junit.framework.TestCase;

class AppConfig {

	public String getStringProperty(String key, String defaultValue) {

		final DynamicStringProperty prop = DynamicPropertyFactory.getInstance().getStringProperty(key, defaultValue);

		return prop.get();
	}
}

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	private AppConfig appConfig = new AppConfig();

	@Test
	public void testAppConfig_1() {
		String prop = appConfig.getStringProperty("clamav.host", "host");

		Assert.assertEquals("newhost", prop);
	}

	// reading from cascade config file
	@Test
	public void testAppConfig_2() {
		String prop = appConfig.getStringProperty("clamav2.name", "newlocalhost");

		Assert.assertEquals("newlocalhost", prop);
	}
}
