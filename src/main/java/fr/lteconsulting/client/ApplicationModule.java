package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.client.interop.ng.forms.FormsModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.HttpModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowser.BrowserModule;
import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import fr.lteconsulting.client.material.EmailApplicationModule;
import fr.lteconsulting.client.test.TestModule;
import jsinterop.annotations.JsType;

@NgModule(
		imports = {
				BrowserModule.class,
				FormsModule.class,
				HttpModule.class,
				Routes.class,
				TestModule.class,
				EmailApplicationModule.class
		},
		declarations = {
				ApplicationComponent.class,
				DashboardComponent.class,
				HeroesComponent.class,
				HeroDetailComponent.class,
				HeroSearchComponent.class
		},
		providers = {
				HeroService.class,
				HeroSearchService.class
		},
		entryComponents = {
				DashboardComponent.class,
				HeroesComponent.class,
				HeroDetailComponent.class,
				HeroSearchComponent.class
		},
		bootstrap = ApplicationComponent.class )
@JsType
public class ApplicationModule
{
}
