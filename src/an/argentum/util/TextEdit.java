package an.argentum.util;

import java.io.File;
import java.io.IOException;

public final class TextEdit {
    public static String arrayToString( String[] input ) {
        return arrayToString(input, " ");
    }

    public static String arrayToString( String[] input, String delimiter ) {
        StringBuilder output = new StringBuilder();
        for ( String each : input ) output.append(each + delimiter);
        return output.toString();
    }

    public static void execute ( String[] prompt, File directory) {
        try {
            Process process = new ProcessBuilder(prompt)
            .directory(directory)
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .redirectInput(ProcessBuilder.Redirect.INHERIT)
            .start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void execute (String... prompt) {
        execute(prompt, null);
    }

    public static String getFirstString ( String input ) throws StringIndexOutOfBoundsException {
        if ( input.indexOf('"') == input.lastIndexOf('"') || input.lastIndexOf('"') == -1 ) throw new StringIndexOutOfBoundsException("No valid String found!");
        return input.substring( input.indexOf('"') + 1, input.indexOf( '"', input.indexOf('"') + 1));
    }

    public static String getFirstString ( String[] input ) {
        return getFirstString(arrayToString(input));
    }
}
