package de.mobanisto.example.webapp.pages.main;

import java.io.IOException;

import de.mobanisto.example.webapp.pages.base.BaseGenerator;
import de.topobyte.webpaths.WebPath;

public class ErrorGenerator extends BaseGenerator
{

	public ErrorGenerator(WebPath path)
	{
		super(path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		menu();
		footer();
	}

}
