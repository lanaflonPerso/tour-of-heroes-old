package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.NgModule;
import fr.lteconsulting.angular2gwt.client.interop.angular.BrowserModule;
import jsinterop.annotations.JsType;

@NgModule(
		imports = { BrowserModule.class, Routes.class },
		declarations = AppComponent.class,
		providers = HeroService.class,
		bootstrap = AppComponent.class )
@JsType
public class AppModule {
}