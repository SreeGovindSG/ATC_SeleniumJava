import java.io.IOException;

public class Test {
	public static void main(String[] args){
		AutomationPractice a= new AutomationPractice();
		a.launchApp();
		try {
			a.mainCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.close();
	}
}
