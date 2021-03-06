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
package org.zkoss.zktest.bind.comp

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author Hawk
 */
@Tags(tags = "zbind")
class Z60_TreeTest extends ZTL4ScalaTestCase {
  @Test
  def testAttribute() = {
    val zul = """
	<include src="bind/comp/tree.zul"/>
"""
    runZTL(zul, () => {
    
      val tree = engine.$f("tree")
      
      val selectedLabel = engine.$f("selectedLabel")
      
      click(jq("@treerow").eq(1));
      waitResponse()
      verifyEquals("Root.1", getText(selectedLabel));
      
      val open = engine.$f("open")
      click(jq(".z-treerow:contains(0)").toWidget().$n("open"))
      waitResponse()
      verifyEquals("true", getText(open));
      
      click(jq("@treechildren").eq(1));
      waitResponse()
      verifyEquals("Root.0.0", getText(selectedLabel));

      click(jq(".z-treerow:contains(1):eq(1)").toWidget().$n("open"))
      waitResponse()
      verifyEquals("false", getText(open));
    })
  }
}