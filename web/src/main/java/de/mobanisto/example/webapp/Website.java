package de.mobanisto.example.webapp;

import de.mobanisto.example.Data;
import de.topobyte.webgun.util.CacheBuster;
import lombok.Getter;
import lombok.Setter;

public class Website
{

	public static final String TITLE = "Example web app";

	public static final Website INSTANCE = new Website();

	@Getter
	@Setter
	private CacheBuster cacheBuster;

	@Getter
	@Setter
	private Data data;

}
