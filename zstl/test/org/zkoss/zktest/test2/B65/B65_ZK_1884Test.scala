package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1884.zul")
class B65_ZK_1884Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?page contentType="text/html;charset=UTF-8"?>
<zk xmlns:w="http://www.zkoss.org/2005/zk/client">
	<window border="normal" width="500px" height="200px">
		<vbox>
			click slider's rightmost position, its value should not be greater then 70
			<separator spacing="4px" />
			<hbox>
				<label id="lb" value="40" />/ 70
			</hbox>
			<separator spacing="4px" />
			<slider orient="horizontal" maxpos="70" curpos="40">
				<attribute w:name="onScroll"><![CDATA[
					var pos = this.getCurpos();
					this.$f("lb").setValue(pos);
				]]></attribute>
			</slider>
		</vbox>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        val slider = jq(".z-slider-horizontal").toWidget()
        val btn = slider.$n("btn")
        val rail = slider.$n("inner")
        val fromPos = "2,2"
        val toPos = "220,2"
        dragdropToObject(btn, btn, fromPos, toPos)
        waitResponse()

        val value = parseInt(jq(".z-hbox .z-label:eq(0)").text())
        verifyTrue("its value should not be greater then 70", value <= 70)
      })

  }
}