package fr.lteconsulting.client;

import com.google.gwt.core.client.EntryPoint;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.angular.Angular;

/**
 * This is the application entry point. It just bootstraps Angular...
 */
public class Application implements EntryPoint
{
	public static JsArray<Hero> HEROES = JsArray.of(
			new Hero( 11, "Mr. Nice" ),
			new Hero( 12, "Narco" ),
			new Hero( 13, "Bombasto" ),
			new Hero( 14, "Celeritas" ),
			new Hero( 15, "Magneta" ),
			new Hero( 16, "RubberMan" ),
			new Hero( 17, "Dynama" ),
			new Hero( 18, "Dr IQ" ),
			new Hero( 19, "Magma" ),
			new Hero( 20, "Tornado" ) );

	@Override
	public void onModuleLoad()
	{
		Angular.bootstrap( AppComponent_AngularComponent.getComponentPrototype() );
	}
}