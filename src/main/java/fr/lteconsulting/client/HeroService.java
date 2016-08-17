package fr.lteconsulting.client;

import com.google.gwt.core.shared.GWT;

import fr.lteconsulting.angular2gwt.Injectable;
import fr.lteconsulting.angular2gwt.client.JSON;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.angular.Headers;
import fr.lteconsulting.angular2gwt.client.interop.angular.Http;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class HeroService {
	private static final String heroesUrl = "app/heroes";

	private Http http;

	public HeroService(Http http) {
		this.http = http;
	}

	public Promise<JsArray<Hero>> getHeroes() {
		return http.get(heroesUrl).toPromise().<JsArray<Hero>>then(response -> response.json())
				.onCatch(this::handleError);
	}

	public Promise<Hero> getHero(int id) {
		return http.get(heroesUrl + "/" + id).toPromise().<Hero>then(response -> response.json())
				.onCatch(this::handleError);
	}

	public Promise<Hero> save(Hero hero) {
		if (hero.id > 0)
			return put(hero);

		return post(hero);
	}

	public Promise<Hero> post(Hero hero) {
		Headers headers = new Headers();
		headers.append("Content-Type", "application/json");

		return http.post(heroesUrl, JSON.stringify(hero), new JsObject().set("headers", headers)).toPromise()
				.<Hero>then(response -> response.json()).onCatch(this::handleError);
	}

	public Promise<Hero> put(Hero hero) {
		String url = heroesUrl + "/" + hero.id;

		Headers headers = new Headers();
		headers.append("Content-Type", "application/json");

		return http.put(url, JSON.stringify(hero), new JsObject().set("headers", headers)).toPromise()
				.<Hero>then(response -> response.json()).onCatch(this::handleError);
	}

	public Promise<?> delete(Hero hero) {
		return http.delete(heroesUrl + "/" + hero.id).toPromise()
				.onCatch(this::handleError);
	}

	private Promise<?> handleError(Object error) {
		GWT.log("An error occurred" + error);
		return Promise.reject(error);
	}
}
