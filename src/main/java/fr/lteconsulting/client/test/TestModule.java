package fr.lteconsulting.client.test;

import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowser.BrowserModule;
import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import jsinterop.annotations.JsType;

@NgModule(imports = BrowserModule.class, declarations = { MainComponent.class, ChildComponent.class,
		VersionParentComponent.class, VersionChildComponent.class, CountdownTimerComponent.class,
		CountdownLocalVarParentComponent.class, CountdownViewChildParentComponent.class,
		MissionControlComponent.class, AstronautMissionComponent.class }, bootstrap = MainComponent.class)
@JsType
public class TestModule {
}
