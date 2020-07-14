package ua.lviv.lgs;

import java.lang.reflect.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, 
		InstantiationException, IllegalAccessException,
		IllegalArgumentException, InvocationTargetException, 
		NoSuchFieldException 
	{
		
		//Part I
		Client client1 = new Client("Petro", "Petrenko", 1452, "po4ka");
		
		client1.showClientInfo();
		
		//Get class
		Class<?> clientClass = client1.getClass();
		System.out.println(clientClass.getName());
		
		//Get custom constructor
		Constructor<?> a = clientClass.getConstructor(new Class<?>[] {String.class, String.class, int.class, String.class});
		System.out.println(a);
		
		//Parameter types of the custom constructor
		Class<?>[] constructorParameters = a.getParameterTypes();
		for (int i = 0; i < constructorParameters.length; i++) 
		{
			System.out.println(constructorParameters[i]);
		}
		
		//Object initiation using Constructor object
		client1 = (Client) a.newInstance("Ivan", "Ivanov", 1452, "po4ka");
		client1.showClientInfo();
		
		//Get all constructors
		Constructor<?>[] constructors = clientClass.getConstructors();
		for (int i = 0; i < constructors.length; i++) 
		{
			System.out.println(constructors[i]);
		}
		
		//Get all fields
		Field[] fields = clientClass.getFields();
		for (int i = 0; i < fields.length; i++) 
		{
			System.out.println(fields[i]);
		}
		
		//Get all methods
		Method[] methods = clientClass.getMethods();
		for (int i = 0; i < methods.length; i++) 
		{
			System.out.println(methods[i]);
		}
		
		//Part II
		System.out.println();
		Field[] fields02 = clientClass.getDeclaredFields();
		for (int i = 0; i < fields02.length; i++) 
		{
			fields02[i].setAccessible(true);
			System.out.println(fields02[i] + " = " + fields02[i].get(client1));
		}
		
		//Change field values
		fields02[2].set(client1, 2222);
		Field b = Client.class.getDeclaredField(fields02[3].getName());
		b.setAccessible(true);
		b.set(client1, "morkva");
		
		System.out.println();
		for (int i = 0; i < fields02.length; i++) 
		{
			fields02[i].setAccessible(true);
			System.out.println(fields02[i] + " = " + fields02[i].get(client1));
		}
		
		//Access private methods
		System.out.println();
		Method[] methods02 = client1.getClass().getDeclaredMethods();
		for (int i = 0; i < methods02.length; i++) 
		{
			if(methods02[i].getParameterCount() == 0)
			{
				methods02[i].setAccessible(true);
				methods02[i].invoke(client1, null);
			}
		}

		//Part III
		
		//Method 1(string, integer)
		System.out.println();
		Method method = client1.getClass().getDeclaredMethod("myMethod", new Class<?>[] {String.class, int.class});
		method.setAccessible(true);
		method.invoke(client1, "A", 1);
		System.out.println();
		
		//Method 2(string)
		method = client1.getClass().getDeclaredMethod("myMethod", new Class<?>[] {String.class});
		method.setAccessible(true);
		method.invoke(client1, "A");
	}

}
