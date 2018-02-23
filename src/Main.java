
public class Main {
	
	public static void main(String[] args) {
		
		TaskTimer t = new TaskTimer(new AppendStringBuilderTask());
		System.out.println(t.getTime());
		System.out.println(t.getChar());
		System.out.println(t.toString());
		
		
	}

}
