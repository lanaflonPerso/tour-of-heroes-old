package fr.lteconsulting.client;

import com.google.gwt.core.client.GWT;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.angular.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.angular.Router;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Observable;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Subject;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(selector = "hero-search", templateUrl = "hero-search.component.html", styleUrls = "hero-search.component.css")
@JsType
public class HeroSearchComponent implements OnInit {
	@JsProperty
	Observable<JsArray<Hero>> heroes;

	private Subject<String> searchTerms = new Subject<String>();

	private HeroSearchService heroSearchService;

	private Router router;

	@JsConstructor
	HeroSearchComponent(HeroSearchService heroSearchService, Router router) {
		this.heroSearchService = heroSearchService;
		this.router = router;
	}

	@JsMethod
	void search(String term) {
		searchTerms.next(term);
	}

	@Override
	public void ngOnInit() {
		heroes = searchTerms.debounceTime(300)
				.distinctUntilChanged()
				.switchMap((term, index) -> {
					GWT.log("search term: " + term + " index:" + index);
					return (term != null && !term.isEmpty()) ? heroSearchService.search(term)
							: Observable.of(JsArray.<Hero>empty());
				}).onError(error -> {
					// TODO: real error handling
					GWT.log("Error:" + error);
					return Observable.of(JsArray.empty());
				});
	}

	@JsMethod
	void gotoDetail(Hero hero) {
		router.navigate(JsArray.of("/detail", String.valueOf(hero.id)));
	}
}
