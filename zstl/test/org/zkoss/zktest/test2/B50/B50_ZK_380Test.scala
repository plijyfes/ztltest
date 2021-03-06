/* B50_ZK_380Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_ZK_380Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				Item 2 is not checkable, and it shall NOT be selectable
				<tree id="tree" multiple="true" checkmark="true">
					<treecols>
						<treecol label="Name" />
					</treecols>
					<treechildren>
						<treeitem id="i1" label="Item 1">
							<attribute name="onClick">
								l1.setValue(self.isSelected() + "");
							</attribute>
						</treeitem>
						<treeitem id="i2" checkable="false" open="false" label="Item 2">
							<attribute name="onClick">
								l2.setValue(self.isSelected() + "");
							</attribute>
							<treechildren>
								<treeitem label="Item 2.1">
									<treechildren>
										<treeitem label="Item 2.1.1" />
										<treeitem label="Item 2.1.2" />
									</treechildren>
								</treeitem>
								<treeitem label="Item 2.2" />
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
				item 1 selected? <label id="l1" />
				item 2 selected? <label id="l2" />
			</zk>

		"""
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    val i1 = ztl$engine.$f("i1")
    val i2 = ztl$engine.$f("i2")
    val l1 = ztl$engine.$f("l1")
    val l2 = ztl$engine.$f("l2")
    runZTL(zscript, () => {
      verifyNotEquals("hidden", i1.$n("cm").attr("style.visibility"))
      verifyEquals("hidden", i2.$n("cm").attr("style.visibility"))
      click(i1)
      waitResponse()
      click(i2)
      waitResponse()
      verifyEquals("true", getText(l1))
      verifyEquals("false", getText(l2))
    })
  }
}



