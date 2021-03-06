package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-2716.zul")
class B80_ZK_2716Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B80-ZK-2716.zul

  Purpose:
    
  Description:
    
  History:
    Tue, Apr 21, 2015  5:13:18 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk xmlns:x="xhtml">
  <label multiline="true">
  1. click button 1 will change color to green and text to "green"
  2. click button 2 will change color to blue and text to "blue"
  </label>
  <x:div id="xdiv" style="color: red"
      textContent="red"/>
  <button id="btn1" label="1. style, 2. textContent" 
      onClick='
        xdiv.setStyle("color: green"); 
        xdiv.setDynamicProperty("textContent", "green")'/>
  <button id="btn2" label="1. textContent, 2. style" 
      onClick='
        xdiv.setDynamicProperty("textContent", "blue"); 
        xdiv.setStyle("color: blue");'/>
</zk>

"""
    runZTL(zscript,
      () => {
        var div = jq("#xdiv");
        verifyEquals("red", div.text());
        verifyContains(div.attr("style"), "red")

        click(jq(".z-button").first());
        waitResponse();
        verifyEquals("green", div.text());
        verifyContains(div.attr("style"), "green")

        click(jq(".z-button").last());
        waitResponse();
        verifyEquals("blue", div.text());
        verifyContains(div.attr("style"), "blue")
      })

  }
}