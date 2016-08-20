package fr.lteconsulting.client.test;

import java.util.Map.Entry;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.Input;
import fr.lteconsulting.angular2gwt.client.JSON;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnChanges;
import fr.lteconsulting.angular2gwt.client.interop.angular.SimpleChange;
import fr.lteconsulting.angular2gwt.client.interop.angular.SimpleChanges;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(selector ="version-child",
		template = "<h3>Version {{major}}.{{minor}}</h3>"+
				"<h4>Change log:</h4>"+
				"<ul>"+
					"<li *ngFor='let change of changeLog'>{{change}}</li>"+
				"</ul>"
		)
@JsType
public class VersionChildComponent implements OnChanges {
	
	@Input
	@JsProperty
	private int major;
	
	@Input
	@JsProperty
	private int minor;
	
	@JsProperty
	private JsArray<String> changeLog = JsArray.empty();

	@Override
	public void ngOnChanges(SimpleChanges changes) {
		JsArray<String> log = JsArray.empty();
		
		for (Entry<String, SimpleChange> entry : changes.changes()) {
			SimpleChange change = entry.getValue();
			
			String from = JSON.stringify(change.previousValue);
			String to = JSON.stringify(change.currentValue);
			
			log.push(entry.getKey() + " changed from " + from + " to " + to);
		}
		
		changeLog.push(log.join(", "));
	}
}
