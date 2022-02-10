package de.mobanisto.example.webapp.pages.main;

import de.mobanisto.example.GradlePlugin;
import de.mobanisto.example.MavenCoordinate;
import de.mobanisto.example.webapp.pages.base.SimpleBaseGenerator;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.Bootstrap;
import de.topobyte.jsoup.bootstrap4.components.ListGroupDiv;
import de.topobyte.webpaths.WebPath;

public class PluginGenerator extends SimpleBaseGenerator
{

	private GradlePlugin plugin;

	public PluginGenerator(WebPath path, GradlePlugin plugin)
	{
		super(path);
		this.plugin = plugin;
	}

	@Override
	protected void content()
	{
		content.ac(HTML.h1(plugin.getName()));

		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());

		MavenCoordinate maven = plugin.getMaven();
		String link;
		if (maven.getGroup().equals("de.topobyte")) {
			link = String.format("https://mvn.topobyte.de/%s/%s/%s/",
					maven.getGroup().replace(".", "/"), maven.getArtifact(),
					maven.getVersion());
		} else {
			link = String.format("https://mvnrepository.com/artifact/%s/%s/%s",
					maven.getGroup(), maven.getArtifact(), maven.getVersion());
		}

		list.addA(link, "Maven Coordinate: " + maven);
		list.addA(plugin.getSourceRepo(), "Source: " + plugin.getSourceRepo());
	}

}
