package round1b;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class GarbledEmail {

	public static Set<String> corpus = null;

	{
		try {
			corpus = new HashSet<String>(FileUtils.readLines(new File(
					"round1bFiles/garbled_email_dictionary.txt")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String S;

	public GarbledEmail(String pS) {
		S = pS;
	}

	public int calc() {

		System.out.println(S + "bla bla..");

		// TODO Auto-generated constructor stub
		return -1;
	}
}
