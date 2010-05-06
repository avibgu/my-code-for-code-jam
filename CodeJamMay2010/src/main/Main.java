package main;

import java.io.FileInputStream;

import exception.GiveUpException;


public class Main {

	public static void main(String[] args){

		FileHandling fh = new FileHandling();
		FileInputStream file = null;

		try {

			file = fh.openFileForReading(args[0]);

			String toWrite = "";

			fh.writeToFile("output,txt" , toWrite);

			System.out.println(toWrite);

		}
		catch (GiveUpException e) {

			System.out.println("exiting..");
		}
	}
}
