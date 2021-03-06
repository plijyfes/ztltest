/* B50_3314513Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 11:00:35 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3314513
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3314513.zul,A,E,Datebox")
class B50_3314513Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """

			<zk>
				<html><![CDATA[
					<ol>
						<li>Type "abc" in the following 4 dateboxes. All four should show errors.</li>
					</ol>
				]]></html>
    			<label id="outer" value="outer" />
    			<div></div>
				<label id="lb1" value="en_US: " />
				<datebox id="dbx1" locale="en_US" />
				<separator />
				<label value="zh_TW: " />
				<datebox id="dbx2" locale="zh_TW" />
				<separator />
				<label value="de_DE: " />
				<datebox id="dbx3" locale="de_DE" />
				<separator />
				<label value="fr_FR: " />
				<datebox id="dbx4" locale="fr_FR" />
			</zk>

    """
    runZTL(zscript,
      () => {
        var outer: Widget = engine.$f("outer");
        var lb1: Widget = engine.$f("lb1")
        var dbx1: Widget = engine.$f("dbx1")
        var dbx2: Widget = engine.$f("dbx2")
        var dbx3: Widget = engine.$f("dbx3")
        var dbx4: Widget = engine.$f("dbx4")
        click(dbx1.$n("real"));
        `type`(dbx1.$n("real"),"abc")
        waitResponse();
        click(dbx2.$n("real"));
        `type`(dbx2.$n("real"),"abc")
        waitResponse();
        click(dbx3.$n("real"));
        `type`(dbx3.$n("real"),"abc")
        waitResponse();
        click(dbx4.$n("real"));
        `type`(dbx4.$n("real"),"abc")
        click(outer);
        waitResponse();

        waitResponse();
        verifyTrue("all four datebox should show error",
          jq(".z-errorbox").length() == 4);
      }
    );

  }
}