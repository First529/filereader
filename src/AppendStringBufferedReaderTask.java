import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Read from a file using BufferedReader and collect the data using String.
 * @author Dechabhol Kotheeranurak
 *
 */

public class AppendStringBufferedReaderTask implements Runnable {

	private String s;

	private final String ALICE = "src/Alice-in-Wonderland.txt";

	public static String readFileToStringBufferedReader(String name) {
		String data = "";
		InputStream in = null;
		try {
			in = new FileInputStream(name);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String c;
			while (true) {
				c = reader.readLine();
				if (c == null) break;
				data = data + c + "\n";
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
		s = readFileToStringBufferedReader(ALICE);
	}
	
	public String toString() {
		return String.format("%d", s.length());
	}

}
