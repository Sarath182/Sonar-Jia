import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

//import org.junit.Test;

public class SonarJira {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inline = "";
			try {
				URL url = new URL("http://sonar.hm.com/api/issues/search?pageSize=500");
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				int responseCode = conn.getResponseCode();
				if (responseCode != 200){
					System.out.println("Bad response"+responseCode);
				}
				else {
					Scanner sc = new Scanner(url.openStream());
					while(sc.hasNext())
					{
						inline+=sc.nextLine();
					}
					System.out.println("\nJSON data in string format");
					System.out.println(inline);
					sc.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			usingFileWriter(inline);
	}
	public static void usingFileWriter(String jsonvalue) throws IOException {
	    FileWriter fileWriter = new FileWriter("Sonar.json");
	    fileWriter.write(jsonvalue);
	    fileWriter.close();
	}
	//@Test
	//public void testing() {
		
	//}

}
