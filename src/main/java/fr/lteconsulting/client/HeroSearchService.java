package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Injectable;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.angular.Http;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Observable;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class HeroSearchService {
	private Http http;
	
	@JsConstructor
	public HeroSearchService( Http http ) {
		this.http = http;
	}

	public Observable<JsArray<Hero>> search(String term) {
		return http.get("app/heroes/?name="+term).map(response->response.json());
	}
}
