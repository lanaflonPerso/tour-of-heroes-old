package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Injectable;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class HeroService
{
	public Promise<JsArray<Hero>> getHeroes()
	{
		return Promise.resolve( MockHeroes.HEROES );
	}
}
