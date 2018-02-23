import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Tasks {
	
	private static final String ALICE = "src/Alice-in-Wonderland.txt";

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
	
	public static String readFileUrl(InputStream i) {
		StringBuilder data = new StringBuilder();
		InputStream in = null;
		try {
			in = i;
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while (true) {
				c = reader.read();
				if (c < 0)
					break;
				data = data.append((char)c);
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

	public static InputStream openUrl(String urlstr) throws IOException {
		URL url = null;
		try {
			url = new URL(urlstr);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} 
		return url.openStream(); 
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Reading " + ALICE + " using FileReader, append to String.");
		Stopwatch s = new Stopwatch();
		s.start();
		String data1 = readFileToString(ALICE);
		s.stop();
		System.out.printf("Read %d chars in %f sec.\n", data1.length(), s.getElapsed());
		
		System.out.println("Reading " + ALICE + " using FileReader, append to StringBuilder.");
		s.start();
		String data2 = readFileToStringBuilder(ALICE);
		System.out.printf("Read %d chars in %f sec.\n", data2.length(), s.getElapsed());
		s.stop();
	
		System.out.println("Reading " + ALICE + " using BufferedReader, append lines to String.");
		s.start();
		String data3 = readFileToStringBufferedReader(ALICE);
		System.out.printf("Read %d chars in %f sec.\n", data3.length(), s.getElapsed());
		s.stop();
	}
}