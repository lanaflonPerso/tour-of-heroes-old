package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.angular.NgZone;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnInit;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-dashboard",
		templateUrl = "dashboard.component.html" )
@JsType
public class DashboardComponent implements OnInit
{
	private HeroService heroService;

	@JsProperty
	private JsArray<Hero> heroes;

	public DashboardComponent( HeroService heroService, NgZone zone )
	{
		this.heroService = heroService;
	}

	@Override
	public void ngOnInit()
	{
		heroService.getHeroes().then( ( heroes ) -> {
			this.heroes = heroes.slice( 1, 5 );
		}, null );
	}

	@JsMethod
	private void gotoDetail()
	{
	}
}