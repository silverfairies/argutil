package an.argentum.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class SaveWriter {

    static protected String separator = ": ";

    public static void save ( File file, HashMap<String, String> contents ) throws IOException {
        write ( file, contents );
    }

    public static void append ( File file, String key, String value ) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        fw.write(construct(key, value));
        fw.close();
    }

    private static void write ( File file, HashMap<String, String> contents ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for ( String key: contents.keySet() ) bw.write( construct(key, contents.get(key)) );
        bw.close();
    }

    private static String construct ( String key, String value ) {
        return key + separator + "\"" + value + "\"\n";
    }
}
