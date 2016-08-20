package fr.lteconsulting.client.test;

import java.util.Map.Entry;

import com.google.gwt.core.shared.GWT;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.Input;
import fr.lteconsulting.angular2gwt.Output;
import fr.lteconsulting.angular2gwt.client.interop.Event;
import fr.lteconsulting.angular2gwt.client.interop.angular.EventEmitter;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnChanges;
import fr.lteconsulting.angular2gwt.client.interop.angular.SimpleChange;
import fr.lteconsulting.angular2gwt.client.interop.angular.SimpleChanges;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(selector = "my-child", template = "<h1>{{title}} - I am {{name}}</h1><button (click)='click($event)'>Click</button>")
@JsType
public class ChildComponent implements OnChanges {
	@JsProperty
	private String title = "Child component";

	private String _name;

	@Input
	@JsMethod
	protected void setName(String name) {
		_name = name.trim().toUpperCase();
	}

	protected String getName() {
		return _name;
	}

	@Override
	@JsMethod
	public void ngOnChanges(SimpleChanges o) {
		for (Entry<String, SimpleChange> e : o.changes()) {
			GWT.log(" - " + (e.getValue().isFirstChange()?"<FIRST_CHANGE> ":"") + e.getKey() + ": " + e.getValue().previousValue + " => " + e.getValue().currentValue);
		}
	}

	@Output
	@JsProperty
	private EventEmitter<String> em = new EventEmitter<>();

	@JsMethod
	private void click(Event e) {
		em.emit("hello to subscribers !");
	}
}
