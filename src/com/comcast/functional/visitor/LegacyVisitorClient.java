package com.comcast.functional.visitor;

public class LegacyVisitorClient {

	private MacConfigurator macConfigurator = new MacConfigurator();
	private LinuxConfigurator linuxConfigurator = new LinuxConfigurator();
	private DLinkRouter dlink = new DLinkRouter();
	private TPLinkRouter tplink = new TPLinkRouter();
	private LinkSysRouter linksys = new LinkSysRouter();

	public static void main(String[] args) {

		LegacyVisitorClient client = new LegacyVisitorClient();
		client.dlink();
		System.out.println("\n");
		client.tpLink();
		System.out.println("\n");
		client.linkSys();

	}

	public void dlink() {
		dlink.accept(macConfigurator);
		dlink.accept(linuxConfigurator);
	}

	public void tpLink() {
		tplink.accept(macConfigurator);
		tplink.accept(linuxConfigurator);
	}

	public void linkSys() {
		linksys.accept(macConfigurator);
		linksys.accept(linuxConfigurator);
	}

}
