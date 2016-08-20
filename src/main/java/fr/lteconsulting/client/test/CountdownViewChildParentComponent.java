package fr.lteconsulting.client.test;

import com.google.gwt.core.shared.GWT;

import fr.lteconsulting.angular2gwt.client.JsTools;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.AfterViewInit;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.ViewChild;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(selector = "countdown-parent-vc", template = "<h3>Countdown to Liftoff (via ViewChild)</h3>"
		+ "<button (click)='start()'>Start</button>" + "<button (click)='stop()'>Stop</button>"
		+ "<div class='seconds'>{{ seconds() }}</div>" + "<countdown-timer></countdown-timer>")
@JsType
public class CountdownViewChildParentComponent implements AfterViewInit {
	@ViewChild(component = CountdownTimerComponent.class)
	@JsProperty
	private CountdownTimerComponent timerComponent = null;

	@JsMethod
	private int seconds() {
		if (!initialized || timerComponent == null)
			return 0;
		else
			return timerComponent.seconds;
	}

	private boolean initialized = false;

	@Override
	public void ngAfterViewInit() {
		GWT.log("INITITALIZED " + timerComponent);
		JsTools.setTimeout(() -> initialized = true, 0);
	}

	@JsMethod
	private void start() {
		timerComponent.start();
	}

	@JsMethod
	private void stop() {
		timerComponent.stop();
	}
}
