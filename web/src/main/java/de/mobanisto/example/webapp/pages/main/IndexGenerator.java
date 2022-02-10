package de.mobanisto.example.webapp.pages.main;

import static de.topobyte.jsoup.HTML.div;
import static de.topobyte.jsoup.HTML.h1;
import static de.topobyte.jsoup.HTML.h3;
import static de.topobyte.jsoup.HTML.img;
import static de.topobyte.jsoup.HTML.p;

import de.mobanisto.example.webapp.Website;
import de.mobanisto.example.webapp.pages.base.SimpleBaseGenerator;
import de.mobanisto.example.webapp.resolving.LinkDefs;
import de.topobyte.cachebusting.CacheBusting;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.Bootstrap;
import de.topobyte.jsoup.components.Div;
import de.topobyte.webpaths.WebPath;

public class IndexGenerator extends SimpleBaseGenerator
{

	public IndexGenerator(WebPath path)
	{
		super(path);
	}

	@Override
	protected void content()
	{
		content.ac(h1(Website.TITLE));
		Div row = content.ac(Bootstrap.row());

		Div col = row.ac(div("col-12 mb-4"));
		col.at("This is an example web project built using the JVM as a core technology."
				+ " Below is a description of some of the key technologies used.");

		card(row, "images/java.svg", "Java", "The whole app runs on the JVM."
				+ " While this app is written in Java entirely, you could also use"
				+ " Kotlin or Groovy.");

		divider(row);

		Div gradle = card(row, "images/gradle.png", "Gradle",
				"Gradle is used as the build system. It supports multi-project builds and"
						+ " can be extended very flexibly.");
		gradle.ac(HTML.p()).at("The app uses a number of ")
				.ap(HTML.a(LinkDefs.PLUGINS.getLink(), "Gradle Plugins"))
				.at(" to make development easier and offer features such as"
						+ " cache-busted static resources, generated favicons and"
						+ " dependency management of client-side JavaScript and CSS libraries.");

		divider(row);

		Div tomcat = card(row, "images/tomcat.svg", "Tomcat");
		tomcat.ac(p()).at(
				"The app can be run on any application server, however this app"
						+ " is configured such that it can be run from Gradle using an embedded"
						+ " Tomcat server.");
		tomcat.ac(HTML.code()).at("./gradlew tomcatRun --no-daemon");

		divider(row);

		card(row, "images/jsoup.png", "JSoup",
				"JSoup is used for parsing HTML and for creating HTML code."
						+ " While traditionally JSP has been used for Java-based web apps,"
						+ " we felt that it is not very robust when it comes to code refactoring."
						+ " We're working on fluid JSoup-based APIs for building HTML.");

		divider(row);

		card(row, "images/bootstrap.svg", "Bootstrap",
				"Bootstrap is used for building mobile-first layouts and widgets."
						+ " It offers a great framework for designing websites with better"
						+ " defaults that look nice out of the box.");

		divider(row);

		card(row, "images/flexmark.svg", "Flexmark",
				"Flexmark is a markdown parser and renderer."
						+ " It allows us to use Markdown fragments to manage some of the app's"
						+ " content in a language that we and the content team are familiar with.");

	}

	private Div card(Div row, String image, String title)
	{
		return card(row, image, title, null);
	}

	private Div card(Div row, String image, String title, String description)
	{
		Div colImage = row.ac(div("col-12 col-md-4 mb-2 mb-md-0"));
		colImage.ac(img("/" + CacheBusting.resolve(image)))
				.addClass("img-fluid")
				.attr("style", "display: block; margin: auto; max-height: 6em");
		Div colDesc = row.ac(div("col-12 col-md-8"));
		colDesc.ac(h3(title));
		if (description != null) {
			colDesc.ac(p()).at(description);
		}
		return colDesc;
	}

	private void divider(Div row)
	{
		row.ac(HTML.hr().addClass("w-100"));
	}

}
