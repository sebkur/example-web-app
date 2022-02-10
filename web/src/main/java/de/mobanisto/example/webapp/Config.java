package de.mobanisto.example.webapp;

import lombok.Getter;
import lombok.Setter;

public class Config
{

	public static final Config INSTANCE = new Config();

	@Getter
	@Setter
	private String data;

}
