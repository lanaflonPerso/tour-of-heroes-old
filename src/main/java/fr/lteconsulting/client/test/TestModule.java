package fr.lteconsulting.client.test;

import fr.lteconsulting.angular2gwt.client.interop.ng.forms.FormsModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowser.BrowserModule;
import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import fr.lteconsulting.client.LoggerService;
import jsinterop.annotations.JsType;

@NgModule(
		imports = {
				BrowserModule.class,
				FormsModule.class
		},
		declarations = {
				MainComponent.class,
				ChildComponent.class,
				VersionParentComponent.class,
				VersionChildComponent.class,
				CountdownTimerComponent.class,
				CountdownLocalVarParentComponent.class,
				CountdownViewChildParentComponent.class,
				MissionControlComponent.class,
				AstronautMissionComponent.class,
				TestComponent.class,
				HeroBiosAndContactsComponent.class,
				HeroBioComponent.class,
				HeroContactComponent.class },
		providers = LoggerService.class,
		entryComponents = TestComponent.class,
		bootstrap = MainComponent.class )
@JsType
public class TestModule
{
}
