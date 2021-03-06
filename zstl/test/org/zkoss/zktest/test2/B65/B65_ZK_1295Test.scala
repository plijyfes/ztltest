package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1295.zul")
class B65_ZK_1295Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<html>
		Testing Instructions:
		<ul>
			<li>Click on button 'b2'</li>
		</ul>
		
		Expected Results:
		<ul>
			<li>Button 'b1' should now be focused.</li>
		</ul>
	</html>
	<button id='b1' label="b1" disabled="true" />
	<button id='b2' label="b2" onClick='b1.setDisabled(false); b1.focus();' />
</zk>""";

    runZTL(zscript,
      () => {
        click(jq("$b2"))
        waitResponse()
        verifyNotEquals("Button 'b1' should now be focused.", "", jq(".z-button:eq(0)").css("box-shadow"))
      })

  }
}
