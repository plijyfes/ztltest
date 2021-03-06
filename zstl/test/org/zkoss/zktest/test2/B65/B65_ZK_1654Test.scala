package org.zkoss.zktest.test2.B65

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1654.zul")
class B65_ZK_1654Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">
		1. Click on color input and try to enter character 'A' or 'a', should see 'A' or 'a' showed.
		2. Change to colorpicker and try again.
	</label>
	<colorbox width="30px" height="25px" />
</zk>
    """

    runZTL(zscript,
      () => {
        click(jq(".z-colorbox"))
        waitResponse()
        val colorpaletteInp = jq(jq(".z-colorpalette").toWidget().$n("hex-inp"))
        `type`(colorpaletteInp, "A")
        waitResponse()
        verifyEquals("should see 'A' or 'a' showed", colorpaletteInp.`val`(), "A")

        click(jq(".z-colorbox").toWidget().$n("picker-btn"))
        waitResponse()

        val colorpickerInp = jq(jq(".z-colorpicker").toWidget().$n("hex-inp"))
        sendKeys(colorpickerInp, Keys.END + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "A")
        waitResponse()
        verifyEquals("should see 'A' or 'a' showed", colorpickerInp.`val`(), "A")

      })

  }
}
