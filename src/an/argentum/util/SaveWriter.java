package an.argentum.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class SaveWriter {

    static protected String separator = ": ";

    public static void save ( File file, HashMap<String, String> contents ) throws IOException {
        write ( file, contents, separator);
    }

    private static void write ( File file, HashMap<String, String> contents, String delimiter ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for ( String key: contents.keySet() ) bw.write( key + delimiter + "\"" + contents.get(key) + "\"\n");
        bw.close();
    }
}
