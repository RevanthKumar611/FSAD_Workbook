package com.klu.demo;

public class bike {
 private Engine engine;
 public void setEngine(Engine engine)
 {
	 this.engine=engine;
 }
	
	public void ride()
	{
		engine.start();
		System.out.println("Bike is running.....");
	}
	
	
	
	
	
	
	
}
