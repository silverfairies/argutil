package an.argentum.util;

import java.util.Scanner;

public abstract class TerminalReader {
	private Scanner scanner;
	protected String prefix;

	protected TerminalReader () {
		//in any extention implement a constructor with a new prefix
		this.scanner = new Scanner(System.in);
	}

	public void start () {
		while ( loop() );
	}

	private boolean loop () {
		System.out.print(prefix);
		String input = scanner.nextLine();
		return decode(input.split(" "));
	}

	protected abstract boolean decode ( String[] input );
}
