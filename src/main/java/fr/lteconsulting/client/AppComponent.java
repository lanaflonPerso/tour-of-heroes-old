package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.client.interop.angular.RouterDirectives;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-app",
		template = "<h1>{{title}}</h1>" +
				"<nav>" +
				"<a [routerLink]=\\\"['/dashboard']\\\" routerLinkActive='active'>Dashboard</a>" +
				"<a [routerLink]=\\\"['/heroes']\\\" routerLinkActive='active'>Heroes</a>" +
				"</nav>" +
				"<router-outlet></router-outlet>",
		styleUrls = "app.component.css",
		directives = RouterDirectives.class,
		providers = HeroService.class )
@JsType
public class AppComponent
{
	@JsProperty
	private String title = "Tour of Heroes";
}
