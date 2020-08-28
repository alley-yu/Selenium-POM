package JavaBasic;

public class CallByValueAndCallByRef {
	
	int q;
	int p;

	public static void main(String[] args) {
		
		CallByValueAndCallByRef obj = new CallByValueAndCallByRef();
		int x = 10;
		int y = 20;
		System.out.println(obj.sum(x, y)); //call by value
		
		obj.q = 50;
		obj.p = 60;
		obj.swap(obj); //call by ref
		System.out.println("q = " + obj.q);
		System.out.println("p = " + obj.p);

	}
	
	public int sum(int a, int b) {
		int c = a + b;
		return c;
	}
	
	public void swap(CallByValueAndCallByRef t) {
		
		int temp = t.q;
		t.q = t.p;
		t.p = temp;
		
	}

}
