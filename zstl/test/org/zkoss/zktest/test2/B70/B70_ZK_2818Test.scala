package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2818.zul")
class B70_ZK_2818Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<!--
B70-ZK-2818.zul

	Purpose:

	Description:

	History:
		Thu Jul 23 11:00:37 CST 2015, Created by jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<window apply="org.zkoss.zktest.test2.B70_ZK_2818">
	<label>Refresh several times, you should not see "I am busy" holding still</label>
    <timer id="timer" delay="1000" repeats="true" />
    <label>outer component</label>
</window>

"""
    runZTL(zscript,
      () => {
        sleep(1000)
        verifyFalse(jq(".z-apply-loading").exists());
      })
  }
}