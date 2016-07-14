package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.Injectable;
import fr.lteconsulting.angular2gwt.client.JsArray;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class HeroService
{
	public JsArray<Hero> getHeroes()
	{
		return MockHeroes.HEROES;
	}
}
