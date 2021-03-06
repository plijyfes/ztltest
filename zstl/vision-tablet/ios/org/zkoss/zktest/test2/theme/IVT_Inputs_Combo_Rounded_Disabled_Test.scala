package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Combo_Rounded_Disabled_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox style="margin: 10px 0;">
	Combobox:
	<combobox mold="rounded" disabled="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<combobox mold="rounded" buttonVisible="false" disabled="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	Datebox:
	<datebox mold="rounded" disabled="true"/>
	<datebox mold="rounded" buttonVisible="false" disabled="true"/>
	Bandbox:
	<bandbox mold="rounded" disabled="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<bandbox mold="rounded" buttonVisible="false" disabled="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	Timebox:
	<timebox mold="rounded" disabled="true"/>
	<timebox mold="rounded" buttonVisible="false" disabled="true"/>
	Spinner:
	<spinner mold="rounded" disabled="true"/>
	<spinner mold="rounded" buttonVisible="false" disabled="true"/>
	Doublespinner:
	<doublespinner mold="rounded" disabled="true"/>
	<doublespinner mold="rounded" buttonVisible="false" disabled="true"/>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
