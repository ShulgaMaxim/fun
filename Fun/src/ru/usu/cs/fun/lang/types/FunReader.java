package ru.usu.cs.fun.lang.types;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class FunReader extends Term {

	public Scanner input;

	public Scanner createInput(String fileName, String encode) {

		try {
			File f = new File(fileName);
			return new Scanner(f, encode);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("File not found or unsupported encoding");
		}
	}

	public FunReader(String fileName, String encode) {
		super();
		this.input = createInput("./src/files/" + fileName, encode);
	}

	public FunReader(String str) {
		super();
		this.input = new Scanner(str);
	}

	public FunReader() {
		super();
		this.input = new Scanner(new InputStreamReader(System.in));
	}
	
	@Override
	public String toString(TermsSubstitutor substitutor) {
		return input.toString();
	}
}
