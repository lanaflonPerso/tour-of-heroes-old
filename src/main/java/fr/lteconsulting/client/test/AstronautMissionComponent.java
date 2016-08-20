package fr.lteconsulting.client.test;

import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Subscription;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnDestroy;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(selector = "my-astronaut", template = "<p>" + "{{astronaut}}: <strong>{{mission}}</strong>" + "<button "
		+ "(click)='confirm()'" + " [disabled]='!announced || confirmed'>" + "Confirm" + "</button>" + "</p>")
@JsType
public class AstronautMissionComponent implements OnDestroy {
	@Input
	@JsProperty
	private String astronaut;

	@JsProperty
	private String mission = "<no mission announced>";
	
	@JsProperty
	private boolean confirmed = false;
	
	@JsProperty
	private boolean announced = false;

	private Subscription subscription;

	private MissionService missionService;

	public AstronautMissionComponent(MissionService missionService) {
		this.missionService = missionService;

		subscription = missionService.missionAnnounced$.subscribe(mission -> {
			this.mission = mission;
			announced = true;
			confirmed = false;
		});
	}

	@JsMethod
	private void confirm() {
		confirmed = true;
		missionService.confirmMission(astronaut);
	}

	@Override
	public void ngOnDestroy() {
		// prevent memory leak when component destroyed
		subscription.unsubscribe();
	}
}
