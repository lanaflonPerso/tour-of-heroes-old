package fr.lteconsulting.client;

import com.google.gwt.core.client.EntryPoint;

import fr.lteconsulting.angular2gwt.client.interop.angular.Angular;

/**
 * This is the application entry point. It just bootstraps Angular...
 */
public class Application implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		Angular.bootstrap( AppComponent_AngularComponent.getComponentPrototype() );
	}
}