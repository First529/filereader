import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Read from a file using InputStreamReader and store the collected data as StringBuilder.
 * @author Dechabhol Kotheeranurak
 *
 */

public class AppendStringBuilderTask implements Runnable {

	private String s;

	private final String ALICE = "src/Alice-in-Wonderland.txt";

	public static String readFileToStringBuilder(String name) {
		StringBuilder data = new StringBuilder();
		InputStream in = null;
		try {
			in = new FileInputStream(name);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while (true) {
				c = reader.read();
				if (c < 0)
					break;
				data = data.append((char) c);
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
		s = readFileToStringBuilder(ALICE);
	}
	
	public String toString() {
		return String.format("%d", s.length());
	}

}
