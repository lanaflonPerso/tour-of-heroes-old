package fr.lteconsulting.client.test;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.client.HeroService;
import fr.lteconsulting.client.LoggerService;
import jsinterop.annotations.JsType;

@Component( selector = "hero-bios-and-contacts", template = "<hero-bio [heroId]='1'> <hero-contact></hero-contact> </hero-bio>"
		+ "<hero-bio [heroId]='2'> <hero-contact></hero-contact> </hero-bio>"
		+ "<hero-bio [heroId]='3'> <hero-contact></hero-contact> </hero-bio>", providers = HeroService.class)
@JsType
public class HeroBiosAndContactsComponent {
	public HeroBiosAndContactsComponent(LoggerService loggerService) {
		loggerService.log("Creating HeroBiosAndContactsComponent");
	}
}
