/* B50_ZK_641Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Dec 07 12:20:33 CST 2011 , Created by benbai
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
  * A test class for bug ZK-641
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-641.zul,B,M,Borderlayout,IE")
class B50_ZK_641Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<borderlayout>
					<west>
						<label id="lbOne" value="Some long text on the left" />
					</west>
					<center style="color: red; font-weight: bold">
						<div>
							<div>* IE only.</div>
							<div>* The text in West and East region should not wrap.</div>
							<label id="lbTwo" value="Single line" />
						</div>
					</center>
					<east>
						<label id="lbThree" value="Some text on the right" />
					</east>
				</borderlayout>
			</zk>

    """
    runZTL(zscript, () => {
      var lbOne: Widget = engine.$f("lbOne");
      var lbTwo: Widget = engine.$f("lbTwo");
      var lbThree: Widget = engine.$f("lbThree");

      verifyTrue("The three labels should be single line",
        jq(lbOne.$n()).height() == jq(lbTwo.$n()).height()
          && jq(lbThree.$n()).height() == jq(lbTwo.$n()).height());
    })
  }
}