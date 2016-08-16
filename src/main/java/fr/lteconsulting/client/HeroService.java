package fr.lteconsulting.client;

import com.google.gwt.core.shared.GWT;

import fr.lteconsulting.angular2gwt.Injectable;
import fr.lteconsulting.angular2gwt.client.Ajax;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class HeroService
{
	private static final String heroesUrl = "app/heroes";

	public Promise<JsArray<Hero>> getHeroes()
	{
		// TODO : add headers : 'Content-Type', 'application/json'
		return new Promise<JsArray<Hero>>( ( resolver, rejecter ) -> {
			Ajax.sendRequestAndConvertDtoList( "GET", heroesUrl, null, Hero.class )
					.then( resolver::resolve )
					.onError( this::handleError );
		} );
	}

	public Promise<Hero> getHero( int id )
	{
		String url = heroesUrl + "/" + id;

		// TODO : add headers : 'Content-Type', 'application/json'
		return new Promise<Hero>( ( resolver, rejecter ) -> {
			Ajax.sendRequestAndConvertDto( "GET", url, null, Hero.class )
					.then( resolver::resolve )
					.onError( this::handleError );
		} );
	}

	public Promise<Hero> save( Hero hero )
	{
		if( hero.id > 0 )
			return put( hero );

		return post( hero );
	}

	public Promise<Hero> post( Hero hero )
	{
		// TODO : add headers : 'Content-Type', 'application/json'
		return new Promise<Hero>( ( resolver, rejecter ) -> {
			Ajax.sendRequestAndConvertDto( "POST", heroesUrl, hero, Hero.class )
					.then( resolver::resolve )
					.onError( this::handleError );
		} );
	}

	public Promise<Hero> put( Hero hero )
	{
		String url = heroesUrl + "/" + hero.id;

		// TODO : add headers : 'Content-Type', 'application/json'
		return new Promise<Hero>( ( resolver, rejecter ) -> {
			Ajax.sendRequestAndConvertDto( "PUT", url, hero, Hero.class )
					.then( resolver::resolve )
					.onError( this::handleError );
		} );
	}

	public Promise<String> delete( Hero hero )
	{
		String url = heroesUrl + "/" + hero.id;

		// TODO : add headers : 'Content-Type', 'application/json'
		return new Promise<String>( ( resolver, rejecter ) -> {
			Ajax.sendRequest( "DELETE", url )
					.then( resolver::resolve )
					.onError( this::handleError );
		} );
	}

	private Promise<?> handleError( Object error )
	{
		GWT.log( "An error occurred" + error );
		return Promise.reject( error.toString() );
	}
}
