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
class Z60_LoadTest extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = """
      <include src="/bind/basic/load.zul"/>
"""

    runZTL(zul, () => {
      val t1 = engine.$f("l1")
      val l2 = engine.$f("l2")
      val l3 = engine.$f("l3")
      val l4 = engine.$f("l4")
      val l5 = engine.$f("l5")
      val l6 = engine.$f("l6")
      val l7 = engine.$f("l7")
      val l8 = engine.$f("l8")

      verifyEquals("First1", getValue(t1));
      verifyEquals("Last1", getText(l2));
      verifyEquals("First1 Last1", getText(l3));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
      verifyEquals("First1", getText(l5));
      verifyEquals("Last1", getText(l6));
      verifyEquals("First1 Last1", getText(l7));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));

      //    	Assert.assertEquals("First1",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("First1 Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("First1",findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("First1 Last1",findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));

      val btn1 = engine.$f("btn1")
      click(btn1)
      waitResponse()
      verifyEquals("Dennis", getValue(t1));
      verifyEquals("Last1", getText(l2));
      verifyEquals("Dennis Last1", getText(l3));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
      verifyEquals("Dennis", getText(l5));
      verifyEquals("Last1", getText(l6));
      verifyEquals("Dennis Last1", getText(l7));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
      //		findWidget("$btn1").click();
      //		Assert.assertEquals("Dennis",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("Dennis Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("Dennis",findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("Dennis Last1",findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));

      click(engine.$f("btn2"))
      waitResponse()
      verifyEquals("Dennis", getValue(t1));
      verifyEquals("Chen", getText(l2));
      verifyEquals("Dennis Chen", getText(l3));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
      verifyEquals("Dennis", getText(l5));
      verifyEquals("Chen", getText(l6));
      verifyEquals("Dennis Chen", getText(l7));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
      //		findWidget("$btn2").click();
      //		Assert.assertEquals("Dennis",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("Dennis Chen",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("Dennis",findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("Dennis Chen",findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));

      click(engine.$f("btn3"))
      waitResponse()
      verifyEquals("Alex", getValue(t1));
      verifyEquals("Chen", getText(l2));
      verifyEquals("Alex Chen", getText(l3));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
      verifyEquals("Alex", getText(l5));
      verifyEquals("Chen", getText(l6));
      verifyEquals("Alex Chen", getText(l7));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
      //		findWidget("$btn3").click();
      //		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("Alex Chen",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("Alex Chen",findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));

      click(engine.$f("btn4"))
      waitResponse()
      verifyEquals("Alex", getValue(t1));
      verifyEquals("Wang", getText(l2));
      verifyEquals("Alex Wang", getText(l3));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
      verifyEquals("Alex", getText(l5));
      verifyEquals("Wang", getText(l6));
      verifyEquals("Alex Wang", getText(l7));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
      //		findWidget("$btn4").click();
      //		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Wang",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("Alex Wang",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Wang",findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("Alex Wang",findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));

      click(engine.$f("btn5"))
      waitResponse()
      verifyEquals("Alex", getValue(t1));
      verifyEquals("Chen", getText(l2));
      verifyEquals("Alex Chen", getText(l3));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
      verifyEquals("Alex", getText(l5));
      verifyEquals("Chen", getText(l6));
      verifyEquals("Alex Chen", getText(l7));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
      //		findWidget("$btn5").click();
      //		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("Alex Chen",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("Alex Chen",findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));

      click(engine.$f("btn6"))
      waitResponse()
      verifyEquals("Alex", getValue(t1));
      verifyEquals("Wang", getText(l2));
      verifyEquals("Alex Wang", getText(l3));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
      verifyEquals("Alex", getText(l5));
      verifyEquals("Wang", getText(l6));
      verifyEquals("Alex Wang", getText(l7));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
      //		findWidget("$btn6").click();
      //		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Wang",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("Alex Wang",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Wang",findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("Alex Wang",findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));

      //we have spec change here since 10/29, revision 18, notify p1 will also cause selected reload(they are same instance)
      click(engine.$f("btn7"))
      waitResponse()
      verifyEquals("Ian", getValue(t1));
      verifyEquals("Tasi", getText(l2));
      verifyEquals("Ian Tasi", getText(l3));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
      verifyEquals("Ian", getText(l5));
      verifyEquals("Tasi", getText(l6));
      verifyEquals("Ian Tasi", getText(l7));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
      //		findWidget("$btn7").click();
      //		Assert.assertEquals("Ian",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Tasi",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("Ian Tasi",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("Ian",findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Tasi",findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("Ian Tasi",findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));

      //we have spec change here since 10/29, revision 18, notify selected will also cause p1 reload(they are same instance)
      click(engine.$f("btn8"))
      waitResponse()
      verifyEquals("Jumper", getValue(t1));
      verifyEquals("Chen", getText(l2));
      verifyEquals("Jumper Chen", getText(l3));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l4));
      verifyEquals("Jumper", getText(l5));
      verifyEquals("Chen", getText(l6));
      verifyEquals("Jumper Chen", getText(l7));
      verifyEquals("87 Zhengzhou Road #11F-2 Taipei", getText(l8));
      //		findWidget("$btn8").click();
      //		Assert.assertEquals("Jumper",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("Jumper Chen",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("Jumper",findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("Jumper Chen",findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));      

    })
  }
}
