package com.comcast.functional.visitor;

import java.util.function.Consumer;

/**
 * @author rkasar422
 *
 */
public class VisitorMain {

	public static void main(String[] args) {
		DLinkRouter dlink = new DLinkRouter();
		TPLinkRouter tplink = new TPLinkRouter();
		LinkSysRouter linksys = new LinkSysRouter();

		Consumer<VisitorBuilder<String>> consumer = Visitor.<String>forType(DLinkRouter.class)
				.execute(d -> "DLinkRouter.." + d).forType(TPLinkRouter.class).execute(t -> "TPLinkRouter.." + t);

		Visitor<String> visitor = Visitor.of(consumer);

		String dlRouter = visitor.visit(dlink);
		System.out.println("dlrouter.." + dlRouter);

		String tplinkRouter = visitor.visit(tplink);
		System.out.println("tplinkRouter.." + tplinkRouter);

	}

}
