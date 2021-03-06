/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.basic

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_LoadIndirect2Test extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = """
      <include src="/bind/basic/load-indirect.zul"/>
"""

    runZTL(zul, () => {
      val t1 = engine.$f("l1")
      val l2 = engine.$f("l2")
      val l3 = engine.$f("l3")
      val l4 = engine.$f("l4")
      val selectBox = (engine.$f("select"))

      verifyEquals("First1", getValue(t1));
      verifyEquals("Last1", getText(l2));
      verifyEquals("First1 Last1", getText(l3));
      verifyEquals("First1", getText(l4));
      verifyEquals("0", getSelectedIndex(selectBox));
      //		Assert.assertEquals("First1",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("First1 Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("First1",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals(0L,findWidget("$select").getAttribute("selectedIndex"));

      `type`(t1, "AAA")
      click(engine.$f("btn1"))
      waitResponse()
      verifyEquals("Last1", getText(l2));
      verifyEquals("AAA Last1", getText(l3));
      verifyEquals("AAA", getText(l4));
      //		findWidget("$l1").clear().keys("AAA");
      //		findWidget("$btn1").focus();
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("AAA Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("AAA",findWidget("$l4").getAttribute("value"));

      select(selectBox, "lastName")
      waitResponse()
      verifyEquals("AAA", getValue(t1));
      verifyEquals("Last1", getText(l2));
      verifyEquals("AAA Last1", getText(l3));
      verifyEquals("Last1", getText(l4));
      verifyEquals("1", getSelectedIndex(selectBox));
      //		((SelectWidget)findWidget("$select")).select(1);
      //		Assert.assertEquals("AAA",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("AAA Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals(1L,findWidget("$select").getAttribute("selectedIndex"));

      `type`(t1, "BBB")
      waitResponse()
      verifyEquals("Last1", getText(l2));
      verifyEquals("BBB Last1", getText(l3));
      verifyEquals("Last1", getText(l4));
      //		findWidget("$l1").clear().keys("BBB");
      //		findWidget("$btn1").focus();
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l4").getAttribute("value"));

      select(selectBox, "fullName")
      waitResponse()
      verifyEquals("BBB", getValue(t1));
      verifyEquals("Last1", getText(l2));
      verifyEquals("BBB Last1", getText(l3));
      verifyEquals("BBB Last1", getText(l4));
      verifyEquals("2", getSelectedIndex(selectBox));
      //		((SelectWidget)findWidget("$select")).select(2);
      //		Assert.assertEquals("BBB",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("BBB Last1",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals(2L,findWidget("$select").getAttribute("selectedIndex"));

      select(selectBox, "firstName")
      waitResponse()
      verifyEquals("BBB", getValue(t1));
      verifyEquals("Last1", getText(l2));
      verifyEquals("BBB Last1", getText(l3));
      verifyEquals("BBB", getText(l4));
      verifyEquals("0", getSelectedIndex(selectBox));
      //		((SelectWidget)findWidget("$select")).select(0);
      //		Assert.assertEquals("BBB",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("BBB",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals(0L,findWidget("$select").getAttribute("selectedIndex"));

    })
  }
}
