package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Observable;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Http;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class HeroSearchService
{
	private Http http;

	@JsConstructor
	public HeroSearchService( Http http )
	{
		this.http = http;
	}

	public Observable<JsArray<Hero>> search( String term )
	{
		return http.get( "app/heroes/?name=" + term ).map( response -> response.json() );
	}
}
