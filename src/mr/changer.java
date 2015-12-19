package mr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class changer {
	public static void main(String[] args) {
		BufferedWriter bw = null;
		BufferedReader br = null;

		try {

			String mycontent = "This String would be written" + " to the specified File";

			// Specify the file name and path here
			File file = new File("nospace.txt");

			/*
			 * This logic will make sure that the file gets created if it is not
			 * present at the specified location
			 */
			if (!file.exists()) {
				file.createNewFile();
			}

			String sCurrentLine;
			String lastterm = "";


			
			while ((sCurrentLine = br.readLine()) != null) {
				String[] inputtemp = sCurrentLine.split(",");

				String term = inputtemp[0];
				// System.out.println(term);
				String url = inputtemp[1];
				Integer num = Integer.parseInt(inputtemp[2]);

				if (lastterm.equals(term) == false) {
					lastterm = term;
					bw.write("\n");
					bw.write("test");
					System.out.println("]\n" + term + "\t[[" + url + ":" + num + "]");
				} else {
					System.out.println(",[" + url + "," + num + "]");
				}

			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(mycontent);
			System.out.println("File written Successfully");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}
	}
}