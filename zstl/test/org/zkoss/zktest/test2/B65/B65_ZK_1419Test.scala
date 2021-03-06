
package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1419.zul")
class B65_ZK_1419Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">
	1. Change browser language to English.
	2. Type anything in the textbox to show errorbox.
	3. Mouseover on the errorbox to show the tooltip text and should be "Click to re-enter data".
	</label>
	<textbox id="emailTextbox" width="175px" constraint="/[a-zA-Z0-9_\-.+]+@[a-zA-Z0-9_\-.+]+/: invalid e-mail" maxlength="255" />
</zk>
    """
    runZTL(zscript,
      () => {
        sendKeys(jq("@textbox"), "123123123")
        blur(jq("@textbox"))

        mouseOver(jq(".z-errorbox"))
        waitResponse()
        verifyEquals("the tooltip text should be 'Click to re-enter data'.", jq(".z-errorbox-content").attr("title"), "Click to re-enter data")
      })

  }
}