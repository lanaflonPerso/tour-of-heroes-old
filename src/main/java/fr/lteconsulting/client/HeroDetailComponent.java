package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.Input;
import fr.lteconsulting.angular2gwt.client.JsTools;
import fr.lteconsulting.angular2gwt.client.interop.angular.ActivatedRoute;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnDestroy;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Subscription;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-hero-detail",
		templateUrl = "hero-detail.component.html" )
@JsType
public class HeroDetailComponent implements OnInit, OnDestroy
{
	@Input
	@JsProperty
	private Hero hero;

	private HeroService heroService;
	private ActivatedRoute route;

	private Subscription routeParamsSubscription;

	public HeroDetailComponent( HeroService heroService, ActivatedRoute route )
	{
		this.heroService = heroService;
		this.route = route;
	}

	@Override
	public void ngOnInit()
	{
		routeParamsSubscription = route.params.subscribe( ( params ) -> {
			int id = Integer.parseInt( params.get( "id" ) );

			heroService.getHero( id ).then( ( hero ) -> this.hero = hero, null );
		} );
	}

	@Override
	public void ngOnDestroy()
	{
		routeParamsSubscription.unsubscribe();
	}

	@JsMethod
	private void goBack()
	{
		JsTools.historyGoBack();
	}
}