package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.Router;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-dashboard",
		templateUrl = "dashboard.component.html",
		styleUrls = "dashboard.component.css")
@JsType
public class DashboardComponent implements OnInit
{
	private HeroService heroService;
	private Router router;

	@JsProperty
	private JsArray<Hero> heroes;

	public DashboardComponent( HeroService heroService, Router router )
	{
		this.heroService = heroService;
		this.router = router;
	}

	@Override
	public void ngOnInit()
	{
		heroService.getHeroes().then( heroes ->this.heroes = heroes.slice( 1, 5 ) );
	}

	@JsMethod
	private void gotoDetail( Hero hero )
	{
		String id = String.valueOf( hero.id );
		router.navigate( JsArray.of( "/detail", id ) );
	}
}