/* B50_3325041Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 17:28:45 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{Element, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3325041
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3325041.zul,A,E,Doublespinner,Doublebox,Decimalbox")
class B50_3325041Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """

			<zk>
				try to type floating number like "1.23" in the double spinner.
				<separator/>
				If floating number can't type in, it's a bug
				<separator/>
				click button next to input, see if the alerted value is the same as valued inputted. 
				<separator/>
				follow above instruction for decimalbox and doublebox too.
				<separator/>
				
				doublespinner : <doublespinner id="ds"/>
				<button id="btn1" label="test1" onClick='alert(ds.value)'/>
				<separator/> 
				decimalbox: <decimalbox id="db"></decimalbox>
				<button id="btn2" label="test2" onClick='alert(db.value)'/>
				<separator/> 
				doublebox: <doublebox id="doub"></doublebox>
				<button id="btn3" label="test3" onClick='alert(doub.value)'/>
			</zk>

    """
    runZTL(zscript,
      () => {
        var ds: Widget = engine.$f("ds")
        var db: Widget = engine.$f("db")
        var doub: Widget = engine.$f("doub")
        var btn1: Widget = engine.$f("btn1")
        var btn2: Widget = engine.$f("btn2")
        var btn3: Widget = engine.$f("btn3")

        inputClickCheck(ds.$n("real"), "1.23", btn1);
        inputClickCheck(db.$n(), "1.23", btn2);
        inputClickCheck(doub.$n(), "1.23", btn3);
        def inputClickCheck(inp: Element, value: String, btn: Widget) {
          click(inp);
          `type`(inp, value);
          blur(inp);

          var vinp: String = inp.attr("value");
          verifyEquals("the value should be inputed correctly",
            vinp, value)
          click(btn);
          waitResponse();

          var vmsg: String = jq(".z-messagebox-window").find(".z-label").get(0).attr("innerHTML");
          verifyEquals("the value in messagebox should equal to inputed value",
            vmsg, value)
          click(jq(".z-messagebox-window").find(".z-button").get(0));
          waitResponse();
        }
      }
    );

  }
}