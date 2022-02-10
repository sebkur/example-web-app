package de.mobanisto.example.webapp.resolving;

import de.topobyte.webgun.resolving.pathspec.PathSpec;
import de.topobyte.webgun.resolving.smart.defs.PathDef0;
import de.topobyte.webgun.resolving.smart.defs.PathDef3;
import de.topobyte.webgun.resolving.smart.mappers.StringMapper;

public class LinkDefs
{

	public static PathDef0 ABOUT = new PathDef0(new PathSpec("about"));
	public static PathDef0 IMPRINT = new PathDef0(new PathSpec("imprint"));
	public static PathDef0 PRIVACY_POLICY = new PathDef0(
			new PathSpec("privacy-policy"));

	public static PathDef0 PLUGINS = new PathDef0(new PathSpec("plugins"));
	public static PathDef3<String, String, String> PLUGIN = new PathDef3<>(
			new PathSpec("plugin", ":group:", ":artifcat:", ":version:"),
			new StringMapper(), new StringMapper(), new StringMapper());

}
