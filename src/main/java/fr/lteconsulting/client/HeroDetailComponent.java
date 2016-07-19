package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.Input;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-hero-detail",
		template = "<div *ngIf='hero'>" +
				"<h2>{{hero.name}} details!</h2>" +
				"<div><label>id: </label>{{hero.id}}</div>" +
				"<div>" +
				"<label>name: </label>" +
				//"<input [(ngModel)]='hero.name' placeholder='name'>" +
				"<input [value]='hero.name' (input)='hero.name=$event.target.value' placeholder='name'>" +
				"</div>" +
				"</div>" )
@JsType
public class HeroDetailComponent
{
	@Input
	@JsProperty
	private Hero hero;
}
