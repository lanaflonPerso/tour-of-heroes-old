package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.Input;
import fr.lteconsulting.angular2gwt.Output;
import fr.lteconsulting.angular2gwt.client.JsTools;
import fr.lteconsulting.angular2gwt.client.interop.angular.ActivatedRoute;
import fr.lteconsulting.angular2gwt.client.interop.angular.EventEmitter;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnDestroy;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Subscription;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-hero-detail",
		templateUrl = "hero-detail.component.html",
		styleUrls = "hero-detail.component.css" )
@JsType
public class HeroDetailComponent implements OnInit, OnDestroy
{
	@Input
	@JsProperty
	private Hero hero;

	@Output
	@JsProperty
	private EventEmitter<Hero> close = new EventEmitter<>();

	private Object error;
	private Object sub;
	private boolean navigated;

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
			if( params.get( "id" ) != null )
			{
				int id = Integer.parseInt( params.get( "id" ) );

				navigated = true;

				heroService.getHero( id ).then( ( hero ) -> this.hero = hero, null );
			}
			else
			{
				navigated = false;

				hero = new Hero();
			}
		} );
	}

	@Override
	public void ngOnDestroy()
	{
		routeParamsSubscription.unsubscribe();
	}

	@JsMethod
	private void goBack( Hero savedHero )
	{
		close.emit( savedHero );

		if( navigated )
			JsTools.historyGoBack();
	}

	@JsMethod
	private void save()
	{
		heroService
				.save( hero )
				.then( ( hero ) -> {
					this.hero = hero; // saved hero, w/ id if new
					goBack( hero );
				}, ( error ) -> this.error = error ); // TODO: Display error message
	}
}