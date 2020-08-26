package JavaInterviewQuestions;

public class aTestCar {

	public static void main(String[] args) {
		
		aBMW b = new aBMW();
		b.start(); 
		//warning: start() method is not supposed to override the static start() method from parent class.
		//But since it is using Method Hiding (mark static in child class - BMW), it'll be an independent method, which is not belonging to b object.
		b.stop();
		b.refuel();

	}

}
