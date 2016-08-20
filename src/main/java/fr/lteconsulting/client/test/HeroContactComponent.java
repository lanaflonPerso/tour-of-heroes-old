package fr.lteconsulting.client.test;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Host;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import fr.lteconsulting.angular2gwt.ng.core.Optional;
import fr.lteconsulting.client.LoggerService;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(selector = "hero-contact", template = "<div>Phone #: {{phoneNumber}}"
		+ "<span *ngIf='hasLogger'>!!!</span></div>")
@JsType
public class HeroContactComponent {
	@JsProperty
	private boolean hasLogger = false;

	private HeroCacheService heroCache;

	// limit to the host component's instance of the HeroCacheService
	// limit search for logger; hides the application-wide logger and ok if the
	// logger doesn't exist
	@JsConstructor
	HeroContactComponent(@Host HeroCacheService heroCache, @Host @Optional LoggerService loggerService) {
		this.heroCache = heroCache;

		if (loggerService != null) {
			hasLogger = true;
			loggerService.log("HeroContactComponent can log!");
		}
	}

	/**
	 * This input is used just so that Angular2Gwt allows us to create a virtual
	 * property getter
	 */
	@Input
	void setPhoneNumber(String value) {
		throw new IllegalStateException("Cannot set a value here !");
	}

	/**
	 * This getter is used by Angular2Gwt to implement the 'hero' property
	 * 
	 * @return
	 */
	String getPhoneNumber() {
		return heroCache.hero.phoneNumber;
	}
}
