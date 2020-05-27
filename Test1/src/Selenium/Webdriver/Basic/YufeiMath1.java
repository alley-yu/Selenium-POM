package Selenium.Webdriver.Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YufeiMath1 {
	
	public void yufeiMathLastOne() {
		//List<Integer> tenPeopleQueue = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> tenPeopleQueue = new ArrayList();
		for (int i = 0; i< 10; i++) {
			tenPeopleQueue.add(i+1);
		}
//		tenPeopleQueue.add(1);
//		tenPeopleQueue.add(2);
//		tenPeopleQueue.add(3);
//		tenPeopleQueue.add(4);
//		tenPeopleQueue.add(5);
//		tenPeopleQueue.add(6);
//		tenPeopleQueue.add(7);
//		tenPeopleQueue.add(8);
//		tenPeopleQueue.add(9);
//		tenPeopleQueue.add(10);
		
		while (tenPeopleQueue.size() > 1) {
//			tenPeopleQueue.add(tenPeopleQueue.get(0));
//			tenPeopleQueue.remove(0);
			int removedNum = tenPeopleQueue.remove(0);
			tenPeopleQueue.add(removedNum);
			tenPeopleQueue.remove(0);
		}
		
		System.out.println(tenPeopleQueue);
	}

	public static void main(String[] args) {
		YufeiMath1 obj = new YufeiMath1();
		obj.yufeiMathLastOne();
	}

}
