package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.NgModule;
import fr.lteconsulting.angular2gwt.client.interop.angular.BrowserModule;
import fr.lteconsulting.angular2gwt.client.interop.angular.FormsModule;
import jsinterop.annotations.JsType;

@NgModule(
		imports = { BrowserModule.class, FormsModule.class, Routes.class },
		declarations = { AppComponent.class, DashboardComponent.class, HeroesComponent.class, HeroDetailComponent.class },
		providers = HeroService.class,
		entryComponents = { DashboardComponent.class, HeroesComponent.class, HeroDetailComponent.class },
		bootstrap = AppComponent.class )
@JsType
public class AppModule {
}