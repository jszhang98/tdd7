import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileOrDirExist {
    public boolean isFileOrDirExist(String path) {
        File file = new File(path);
        return file.exists();
    }
}
