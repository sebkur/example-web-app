package de.mobanisto.example.webapp.pages.main;

import java.util.List;

import de.mobanisto.example.Data;
import de.mobanisto.example.GradlePlugin;
import de.mobanisto.example.MavenCoordinate;
import de.mobanisto.example.webapp.Website;
import de.mobanisto.example.webapp.pages.base.SimpleBaseGenerator;
import de.mobanisto.example.webapp.resolving.LinkDefs;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.Bootstrap;
import de.topobyte.jsoup.bootstrap4.components.ListGroupDiv;
import de.topobyte.webpaths.WebPath;

public class PluginsGenerator extends SimpleBaseGenerator
{

	public PluginsGenerator(WebPath path)
	{
		super(path);
	}

	@Override
	protected void content()
	{
		content.ac(HTML.h1("Gradle plugins"));

		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());

		Data data = Website.INSTANCE.getData();
		List<GradlePlugin> plugins = data.getGradlePlugins();

		for (GradlePlugin plugin : plugins) {
			MavenCoordinate maven = plugin.getMaven();
			list.addA(
					LinkDefs.PLUGIN.getLink(maven.getGroup(),
							maven.getArtifact(), maven.getVersion()),
					plugin.getName());
		}
	}

}
