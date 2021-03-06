package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2194.zul")
class B70_ZK_2194Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2194.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Mar 24, 2014  4:21:13 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
Please click this button, and the item 8 should be scroll into the viewport.
    <button label="Scroll into view">
    <attribute name="onClick"><![CDATA[
    Clients.scrollIntoView(item);
    ]]></attribute>
    </button>
    <div height="100%"/>
    <listbox rows="3">
        <listitem label="1"/>
        <listitem label="2"/>
        <listitem label="3"/>
        <listitem label="4"/>
        <listitem label="5"/>
        <listitem label="6"/>
        <listitem label="7"/>
        <listitem id="item" label="8"/>
        <listitem label="9"/>
        <listitem label="10"/>          
    </listbox>
</zk>
"""
    runZTL(zscript,
      () => {
        click(jq(".z-button"))
        waitResponse()
        verifyTrue("the item 8 should be scroll into the viewport.", jq(".z-listitem:contains(8)").exists)
      })

  }
}