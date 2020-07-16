package JavaBasic;

public class Car {
	
//	Define class-level var
	String mod;
	int motorNum;

	public static void main(String[] args) {
		
		Car carA = new Car(); //new Car() is an object. carA is ref.
		Car carB = new Car();
		Car carC = new Car();
		
		carA.mod = "Model 3";
		carA.motorNum = 1;
		
		carB.mod = "Model X";
		carB.motorNum = 2;
		
		carC.mod = "Model Y";
		carC.motorNum = 2;
		
		System.out.println("Before assignment");
		System.out.println("carA: " + carA.mod + " with " + carA.motorNum + " motor(s)");
		System.out.println("carB: " + carB.mod + " with " + carB.motorNum + " motor(s)");
		System.out.println("carC: " + carC.mod + " with " + carC.motorNum + " motor(s)");
		
		carA = carB;
		carB = carC;
		carC = carA;
		System.out.println("After assignment");
		System.out.println("carA: " + carA.mod + " with " + carA.motorNum + " motor(s)");
		System.out.println("carB: " + carB.mod + " with " + carB.motorNum + " motor(s)");
		System.out.println("carC: " + carC.mod + " with " + carC.motorNum + " motor(s)");
		
		System.out.println("After assignment, the object carA refered to, turns to a garbage since it has no reference any more.");
		

	}

}
