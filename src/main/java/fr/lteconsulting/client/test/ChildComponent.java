package fr.lteconsulting.client.test;

import java.util.Map.Entry;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.Event;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.EventEmitter;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnChanges;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.SimpleChange;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.SimpleChanges;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import fr.lteconsulting.angular2gwt.ng.core.Output;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-child",
		template = "<h1>{{title}} - I am {{name}}</h1>" +
				"<button (click)='click($event)'>Click</button>" +
				"<ul><li *ngFor='let item of history'>Changed {{item}}</li></ul>" )
@JsType
public class ChildComponent implements OnChanges
{
	@JsProperty
	private String title = "Child component";

	@JsProperty
	private JsArray<String> history = JsArray.of();

	private String _name;

	@Input
	@JsMethod
	protected void setName( String name )
	{
		_name = name.trim().toUpperCase();
	}

	@Output
	@JsProperty
	private EventEmitter<String> em = new EventEmitter<>();

	protected String getName()
	{
		return _name;
	}

	@Override
	@JsMethod
	public void ngOnChanges( SimpleChanges o )
	{
		for( Entry<String, SimpleChange> e : o.changes() )
		{
			history.push( (e.getValue().isFirstChange() ? "(FIRST_CHANGE) " : "") + e.getKey() + " from '" + e.getValue().previousValue + "' to '" + e.getValue().currentValue + "'" );
		}
	}

	@JsMethod
	private void click( Event e )
	{
		em.emit( "hello to subscribers !" );
	}
}
