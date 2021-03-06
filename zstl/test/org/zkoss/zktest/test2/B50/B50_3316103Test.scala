/* B50_3316103Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 10:30:55 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3316103
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3316103.zul,A,M,Combobox,Datebox,EE")
class B50_3316103Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

			<zk>
				<div>
					This test case requires to specify the following in zk.xml:
					<![CDATA[
					<listener>
						<listener-class>org.zkoss.zkmax.au.InaccessibleWidgetBlockService$DesktopInit</listener-class>
					</listener>
					]]>
				</div>
				<div>
					1. Select an item from the Combobox. You should see text appearing on the right. Otherwise it is a bug.
				</div>
				<div>
					2. Pick a date in the Datebox. You should see text appearing on the right. Otherwise it is a bug.
				</div>
				<hlayout>
					<combobox id="cbx" readonly="true" onChange="label2.setValue(self.getRawText())">
						<comboitem label="1" />
						<comboitem label="2" />
						<comboitem label="3" />
					</combobox>
					<label id="label2" />
				</hlayout>
				<hlayout>
					<datebox id="dbx" readonly="true" onChange="label3.setValue(self.getRawText())" />
					<label id="label3" />
				</hlayout>
			</zk>

    """
    runZTL(zscript,
      () => {
        var cbx: Widget = engine.$f("cbx")
        var dbx: Widget = engine.$f("dbx")
        var label2: Widget = engine.$f("label2")
        var label3: Widget = engine.$f("label3")
        click(cbx.$n("btn"));
        waitResponse();
        click(jq(cbx.$n("pp")).find(".z-comboitem").get(1));
        waitResponse();
        verifyEquals("the value of combobox should equal to the label text next to it",
          cbx.$n("real").attr("value"), label2.$n().attr("innerHTML"))
        click(dbx.$n("btn"));
        click(jq(dbx.$n("pp")).find(".z-calendar-weekday").get(10));
        waitResponse();
        verifyEquals("the value of datebox should equal to the label text next to it",
          dbx.$n("real").attr("value"), label3.$n().attr("innerHTML"))
      }
    );

  }
}