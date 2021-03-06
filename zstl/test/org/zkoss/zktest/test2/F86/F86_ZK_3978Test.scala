package org.zkoss.zktest.test2.F86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3978.zul")
class F86_ZK_3978Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      verScroll(jq("@tree"), 50)
      waitResponse()
      verScroll(jq("@tree"), 0)
      waitResponse()
      closeZKLog()
      click(jq(".z-tree-icon:eq(0)"))
      waitResponse()
      verifyEquals("OnDataLoading more than once", 1, getEval("getZKLogLineCnt()"))
    })
  }
}
