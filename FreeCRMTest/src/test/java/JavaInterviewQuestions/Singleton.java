package JavaInterviewQuestions;

public class Singleton {
	
	//In OOP, a singleton class is the class which can have only one object (instance of the class)
	//How to design singleton class in Java
	//1. make constructor a private class
	//2. write a public static method (getInstance) which returns type of the object of this singleton class (lazy initialization)
	//Difference between general class and singleton class:
	//General class uses Constructor, whereas singleton class uses getInstance method for instantiation.
	
	
	private static Singleton singleton_instance = null;
	public String str;
	
	//private constractor
	private Singleton() {
		str = "I am using Singleton design patten";
	}

	//public static method which returns the type of object of this singleton class (lazy initialization)
	public static Singleton getInstance() {
		if(singleton_instance == null) {
			singleton_instance = new Singleton();
		}
		return singleton_instance;
	}
	
	
	public static void main(String[] args) {
		Singleton x = Singleton.getInstance();
		//since singleton_instance is not null now (for y), so there won't new object recreated. y is still pointing to the object referred by x.
		Singleton y = Singleton.getInstance();
		Singleton z = Singleton.getInstance();
		
		//Make all chars in str of reference x to uppercase
		x.str = (x.str).toUpperCase();
		
		//The str of all references x, y, z will be uppercase because these references are pointing to same object - singleton mode.
		System.out.println(x.str);
		System.out.println(y.str);
		System.out.println(z.str);
		
		z.str = (z.str).toLowerCase();
		System.out.println(x.str);
		System.out.println(y.str);
		System.out.println(z.str);

	}

}
