package com.comcast.functional.visitor;

/**
 * @author rkasar422
 *
 */
public class LinuxConfigurator implements RouterVisitor {

	@Override
	public void visit(DLinkRouter router) {
		System.out.println("DLinkRouter Configuration for Linux complete !!");
	}

	@Override
	public void visit(TPLinkRouter router) {
		System.out.println("TPLinkRouter Configuration for Linux complete !!");
	}

	@Override
	public void visit(LinkSysRouter router) {
		System.out.println("LinkSysRouter Configuration for Linux complete !!");
	}
}
