package fr.lteconsulting.client.test;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(selector = "mission-control", template = "<h2>Mission Control</h2>"
		+ "<button (click)='announce()'>Announce mission</button>"
		+ "<my-astronaut *ngFor='let astronaut of astronauts'" + "[astronaut]='astronaut'>" + "</my-astronaut>"
		+ "<h3>History</h3>" + "<ul>" + "<li *ngFor='let event of history'>{{event}}</li>"
		+ "</ul>", providers = MissionService.class)
@JsType
public class MissionControlComponent {
	@JsProperty
	private JsArray<String> astronauts = JsArray.of("Lovell", "Swigert", "Haise");

	@JsProperty
	private JsArray<String> history = JsArray.empty();

	private MissionService missionService;
	private JsArray<String> missions = JsArray.of("Fly to the moon!", "Fly to mars!", "Fly to Vegas!");
	private int nextMission = 0;

	@JsConstructor
	private MissionControlComponent(MissionService missionService) {
		this.missionService = missionService;
		missionService.missionConfirmed$.subscribe(astronaut -> {
			history.push(astronaut + " confirmed the mission");
		});
	}

	@JsMethod
	private void announce() {
		String mission = missions.get(nextMission);
		missionService.announceMission(mission);
		history.push("Mission \"" + mission + "\" announced");
		nextMission = (nextMission + 1) % missions.length();
	}
}
