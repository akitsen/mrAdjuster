package mr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class adjuster {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		BufferedReader br = null;

		BufferedWriter bw = null;

		String sCurrentLine;

		br = new BufferedReader(new FileReader("final2.txt"));

		bw = new BufferedWriter(new FileWriter(new File("output.txt")));

		PrintStream ps = new PrintStream("ps.txt");

		PrintStream orig = System.out;

		String lastterm = "";

		try {

			while ((sCurrentLine = br.readLine()) != null) {
				String[] inputtemp = sCurrentLine.split(",");

				String term = inputtemp[0];
				// System.out.println(term);
				String url = inputtemp[1];
				String num = inputtemp[2];

				System.setOut(ps);

				if (lastterm.equals(term) == false) {
					lastterm = term;
					//bw.write("\n");
					//bw.write("test");
					bw.write("]\n" + term + "\t[[" + url + "," + num + "]");
					System.out.println("]" + term + "\t[[" + url + "," + num + "]");
				} else {
					bw.write(",[" + url + "," + num + "]");
					System.out.println(",[" + url + "," + num + "]");
				}
				System.setOut(orig);


			}
			ps.close();

		} finally {

			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
