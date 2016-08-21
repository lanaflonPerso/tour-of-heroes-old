package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.Event;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.Router;
import fr.lteconsulting.angular2gwt.ng.core.Component;
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

	@JsProperty
	private Object error;

	@JsProperty
	private boolean addingHero;

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
		selectedHero = hero;
	}

	@JsMethod
	private void gotoDetail()
	{
		router.navigate( JsArray.of( "/detail", String.valueOf( selectedHero.id ) ) );
	}

	@JsMethod
	private void addHero()
	{
		addingHero = true;
		selectedHero = null;
	}

	@JsMethod
	private void close( Hero savedHero )
	{
		addingHero = false;

		if( savedHero != null )
			getHeroes();
	}

	@JsMethod
	private void deleteHero( Hero hero, Event event )
	{
		event.stopPropagation();

		heroService.delete( hero ).then( ( res ) -> {
			heroes = heroes.filter( h -> h != hero );
			if( selectedHero == hero )
				selectedHero = null;
			return null;
		}, error -> this.error = error );
	}

	private void getHeroes()
	{
		heroService.getHeroes().then( heroes -> this.heroes = heroes, null );
	}
}
