package com.comcast.functional.visitor;

/**
 * @author rkasar422
 *
 */
public interface Router {
	public void sendData(char[] data);

	public void acceptData(char[] data);

	public void accept(RouterVisitor v);
}
