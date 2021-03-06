
package org.zkoss.zktest.test2.Z65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Z65-Flex-026.zul,Flex")
class Z65_Flex_026Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk><window border="normal" height="360px"
    title="Fit-the-Rest Flexibility: [Hlayout]" width="480px">
    <hlayout vflex="1" width="200px">
        <div hflex="1" style="background:cyan" vflex="1">
            <label value="1"/>
        </div>
        <div hflex="2" style="background:yellow" vflex="1">
            <label value="1"/>
        </div>
    </hlayout>
</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}