package de.mobanisto.example.webapp.util;

import org.jsoup.nodes.Element;

import de.topobyte.jsoup.HTML;

public class ErrorUtil
{

	public static void write404(Element content)
	{
		content.appendChild(HTML.h1().text("Page not found"));
		content.appendText("Error code: 404");
	}

	public static void writeError(Element content)
	{
		content.appendChild(HTML.h1().text("Ouch!"));
		content.appendText("Something went wrong");
	}

}
