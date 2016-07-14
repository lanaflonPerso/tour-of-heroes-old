package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsTools;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnInit;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-app",
		template = "<h1>{{title}}</h1>" +
				"<h2>My Heroes</h2>" +
				"<ul class='heroes'>" +
				"<li *ngFor='let hero of heroes' (click)='onSelect(hero)' [class.selected]='hero === selectedHero'>" +
				"<span class='badge'>{{hero.id}}</span> {{hero.name}}" +
				"</li>" +
				"</ul>" +
				"<my-hero-detail [hero]='selectedHero'></my-hero-detail>",
		styles = ".selected {" +
				"background-color: #CFD8DC !important;" +
				"color: white;" +
				"}" +
				".heroes {" +
				"margin: 0 0 2em 0;" +
				"list-style-type: none;" +
				"padding: 0;" +
				"width: 15em;" +
				"}" +
				".heroes li {" +
				"cursor: pointer;" +
				"position: relative;" +
				"left: 0;" +
				"background-color: #EEE;" +
				"margin: .5em;" +
				"padding: .3em 0;" +
				"height: 1.6em;" +
				"border-radius: 4px;" +
				"}" +
				".heroes li.selected:hover {" +
				"background-color: #BBD8DC !important;" +
				"color: white;" +
				"}" +
				".heroes li:hover {" +
				"color: #607D8B;" +
				"background-color: #DDD;" +
				"left: .1em;" +
				"}" +
				".heroes .text {" +
				"position: relative;" +
				"top: -3px;" +
				"}" +
				".heroes .badge {" +
				"display: inline-block;" +
				"font-size: small;" +
				"color: white;" +
				"padding: 0.8em 0.7em 0 0.7em;" +
				"background-color: #607D8B;" +
				"line-height: 1em;" +
				"position: relative;" +
				"left: -1px;" +
				"top: -4px;" +
				"height: 1.8em;" +
				"margin-right: .8em;" +
				"border-radius: 4px 0 0 4px;" +
				"}",
		directives = HeroDetailComponent.class,
		providers = HeroService.class )
@JsType
public class AppComponent implements OnInit
{
	@JsProperty
	private String title = "Tour of Heroes";

	@JsProperty
	private Hero selectedHero;

	@JsProperty
	private JsArray<Hero> heroes;

	private HeroService heroService;

	public AppComponent( HeroService heroService )
	{
		this.heroService = heroService;
	}

	@Override
	public void ngOnInit()
	{
		getHeroes();
	}

	@JsMethod
	private void onSelect( Hero hero )
	{
		this.selectedHero = hero;
	}

	private void getHeroes()
	{
		this.heroService.getHeroes().then( ( heroes ) -> {
			JsTools.setTimeout( () -> this.heroes = heroes, 2000 );
		}, null );
	}
}
