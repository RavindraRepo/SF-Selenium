import java.util.ArrayList;
import java.util.List;


public class FunctionTest {

	public static void main(String[] args) {
		List<String> li=new ArrayList<String>();
		li.add("ravindra");
		li.add("test1");
		li.add("test2");
		li.add("test3");
		for (String string : li) {
			System.out.println("inside foreach"+li.indexOf(string));
			if(string=="test1"){
				System.out.println("Break "+li.indexOf(string));
			
			break;
		}
		}
System.out.println("OutSide for each");
	}

}
