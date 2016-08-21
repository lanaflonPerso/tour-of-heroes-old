package fr.lteconsulting.client.test;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component( selector = "countdown-parent-lv",
		template = "<h3>Countdown to Liftoff (via local variable)</h3>" +
				"<button (click)='timer.start()'>Start</button>" +
				"<button (click)='timer.stop()'>Stop</button>" +
				"<div class='seconds'>{{timer.seconds}}</div>" +
				"<countdown-timer #timer></countdown-timer>" )
@JsType
public class CountdownLocalVarParentComponent
{
}
