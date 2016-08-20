package fr.lteconsulting.client.test;

import fr.lteconsulting.angular2gwt.NgModule;
import fr.lteconsulting.angular2gwt.client.interop.angular.BrowserModule;
import jsinterop.annotations.JsType;

@NgModule(imports = BrowserModule.class, declarations = { MainComponent.class,
		ChildComponent.class, VersionParentComponent.class, VersionChildComponent.class, CountdownTimerComponent.class, CountdownLocalVarParentComponent.class }, bootstrap = MainComponent.class)
@JsType
public class TestModule {

}
