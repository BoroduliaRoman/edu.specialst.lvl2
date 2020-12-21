import java.io.IOException;

public class Program {
	public static void main(String[] args) throws IOException {
		System.out.println("Starting external app...");
		
		Runtime.getRuntime().exec("explorer.exe");
	}
}