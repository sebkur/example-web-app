package de.mobanisto.example.webapp.widgets;

import static de.topobyte.jsoup.HTML.a;
import static de.topobyte.jsoup.HTML.p;

import de.mobanisto.example.webapp.resolving.LinkDefs;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.Bootstrap;
import de.topobyte.jsoup.bootstrap4.components.Container;
import de.topobyte.jsoup.components.A;
import de.topobyte.jsoup.components.P;
import de.topobyte.jsoup.components.UnorderedList;
import de.topobyte.jsoup.feather.Feather;
import de.topobyte.jsoup.nodes.Element;
import de.topobyte.pagegen.core.LinkResolver;

public class MainFooter extends Element<MainFooter>
{

	public MainFooter(LinkResolver resolver)
	{
		super("footer");
		attr("class", "footer");

		Container div = ac(Bootstrap.container());

		UnorderedList links = div.ac(HTML.ul());

		String imprintLink = LinkDefs.IMPRINT.getLink();
		A linkImprint = a(imprintLink, "Imprint");
		links.addItem(linkImprint);

		String privacyLink = LinkDefs.PRIVACY_POLICY.getLink();
		A linkPrivacy = a(privacyLink, "Privacy Policy");
		links.addItem(linkPrivacy);

		P p = div.ac(p().addClass("text-muted"));

		p.at("Made with ");
		p.ac(Feather.heart("16"));
		p.at(" in Berlin");
	}

}
