/* Z60_B00992SubModelTest.scala

	Purpose:
		
	Description:
		
	History:
		Apr 20, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zktest.bind.issue
import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00992SubModelTest extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00992SubModel.zul"/>
"""

    runZTL(zul, () => {

      var combobox = jq("$combobox")
      var lab = jq("$lab")

      `type`(combobox.toWidget().$n("real"), "9")
      waitResponse()
      verifyEquals("9", lab.toWidget().attr("value"))

      evalScript(combobox.toWidget() + ".open()")
      waitResponse()

      var w = combobox.find("@comboitem").eq(10)

      verifyEquals("99", w.toWidget().attr("label"))
      click(w.toWidget())
      waitResponse()

      verifyEquals("99", lab.toWidget().attr("value"))

    })
  }
}