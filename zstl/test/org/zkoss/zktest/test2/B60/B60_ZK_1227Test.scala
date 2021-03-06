package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1227.zul")
class B60_ZK_1227Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    Should not see any error message.<separator/>
                    <decimalbox value="1111.112" locale="pt" format="#.##0,0##"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyFalse("should not see any error message.", jq(".z-errorbox").exists())
      })

  }
}
