package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.angular.Router;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-heroes",
		templateUrl = "heroes.component.html",
		styleUrls = "heroes.component.css" )
@JsType
public class HeroesComponent implements OnInit
{
	@JsProperty
	private String title = "Tour of Heroes";

	@JsProperty
	private Hero selectedHero;

	@JsProperty
	private JsArray<Hero> heroes;

	private HeroService heroService;

	private Router router;

	public HeroesComponent( HeroService heroService, Router router )
	{
		this.heroService = heroService;
		this.router = router;

		getHeroes();
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

	@JsMethod
	private void gotoDetail()
	{
		router.navigate( JsArray.of( "/detail", String.valueOf( selectedHero.id ) ) );
	}

	private void getHeroes()
	{
		this.heroService.getHeroes().then( ( heroes ) -> {
			this.heroes = heroes;
		}, null );
	}
}
