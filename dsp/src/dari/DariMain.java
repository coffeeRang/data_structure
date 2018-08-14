package dari;

import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class DariMain {
	
	public static void main(String[] args) {
		Random rand = new Random();
		
//		System.out.println(rand.nextInt(10000));

//		List<Integer> randomNumList = new ArrayList<Integer>();
		StringBuffer randomNumBuffer = new StringBuffer();
		for (int i = 0; i < 4; i ++) {
			int randomNum = rand.nextInt(10);
//			randomNumList.add(randomNum);
			randomNumBuffer.append(randomNum);
		}
		
//		System.out.println(">> randomNumList : " + randomNumList);
		System.out.println(">> randomNumBuffer : " + randomNumBuffer);
		
		
	}

}
