package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Component;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-app",
		template = "<h1>{{title}}</h1>" +
				"<my-heroes></my-heroes>",
		directives = HeroesComponent.class,
		providers = HeroService.class )
@JsType
public class AppComponent
{
	@JsProperty
	private String title = "Tour of Heroes";
}
