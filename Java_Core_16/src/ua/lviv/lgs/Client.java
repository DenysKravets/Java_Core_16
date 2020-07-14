package ua.lviv.lgs;

public class Client 
{

	public String name;
	public String surname;
	
	private int cardNumber;
	private String keyWord;
	
	public Client() {}
	
	public Client(String name, String surname)
	{
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public Client(String name, String surname, int cardNumber, String keyWord)
	{
		super();
		this.name = name;
		this.surname = surname;
		this.cardNumber = cardNumber;
		this.keyWord = keyWord;
	}
	
	private void myMethod(String arg01, int arg02)
	{
		System.out.println("Success for String, int myMethod");
	}
	
	private void myMethod(String arg01)
	{
		System.out.println("Success for String myMethod");
	}
	
	public void showClientInfo()
	{
		System.out.println("\nName = " + name
				+ "\nSurname = " + surname);
	}
	
	private void showPersonalInfo()
	{
		System.out.println("\nName = " + name
				+ "\nSurname = " + surname
				+ "\nCardNumber = " + cardNumber
				+ "\nKeyWord = " + keyWord
				);
	}
	
}
