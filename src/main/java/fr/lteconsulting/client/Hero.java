package fr.lteconsulting.client;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType
public class Hero
{
	@JsProperty
	public int id;

	@JsProperty
	public String name;

	public Hero( int id, String name )
	{
		this.id = id;
		this.name = name;
	}
}
