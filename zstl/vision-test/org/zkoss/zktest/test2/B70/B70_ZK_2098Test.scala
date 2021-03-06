package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2098.zul")
class B70_ZK_2098Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>

<div style="height:200px" apply="org.zkoss.bind.BindComposer" 
    viewModel="@id('vm') @init('org.zkoss.zktest.test2.B70_ZK_2098_ViewModel')">
    <div>
    	Click second button then should not see error message, the cell should align correct.
    </div>
  <tree model="@load(vm.treeModel)" id="tree" width="30%" vflex="1" rows="8">
<!--     <custom-attributes org.zkoss.zul.nativebar="true"/> -->
    <treecols sizable="false" children="@load(vm.cols) @template(each.template)" >
      <template name="col60">
        <treecol label="@load(each.label)" width="60px" visible="@load(each.visible)"/>
      </template>
      <template name="col80">
        <treecol label="@load(each.label)" width="80px" visible="@load(each.visible)"/>
      </template>
      <template name="col100">
        <treecol label="@load(each.label)" width="100px" visible="@load(each.visible)"/>
      </template>
      <template name="default">
        <treecol label="@load(each.label)" visible="@load(each.visible)"/>
      </template>
      <template name="flex">
        <treecol label="@load(each.label)" hflex="2" visible="@load(each.visible)"/>
      </template>
    </treecols>  
    
    <template name="model" var="row">
      <treeitem>
        <treerow children="@load(vm.items) ">
          <template name="children" >
            <treecell>
              <label value="@load(each)"/>
            </treecell>
          </template>
        </treerow>
      </treeitem>
    </template>
  </tree>
  
  <button label="change column templates" onClick="@command('changeColumnTemplates')"/>          
  <button label="change column templates with flex" onClick="@command('changeColumnTemplatesWithFlex')"/>          
</div>

</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button:eq(1)"))
      waitResponse()
      verifyImage()
    })
    
  }
}