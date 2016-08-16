package fr.lteconsulting.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType
public class Hero
{
	@JsProperty
	public int id;

	@JsProperty
	public String name;

	@JsConstructor
	public Hero()
	{
		id = 0;
	}

	@JsIgnore
	public Hero( int id, String name )
	{
		this();

		this.id = id;
		this.name = name;
	}
}
