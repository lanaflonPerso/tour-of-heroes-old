package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Component;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-app",
		template = "<h1>{{title}}</h1><h2>{{hero}} details!</h2>" )
@JsType
public class AppComponent
{
	@JsProperty
	private String title = "Tour of Heroes";

	@JsProperty
	private String hero = "Windstorm";
}
