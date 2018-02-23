import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Read from a file using InputStreamReader and collect the data in String.
 * @author Dechabhol Kotheeranurak
 *
 */

public class AppendStringTask implements Runnable{
	
	private String s;
	private final String ALICE = "src/Alice-in-Wonderland.txt";
	
	public static String readFileToString(String name) {
		String data = "";
		InputStream in = null;
		try {
			in = new FileInputStream(name);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while (true) {
				c = reader.read();
				if (c < 0)
					break;
				data = data + (char) c;
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		try {
			if (in != null)
				in.close();
		} catch (IOException e) {
		}
		return data.toString();
	}

	@Override
	public void run() {
		s = readFileToString(ALICE);
	}
	
	public String toString() {
		return String.format("%d", s.length());
	}
	
	
	


}
