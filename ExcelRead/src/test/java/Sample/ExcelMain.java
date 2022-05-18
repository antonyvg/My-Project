package Sample;

import java.io.IOException;

public class ExcelMain {

	public static void main(String[] args) throws IOException {
		
		String a=ExcelRead.readStringData(0,0);
		System.out.println(a);
		
		String b=ExcelRead.readStringData(0,1);
		System.out.println(b);
		
		String c=ExcelRead.readIntegerData(1,1);
		System.out.println(c);
		

	}

}
