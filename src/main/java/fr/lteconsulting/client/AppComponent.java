package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Component;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-app",
		template = "<h1>{{title}}</h1><h2>{{hero.name}} details!</h2><div><label>id: </label>{{hero.id}}</div><div><label>name: </label>{{hero.name}}</div>" )
@JsType
public class AppComponent
{
	@JsProperty
	private String title = "Tour of Heroes";

	@JsProperty
	private Hero hero = new Hero( 1, "Windstorm" );
}
