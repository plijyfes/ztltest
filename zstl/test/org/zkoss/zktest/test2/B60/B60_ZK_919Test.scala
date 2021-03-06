package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-919.zul")
class B60_ZK_919Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      val datelongfmt0 = jq(jq(".z-datebox:eq(0)").toWidget().$n("real")).`val`()
      val datelongfmt1 = jq(jq(".z-datebox:eq(1)").toWidget().$n("real")).`val`()
      val datelongfmt2 = jq(jq(".z-datebox:eq(2)").toWidget().$n("real")).`val`()
      val datelongfmt3 = jq(jq(".z-datebox:eq(3)").toWidget().$n("real")).`val`()
      for (i <- 0 to 3) {
        click(jq(".z-datebox:eq(" + i + ")").toWidget().$n("btn"))
        waitResponse()
        click(jq(".z-calendar:eq(" + i + ") .z-calendar-cell:contains(14)"))
        waitResponse()
      }
      verifyFalse("should not see any error message.", jq(".z-errorbox").exists())
    })

  }
}
