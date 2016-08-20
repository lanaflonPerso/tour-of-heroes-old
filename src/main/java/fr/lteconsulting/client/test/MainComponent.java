package fr.lteconsulting.client.test;

import java.util.Date;

import fr.lteconsulting.angular2gwt.Component;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(selector = "my-app", template = "<h1>{{title}}</h1><my-child (em)='baby($event)' [name]='childName'></my-child><version-parent></version-parent><countdown-parent-lv></countdown-parent-lv><countdown-parent-vc></countdown-parent-vc><mission-control></mission-control>")
@JsType
public class MainComponent {
	@JsProperty
	private String childName = "init";

	@JsProperty
	private String title = "Main component";

	@JsMethod
	private void baby(String e) {
		title += "-";
		childName = new Date().toString();
	}
}
