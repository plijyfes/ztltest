/* B30_1862835Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1862835Test extends ZTL4ScalaTestCase {
  @Test
  def testCal() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"?>

			<window id="testwin" xmlns="http://www.zkoss.org/2005/zul"
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xmlns:a="http://www.zkoss.org/2005/zk/annotation"
				xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:h5>Please click the cell "Second" twice or triple, the second grid will recalculate its width every time.</n:h5>
				<zscript>
					import java.util.ArrayList; 
					import java.util.HashSet; 
					import org.zkoss.zul.ListModelSet;
			
					public class Item { 
						public short purchase; 
						public double cost;
						public Item( short p, double c) { 
							this.purchase=p; this.cost=c;
						} 
					};
			
					public class Base { 
						public String name; 
						public HashSet items;
			
						public Base(String n) { 
							this.name = n; 
							this.items = new HashSet();
						} 
					};
			
					_wdBundles = new ArrayList(); 
					_wdBundleItems = new ListModelSet(new HashSet(),true);
			
					baseA = new Base("First"); 
					baseA.items.add(new Item((short)0,0.00)); 
					_wdBundles.add(baseA);
			
					baseB = new Base("Second"); 
					baseB.items.add(new	Item((short)1,18.00)); 
					_wdBundles.add(baseB);
			
					void exposeItems(Base b) { 
						_wdBundleItems.clear();
						_wdBundleItems.addAll(b.items); 
						testwin.getAttribute("binder", true).loadAll(); 
					}
			
				</zscript>
			
			
				<grid mold="paging" pageSize="8" width="600px"
					model="@{_wdBundles}">
					<columns>
						<column label="Bundle" width="35%" />
						<column label="Items" />
					</columns>
					<rows>
						<row self="@{each='bundle'}" value="@{bundle}">
							<label value="@{bundle.name}"
								onClick="exposeItems(self.parent.value)" />
							<label value="@{bundle.items.size}" />
						</row>
					</rows>
				</grid>
				<space />
				<grid id="itemgrid" model="@{_wdBundleItems}" width="600px">
					<columns>
						<column label="Purchase" align="center" />
						<column label="Cost" align="right" />
					</columns>
					<rows>
						<row self="@{each='item'}">
							<label value="@{item.purchase}" />
							<decimalbox value="@{item.cost}" readonly="true"
								format="$#,###.##" />
						</row>
					</rows>
				</grid>
			</window>
		"""
    val ztl$engine = engine()
    val testwin = ztl$engine.$f("testwin")
    val itemgrid = ztl$engine.$f("itemgrid")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      click(jq(".z-label:eq(2)"))
      waitResponse()
      verifyEquals("$18", jq(".z-decimalbox").`val`())
    })
  }
}



