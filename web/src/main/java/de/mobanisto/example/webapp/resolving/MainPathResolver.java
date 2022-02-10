package de.mobanisto.example.webapp.resolving;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import de.mobanisto.example.Data;
import de.mobanisto.example.GradlePlugin;
import de.mobanisto.example.MavenCoordinate;
import de.mobanisto.example.webapp.Website;
import de.mobanisto.example.webapp.pages.main.AboutGenerator;
import de.mobanisto.example.webapp.pages.main.IndexGenerator;
import de.mobanisto.example.webapp.pages.main.PluginGenerator;
import de.mobanisto.example.webapp.pages.main.PluginsGenerator;
import de.mobanisto.example.webapp.pages.markdown.MarkdownResourceGenerator;
import de.topobyte.jsoup.ContentGeneratable;
import de.topobyte.webgun.exceptions.PageNotFoundException;
import de.topobyte.webgun.resolving.smart.SmartPathSpecResolver;
import de.topobyte.webpaths.WebPath;

public class MainPathResolver
		extends SmartPathSpecResolver<ContentGeneratable, Void>
{

	@Override
	public ContentGeneratable getGenerator(WebPath path,
			HttpServletRequest request, Void data)
	{
		if (path.getNameCount() == 0) {
			return new IndexGenerator(path);
		}
		return super.getGenerator(path, request, data);
	}

	{
		map(LinkDefs.PLUGINS, (path, output, request, data) -> {
			return new PluginsGenerator(path);
		});
		map(LinkDefs.PLUGIN,
				(path, output, request, data, group, artifact, version) -> {
					GradlePlugin plugin = plugin(group, artifact, version);
					if (plugin == null) {
						throw new PageNotFoundException();
					}
					return new PluginGenerator(path, plugin);
				});

		map(LinkDefs.ABOUT, (path, output, request, data) -> {
			return new AboutGenerator(path);
		});
		map(LinkDefs.IMPRINT, (path, output, request, data) -> {
			return new MarkdownResourceGenerator(path, "markdown/imprint.md");
		});
		map(LinkDefs.PRIVACY_POLICY, (path, output, request, data) -> {
			return new MarkdownResourceGenerator(path,
					"markdown/privacy-policy.md");
		});
	}

	private GradlePlugin plugin(String group, String artifact, String version)
	{
		MavenCoordinate needle = new MavenCoordinate(group, artifact, version);
		Data data = Website.INSTANCE.getData();
		List<GradlePlugin> plugins = data.getGradlePlugins();
		for (GradlePlugin plugin : plugins) {
			if (plugin.getMaven().equals(needle)) {
				return plugin;
			}
		}
		return null;
	}

}
