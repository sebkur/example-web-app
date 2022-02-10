package de.mobanisto.example;

import lombok.Getter;

@Getter
public class GradlePlugin
{

	private String name;
	private MavenCoordinate maven;
	private String sourceRepo;

	GradlePlugin(String name, MavenCoordinate maven, String sourceRepo)
	{
		this.name = name;
		this.maven = maven;
		this.sourceRepo = sourceRepo;

	}

}
