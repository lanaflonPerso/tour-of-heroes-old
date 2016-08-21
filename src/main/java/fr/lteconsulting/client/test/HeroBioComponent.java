package fr.lteconsulting.client.test;

import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import fr.lteconsulting.angular2gwt.ng.core.PropertyGetter;
import fr.lteconsulting.client.Hero;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(selector = "hero-bio", template = "<h4>{{hero.name}}</h4>" + "<ng-content></ng-content>"
		+ "<textarea cols='25' [(ngModel)]='hero.description'></textarea>", providers = HeroCacheService.class)
@JsType
public class HeroBioComponent implements OnInit {
	@Input
	@JsProperty
	private int heroId;
	
	@PropertyGetter
	Hero getHero() {
		return heroCache.hero;
	}
	
	private HeroCacheService heroCache;

	public HeroBioComponent(HeroCacheService heroCache) {
		this.heroCache = heroCache;
	}

	@Override
	public void ngOnInit() {
		heroCache.fetchCachedHero(heroId);
	}
}
