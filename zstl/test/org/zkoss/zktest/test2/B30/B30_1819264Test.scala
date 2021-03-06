/* B30_1819264Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1819264Test extends ZTL4ScalaTestCase {
  @Test
  def testConstraint() = {
    var zscript =
      """
<borderlayout height="300px">
	<center autoscroll="true">
		<div height="500px">
			Please focus in the textbox, then focus out, and then when
			you scroll up/down the scroll bar, the error box should be
			moved according to the textbox.
			<separator />
			<textbox id="tb" value="show Error" constraint="/.+@.+\.[a-z]+/" />
		</div>
	</center>
</borderlayout>
		 """
    val ztl$engine = engine()
    val tb = ztl$engine.$f("tb")
    runZTL(zscript, () => {
      var center = jq(".z-center").toWidget()
      focus(tb)
      blur(tb)
      sleep(300)
      verifyTrue(jq("@errorbox").exists())
      var str = jq("@errorbox").toElement().attr("style.top")
      var beforeTop = parseInt(str)
      verScroll(center, 5)
      verifyTolerant(jq(tb).offsetTop(), jq("@errorbox").offsetTop(), 1)
      verScroll(center, 0)
      str = jq("@errorbox").toElement().attr("style.top")
      var afterTop = parseInt(str)
      verifyTolerant(beforeTop, afterTop, 1)
    })
  }
}



