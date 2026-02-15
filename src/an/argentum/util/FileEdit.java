package an.argentum.util;

import java.io.File;
import java.nio.file.Path;

public final class FileEdit {
    public static void delete ( Path path, String directory ) {
        Path buffer = path.resolve(directory);
        for ( File each : buffer.toFile().listFiles()) delete(each);
    }

    private static void delete ( File file ) {
        if ( !file.isDirectory() || (file.isDirectory() && file.listFiles().length == 0) ) file.delete(); else {
            for(File each : file.listFiles()) {
                delete(each);
            }
            file.delete();
        }
    }
}
