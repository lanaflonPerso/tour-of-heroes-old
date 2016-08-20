package fr.lteconsulting.client.test;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.client.JsTools;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnDestroy;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnInit;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(selector = "countdown-timer", template = "<p>{{message}}</p>")
@JsType
public class CountdownTimerComponent implements OnInit, OnDestroy {

	@JsProperty
	private String message = "";

	private int intervalId = 0;
	public int seconds = 11;

	private void clearTimer() {
		if (intervalId != 0)
			JsTools.clearInterval(intervalId);
		intervalId = 0;
	}

	@Override
	public void ngOnDestroy() {
		clearTimer();
	}

	@Override
	public void ngOnInit() {
		start();
	}

	public void start() {
		countDown();
	}

	public void stop() {
		clearTimer();
		message = "Holding at T-" + seconds + " seconds";
	}

	private void countDown() {
		clearTimer();
		intervalId = JsTools.setInterval(() -> {
			seconds -= 1;
			if (seconds == 0) {
				message = "Blast off!";
			} else {
				if (seconds < 0)
					seconds = 10;

				// reset
				message = "T-" + seconds + " seconds and counting";
			}
		}, 1000);
	}
}
