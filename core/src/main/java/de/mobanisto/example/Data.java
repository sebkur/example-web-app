package de.mobanisto.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;

public class Data
{

	@Getter
	private Map<String, String> map = new HashMap<>();
	{
		map.put("foo", "Foo");
		map.put("bar", "Bar");
	}

	@Getter
	private List<GradlePlugin> gradlePlugins = new ArrayList<>();
	{
		gradlePlugins.add(new GradlePlugin("Lombok Plugin",
				new MavenCoordinate("io.franzbecker", "gradle-lombok", "4.0.0"),
				"https://github.com/franzbecker/gradle-lombok"));
		gradlePlugins.add(new GradlePlugin("Favicon Generator plugin",
				new MavenCoordinate("de.topobyte",
						"gradle-generate-favicons-plugin", "0.0.2"),
				"https://github.com/sebkur/gradle-generate-favicons-plugin"));
		gradlePlugins.add(new GradlePlugin("Cache-Busting plugin",
				new MavenCoordinate("de.topobyte",
						"gradle-cache-busting-plugin", "0.0.3"),
				"https://github.com/sebkur/gradle-cache-busting-plugin"));
		gradlePlugins.add(new GradlePlugin("Tomcat plugin",
				new MavenCoordinate("com.bmuschko", "gradle-tomcat-plugin",
						"2.7.0"),
				"https://github.com/bmuschko/gradle-tomcat-plugin"));
		gradlePlugins.add(new GradlePlugin("Client dependencies plugin",
				new MavenCoordinate("gradle.plugin.com.craigburke.gradle",
						"client-dependencies", "1.4.0"),
				"https://github.com/craigburke/client-dependencies-gradle"));
	}

}
