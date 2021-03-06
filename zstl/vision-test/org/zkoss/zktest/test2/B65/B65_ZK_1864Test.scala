package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1864.zul")
class B65_ZK_1864Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1864.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Jul 26, 2013  2:09:04 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	<window title="Selection Model Issue" border="normal" hflex="1" vflex="1">
	1.Please select one item of the top listbox.
	<separator/>
	2.The second grid should not be reloaded.
	<zscript><![CDATA[
	    class Obj {
	    	String str;
	    	public Obj(String str){
	    		this.str = str;
	    	}
	    	
	    	public String toString(){
	    		return str+"-"+new Date().getTime();
	    	}
	    }
	                  
		ListModelList model = new ListModelList();
		model.add(new Obj("A"));
		model.add(new Obj("B"));
		model.add(new Obj("C"));
	]]></zscript>
		<listbox model="${model}" onSelect="//"></listbox>
		<grid model="${model}"></grid>
	</window>
</zk>
"""  
  runZTL(zscript,
    () => {
      click(jq(".z-listitem:contains(A)"))
      waitResponse()
      verifyImage()
    })
    
  }
}