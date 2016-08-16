package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsToolsInjector;
import fr.lteconsulting.angular2gwt.client.interop.angular.AngularComponentConstructorFunction;
import fr.lteconsulting.angular2gwt.client.interop.angular.NgModule;
import fr.lteconsulting.angular2gwt.client.interop.angular.NgModuleMetadata;
import jsinterop.annotations.JsProperty;

/**
 * Code à générer
 */
public class ApplicationModule_AngularModule {
	@JsProperty( namespace = "fr.lteconsulting.client", name = "AppModule" )
    private native static AngularComponentConstructorFunction constructorFunction();
	
	@JsProperty( namespace = "ng.platformBrowser", name = "BrowserModule" )
    private native static Object ng_platformBrowser_BrowserModule();
	
	@JsProperty( namespace = "ng.forms", name = "FormsModule" )
    private native static Object ng_forms_FormsModule();
	
	static Object getComponentPrototype() {
		JsToolsInjector.inject();

        AngularComponentConstructorFunction constructorFunction = constructorFunction();
        
        if( constructorFunction.annotations == null )
        {
            NgModuleMetadata metadata = new NgModuleMetadata();
            
            metadata.imports = JsArray.of(
            		ng_platformBrowser_BrowserModule(),
            		ng_forms_FormsModule(),
            		new Routes().get() );
            
            metadata.declarations = JsArray.of( AppComponent_AngularComponent.getComponentPrototype(),
            		HeroesComponent_AngularComponent.getComponentPrototype(),
            		HeroDetailComponent_AngularComponent.getComponentPrototype(),
            		DashboardComponent_AngularComponent.getComponentPrototype() );
            
            metadata._providers = JsArray.of( fr.lteconsulting.client.HeroService_AngularInjectable.getComponentPrototype() );
            
            metadata.bootstrap = JsArray.of( AppComponent_AngularComponent.getComponentPrototype() );

            constructorFunction.annotations = JsArray.of( new NgModule( metadata ) );
        }

        return constructorFunction;
	}
}