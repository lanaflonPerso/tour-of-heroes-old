package fr.lteconsulting.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, name = "Object")
public class Hero {
	public int id;
	public String name;
	public String description;
	public String phoneNumber;

	@JsConstructor
	public Hero() {
		id = 0;
	}

	@JsIgnore
	public Hero(int id, String name) {
		this();

		this.id = id;
		this.name = name;
		this.phoneNumber = "(00)-33 12345678";
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + "]";
	}
}
