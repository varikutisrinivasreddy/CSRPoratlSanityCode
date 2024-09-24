package PanoData;


import java.io.IOException;
import java.util.ArrayList;

public class dataTest {

	public static void main(String[] args) throws IOException {
		dataDrivenPano d=new dataDrivenPano();
		ArrayList data=d.getDataExcel("workreqValidation");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));

	}

}
