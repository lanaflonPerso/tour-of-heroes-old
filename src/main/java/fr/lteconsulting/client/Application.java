package fr.lteconsulting.client;

import com.google.gwt.core.client.EntryPoint;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.angular.Angular;
import fr.lteconsulting.angular2gwt.client.interop.angular.RouterConfig;

/**
 * This is the application entry point. It just bootstraps Angular...
 */
public class Application implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		// Angular.enableProdMode();

		Object router = Angular.provideRouter( JsArray.of(
				RouterConfig.route( "heroes", HeroesComponent_AngularComponent.getComponentPrototype() ) ) );

		Angular.bootstrap( AppComponent_AngularComponent.getComponentPrototype(), JsArray.of( router ) );
	}
}