/* B50_2973303Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 15:04:29 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
  * A test class for bug 2973303
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-2973303.zul,A,E,SELECT,Listbox")
class B50_2973303Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
			<html><![CDATA[
				<ul>
				<li>You see see nothing shown in the following listbox</li>
				</ul>
			]]></html>
			<listbox id="listbox" mold="select" rows="1">
			<listitem label="A" />
			<listitem label="B" />
			<listitem label="C" />
			</listbox>
			</zk>

    """

    def executor = () => {
      var listbox: Widget = engine.$f("listbox");
      waitResponse();
      verifyTrue(listbox.$n().get("value").length() == 0);
    }

    runZTL(zscript, executor);
  }
}