package fr.lteconsulting.client.test;

import java.util.Date;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(selector = "main", template = "<h1>{{title}}</h1><my-child (em)='baby($event)' [name]='childName'></my-child><input [(ngModel)]='childName' type='text'/><ul><li *ngFor='let item of history'>Changed {{item}}</li></ul>")
@JsType
public class MainComponent {
	@JsProperty
	private String childName = "init";

	@JsProperty
	private String title = "Main component";
	
	@JsProperty
	private JsArray<String> history = JsArray.of();

	@JsMethod
	private void baby(String item) {
		history.push("received an event from the child : " + item);
		childName = new Date().toString();
	}
}
