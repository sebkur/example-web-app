package de.mobanisto.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class MavenCoordinate
{

	private String group;
	private String artifact;
	private String version;

	public MavenCoordinate(String group, String artifact, String version)
	{
		this.group = group;
		this.artifact = artifact;
		this.version = version;
	}

	@Override
	public String toString()
	{
		return group + ":" + artifact + ":" + version;
	}

}
