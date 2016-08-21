package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-app",
		template = "<h1>{{title}}</h1>" +
				"<nav>" +
				"<a [routerLink]=\\\"['/dashboard']\\\" routerLinkActive='active'>Dashboard</a>" +
				"<a [routerLink]=\\\"['/heroes']\\\" routerLinkActive='active'>Heroes</a>" +
				"<a [routerLink]=\\\"['/email']\\\" routerLinkActive='active'>Material</a>" +
				"<a [routerLink]=\\\"['/test']\\\" routerLinkActive='active'>Tests</a>" +
				"</nav>" +
				"<router-outlet></router-outlet>",
		styleUrls = "application.component.css" )
@JsType
public class ApplicationComponent
{
	@JsProperty
	private String title = "Tour of Heroes";
}
