package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.client.JsArray;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-app",
		template = "<h1>{{title}}</h1>" +
				"<h2>My Heroes</h2>" +
				"<ul class='heroes'>" +
				"<li *ngFor='let hero of heroes'>" +
				"<span class='badge'>{{hero.id}}</span> {{hero.name}}" +
				"</li>" +
				"</ul>" +
				"<h2>{{hero.name}} details!</h2>" +
				"<div><label>id: </label>{{hero.id}}</div>" +
				"<div>" +
				"<label>name: </label>" +
				"<input [(ngModel)]='hero.name' placeholder='name'>" +
				"</div>" )
@JsType
public class AppComponent
{
	@JsProperty
	private String title = "Tour of Heroes";

	@JsProperty
	private Hero hero = new Hero( 1, "Windstorm" );
	
	@JsProperty
	private JsArray<Hero> heroes = Application.HEROES;
}
