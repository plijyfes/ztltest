/* B30_1823236Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1823236Test extends ZTL4ScalaTestCase {
  @Test
  def testLayout() = {
    var zscript =
      """
<zk>
<html><![CDATA[
1. Watch the listbox headers, there should be two headers (header1, header2) there.<br/>
2. Press add item button, you should see first0 and last0 as the first Listitem. But the header2 appear and gone immediately. (IE show horizontal and vertical scrollbar).<br/>
3. Press invalidate will correct the case.<br/>
NOTE: The mentioned bug occurs only if you add item via ListModel and ListDataEvent. If you add Listitem and listcells directly, it works ok.<br/>
]]></html>
<zscript>
    int count = 0;
	List lst = new ArrayList(10);
	ListModel lm = new ListModelList(lst);
	
	class Person {
		String fn;
		String ln;
		public Person(String f, String l) {
			fn = f;
			ln = l;
		}
		public getFn() {
			return fn;
		}
		public getLn() {
			return ln;
		}
	}
	
	public class Rend implements ListitemRenderer {
		public void render(Listitem item, java.lang.Object data, int index)  {
			new Listcell(data.getFn()).setParent(item);
			new Listcell(data.getLn()).setParent(item);
		}
	}
	
	ListitemRenderer rend = new Rend();
</zscript>
<listbox id="lb" width="200px" model="${lm}" itemRenderer="${rend}">
	<listhead>
		<listheader id="h1" label="header1"/>
		<listheader id="h2" label="header2"/>
	</listhead>
</listbox>
<button id="btn" label="add item">
	<attribute name="onClick">
	((List)lb.getModel()).add(new Person("first"+count, "last"+count));
	++count;
	</attribute>
</button>
<button label="invalidate" onClick="lb.invalidate()"/>
</zk>
		 """
    val ztl$engine = engine()
    val lb = ztl$engine.$f("lb")
    val h1 = ztl$engine.$f("h1")
    val h2 = ztl$engine.$f("h2")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      verifyTrue(isVisible(h1))
      verifyTrue(isVisible(h2))
      verifyTrue(jq(h1).height() > 10)
      verifyTrue(jq(h1).width() > 30)
      verifyTrue(jq(h2).height() > 10)
      verifyTrue(jq(h2).width() > 30)
      verifyEquals(jq(lb).width(), jq(lb.$n("head")).outerWidth())
      click(btn)
      waitResponse()
      verifyEquals(jq(lb).height(), jq(lb.$n("head")).outerHeight() +
        jq(lb.$n("body")).outerHeight())
      verifyNotEquals(0, jq(lb.$n("body")).height())
      verifyEquals(jq(lb.$n("body")).outerHeight(), jq(lb.$n("cave")).outerHeight())
      verifyEquals(jq(lb.$n("body")).outerWidth(), jq(lb.$n("cave")).outerWidth())
    })
  }
}



