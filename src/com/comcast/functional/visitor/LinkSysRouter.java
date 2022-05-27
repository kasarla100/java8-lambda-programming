package com.comcast.functional.visitor;

/**
 * @author rkasar422
 *
 */
public class LinkSysRouter implements Router {

	@Override
	public void sendData(char[] data) {
	}

	@Override
	public void acceptData(char[] data) {
	}

	@Override
	public void accept(RouterVisitor v) {
		v.visit(this);
	}
}
