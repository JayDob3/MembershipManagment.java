package javaproject;

/**
*
* @author Jay Dobson
*/

import java.util.LinkedList;
import java.io.*;

public class FileHandler {

	// method to read in file
	public LinkedList<Member> readFile() {
		LinkedList<Member> m = new LinkedList();
		String lineRead;
		String[] splitLine;
		Member mem;

		// attempts to read from csv file
		try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
			lineRead = reader.readLine();

			// processes file line by line while lineRead is not null
			while (lineRead != null) {
				// use the equals method to compare the first element of the splitLine array
				splitLine = lineRead.split(", ");

				if (splitLine[0].equals("S")) {
					// instantiates and assigns a SingleClubMember object to mem
					mem = new SingleClubMember('S', Integer.parseInt(splitLine[1]), splitLine[2],
							Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));

				} else

				{
					// instantiates and assigns a MultiClbMember object to mem
					mem = new MultiClubMember('M', Integer.parseInt(splitLine[1]), splitLine[2],
							Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
				}

				// adds mem to LinkedList m
				m.add(mem);

				// reads the next line and uses it to update the lineRead variable
				lineRead = reader.readLine();

			}

		}
		// catch IOException errors
		catch (IOException e) {
			// prints out the error
			System.out.println(e.getMessage());
		}
		// returns the LinkedList m
		return m;

	}

	// method appends a new line to members.csv whenever a new member is added
	public void appendFile(String mem) {

		// appends file instead of overwriting it, true indicates that we want to append
		// the file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
			// appends string to mem and points the cursor to next line afterwards
			writer.write(mem + "\n");
		}
		// block catches errors and prints them
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// method called whenever we want to remove a member from the club and updates
	// the csv file
	public void overwriteFile(LinkedList<Member> m) {
		String s;

		// creates temp file and writes data in the LinkedList to this file, it
		// overwrites by passing false
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false))) {

			// loops through the elements in LinkedList that is passed in
			for (int i = 0; i < m.size(); i++) {
				// get grabs the index and toString() gets a string representation of the
				// element and assigns it to s
				s = m.get(i).toString();

				// writes the string s to members.temp file
				writer.write(s + "\n");
			}
			// catch and display errors
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// declare two File objects to delete original members.csv file and rename
		// members.temp to memebers.csv
		try {
			File f = new File("members.csv");
			File tf = new File("members.temp");

			// deletes f file
			f.delete();

			// renames tf file
			tf.renameTo(f);

			// block catches errors and prints them
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
