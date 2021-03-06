/* B30_1813271Test.java

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


class B30_1813271Test extends ZTL4ScalaTestCase {
  @Test
  def testDatabinding() = {
    var zscript =
      """
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<zk	xmlns:h="http://www.w3.org/1999/xhtml" xmlns:zk="http://www.zkoss.org/2005/zk">
<html><![CDATA[
Test xhtml component inside grid with annotation databinding (this bug generate duplicate ids)<br/>
1. You should see 4 hyperlinks below inside a grid and a listbox.<br/>
2. If you can see the 4 hyperlinks there, it is correct.
]]></html>
<zscript>
	public class Link {
		private String _href;
		
		public Link(String href) {
			setLink(href);
		}
		
		public String getLink() {
			return _href;
		}
		
		public void setLink(String href) {
			_href = href;
		}
	}

	List links = new ArrayList(3);
	links.add(new Link("http://www.zkoss.org"));
	links.add(new Link("http://jp.zkoss.org"));
	links.add(new Link("http://zh.zkoss.org"));
	links.add(new Link("http://www.potix.com"));
</zscript>

<groupbox>
	<caption label="grid"/>
	<grid id="grid" model="@{links}">
	<rows>
	<row each="@{link1}">
		<h:a href="@{link1.link}"><label value="@{link1.link}"/></h:a>
	</row>
	</rows>
	</grid>
</groupbox>

<groupbox>
	<caption label="listbox"/>
	<listbox id="listbox" model="@{links}">
	<listitem each="@{link2}">
		<listcell><h:a href="@{link2.link}"><label value="@{link2.link}"/></h:a></listcell>
	</listitem>
	</listbox>
</groupbox>
</zk>
		"""
    val ztl$engine = engine()
    val grid = ztl$engine.$f("grid")
    val listbox = ztl$engine.$f("listbox")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      verifyEquals("http://www.zkoss.org", jq("@row @label:eq(0)").html())
      verifyEquals("http://jp.zkoss.org", jq("@row @label:eq(1)").html())
      verifyEquals("http://zh.zkoss.org", jq("@row @label:eq(2)").html())
      verifyEquals("http://www.potix.com", jq("@row @label:eq(3)").html())
      verifyEquals("http://www.zkoss.org", jq("@listitem @label:eq(0)").html())
      verifyEquals("http://jp.zkoss.org", jq("@listitem @label:eq(1)").html())
      verifyEquals("http://zh.zkoss.org", jq("@listitem @label:eq(2)").html())
      verifyEquals("http://www.potix.com", jq("@listitem @label:eq(3)").html())
    })
  }
}



