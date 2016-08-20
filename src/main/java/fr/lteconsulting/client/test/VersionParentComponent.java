package fr.lteconsulting.client.test;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "version-parent",
		template = "<h2>Source code version</h2>"
			+ "<button (click)='newMinor()'>New minor version</button>"
			+ "<button (click)='newMajor()'>New major version</button>"
			+ "<version-child [major]='major' [minor]='minor'></version-child>"
		)
@JsType
public class VersionParentComponent {
	@JsProperty
	int major = 1;

	@JsProperty
	int minor = 23;

	@JsMethod
	private void newMinor() {
		minor++;
	}

	@JsMethod
	private void newMajor() {
		major++;
		minor = 0;
	}
}
