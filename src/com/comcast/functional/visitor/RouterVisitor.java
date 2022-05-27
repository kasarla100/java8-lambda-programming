package com.comcast.functional.visitor;

/**
 * @author rkasar422
 *
 */
public interface RouterVisitor {
    public void visit(DLinkRouter router);
    public void visit(TPLinkRouter router);
    public void visit(LinkSysRouter router);
}
