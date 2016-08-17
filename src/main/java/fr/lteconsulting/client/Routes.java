package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.angular.ProviderWrapper;
import fr.lteconsulting.angular2gwt.client.interop.angular.RouterConfig;
import fr.lteconsulting.angular2gwt.client.interop.angular.RouterModule;

public class Routes implements ProviderWrapper {
	@Override
	public Object get() {
		return RouterModule.forRoot( JsArray.of(
				RouterConfig.route( "heroes", HeroesComponent_AngularComponent.getComponentPrototype() ),
				RouterConfig.route( "dashboard", DashboardComponent_AngularComponent.getComponentPrototype() ),
				RouterConfig.route( "", "/dashboard", "full" ),
				RouterConfig.route( "detail/:id", HeroDetailComponent_AngularComponent.getComponentPrototype() ) ),
				new JsObject().set( "useHash", true ) );
	}
}