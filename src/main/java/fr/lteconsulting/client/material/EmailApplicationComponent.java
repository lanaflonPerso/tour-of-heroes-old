package fr.lteconsulting.client.material;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.JsTools;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnDestroy;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		templateUrl = "material2-app.component.html",
		styleUrls = "material2-app.component.css" )
@JsType
public class EmailApplicationComponent implements OnInit, OnDestroy
{
	@JsProperty
	private JsArray<JsObject> foods = JsArray.of(
			new JsObject().set( "name", "Pizza" ).set( "rating", "Excellent" ),
			new JsObject().set( "name", "Burritos" ).set( "rating", "Great" ),
			new JsObject().set( "name", "French fries" ).set( "rating", "Pretty good" ) );

	@JsProperty
	private int progress = 0;

	private int timerId = 0;

	@Override
	public void ngOnInit()
	{
		// Update the value for the progress-bar on an interval.
		timerId = JsTools.setInterval( () -> progress = (int) (progress + Math.floor( Math.random() * 4 ) + 1) % 100, 200 );
	}

	@Override
	public void ngOnDestroy()
	{
		if( timerId != 0 )
			JsTools.clearInterval( timerId );
	}
}
