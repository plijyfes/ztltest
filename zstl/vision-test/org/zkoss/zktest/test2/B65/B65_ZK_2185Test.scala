package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2185.zul")
class B65_ZK_2185Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<zscript>
<![CDATA[
        String[] userName = { "Apple", "Banana", "Cake"};
        ListModelList model = new ListModelList(userName);
    
]]></zscript>
	<div>click inner select, the select should open</div>
	<listbox>
		<listhead>
			<listheader label="Type" width="20%" />
			<listheader label="Value" width="80%" />
		</listhead>
		<listitem draggable="true" droppable="true">
			<listcell>Color</listcell>
			<listcell>
				<listbox mold="select">
					<listitem label="Red" selected="true" />
					<listitem label="Green" />
				</listbox>
				<selectbox model="${model}"></selectbox>
			</listcell>
		</listitem>
	</listbox>
	<tree>
		<treecols>
			<treecol label="Type" width="20%" />
			<treecol label="Value" width="80%" />
		</treecols>
		<treechildren>
			<treeitem draggable="true" droppable="true">
				<treerow>
					<treecell>Color</treecell>
					<treecell>
						<listbox mold="select">
							<listitem label="Red" selected="true" />
							<listitem label="Green" />
						</listbox>
						<selectbox model="${model}"></selectbox>
					</treecell>
				</treerow>
			</treeitem>
		</treechildren>
	</tree>
	<grid>
		<columns>
			<column label="Type" width="20%" />
			<column label="Value" width="80%" />
		</columns>
		<rows>
			<row draggable="true" droppable="true">
				<label value="Color" />
				<div>
					<listbox mold="select">
						<listitem label="Red" selected="true" />
						<listitem label="Green" />
					</listbox>
					<selectbox model="${model}"></selectbox>
				</div>
			</row>
		</rows>
	</grid>
</zk>"""
    runZTL(zscript,
      () => {
        0 to 5 foreach { index =>
          click(jq("select").eq(index))
          waitResponse()
          verifyImage()
        }
      })

  }
}