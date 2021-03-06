/* B30_1823226Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1823226Test extends ZTL4ScalaTestCase {
  @Test
  def testDragdrop() = {
    var zscript =
      """
<zk>
Splitter can be dragged over hbox border.
<window border="normal" width="800px" title="Case 1: hbox and splitter">
		<hbox height="100px" width="100%">
		cdacdacdacdacdaca
		<splitter id="hsplitter" collapse="none"/>
		cdacdacdacdacacsdc
		</hbox>
	</window></zk>
		 """
    val ztl$engine = engine()
    val hsplitter = ztl$engine.$f("hsplitter")
    runZTL(zscript, () => {
      var width = jq("@box @label").parent().width()
      dragdropTo(hsplitter, "1,1", "-19, 1")
      waitResponse()
      verifyTolerant(width - 20, jq("@box @label").parent().width(), 1)
      dragdropTo(hsplitter, "1,1", "21, 1")
      waitResponse()
      verifyTolerant(width, jq("@box @label").parent().width(), 1)
    })
  }
}



