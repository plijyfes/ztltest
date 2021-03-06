/* B30_1904389Test.java

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


class B30_1904389Test extends ZTL4ScalaTestCase {
  @Test
  def testBinding() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?> 
			<?page title="bindingValidation Test"?>
			<zk>
			<html><![CDATA[
			1. Press the "submit" button. You should not see any change on the screen.<br/>
			2. The server console should show following four lines:<br/>
			validationForGrid called:CA<br/>
			validationForGrid called:TX<br/>
			validationForGrid called:WA<br/>
			onClick() called<br/>
			<br/>
			3.If you see NullPointerException, it is a bug.<br/>
			]]></html> 
			<window xmlns:a="http://www.zkoss.org/2005/zk/annotation" style="margin: 0 auto" title="bindingValidation Test"> 
			 
			<zscript><![CDATA[ 
			public class User{  
				public String state;  
			 
				public String getState() { 
					return(state); 
				} 
			 
				public void setState(String st) { 
					state = st; 
				} 
			}  
			 
			List list = new LinkedList(); 
			u = new User(); 
			u.state="CA";  
			list.add(u);  
			u = new User(); 
			u.state="TX";  
			list.add(u);  
			u = new User(); 
			u.state="WA";  
			list.add(u);  
			 
			u = new User(); 
			u.state="ENTRY";  
			 
			public void validationForGrid(Event ev) {  
				System.out.println("validationForGrid called:"+ ev.getValue());  
			}  
			 
			public void validationForEntry(Event ev) {  
				System.out.println("validationForEntry called");  
			}  
			 
			]]></zscript>  
			<grid id="griid" width="415px" model="@{list}"> 
				<columns>  
					<column label="State" align="center" width="60px"/>  
				</columns>  
				<rows> 
					<row self="@{each=item}" align="center">
						<textbox value="@{item.state, save-when='submit.onClick'}" onBindingSave="validationForGrid(event)"/>
					</row> 
				</rows> 
			</grid> 
			<textbox value="@{u.state}" onBindingSave="validationForEntry(event)"/>  
			 
			<button id="submit" label="submit"> 
			<attribute name="onBindingValidation"> 
				System.out.println("onBindingValidation(): called"); 
			</attribute> 
			<attribute name="onClick"> 
				System.out.println("onClick() called"); 
			</attribute> 
			</button> 
			 
			</window> 
			</zk>
		"""
    val ztl$engine = engine()
    val griid = ztl$engine.$f("griid")
    val submit = ztl$engine.$f("submit")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      verifyEquals("CA", jq(".z-textbox:eq(0)").`val`())
      verifyEquals("TX", jq(".z-textbox:eq(1)").`val`())
      verifyEquals("WA", jq(".z-textbox:eq(2)").`val`())
      verifyEquals("ENTRY", jq(".z-textbox:eq(3)").`val`())
    })
  }
}



