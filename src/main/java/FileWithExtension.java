import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileWithExtension {
    public File[] getFiles(String path, String extension) {
        File file = new File(path);
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String filename = pathname.getName();
                String rightStr="";
                if(filename.length()>=extension.length()) {
                    rightStr = filename.substring(filename.length() - extension.length());
                }
                boolean result = extension.equals(rightStr);
                return pathname.isDirectory() || !extension.contains(".")?false:result;
            }
        };
        return file.listFiles(fileFilter);
    }
}
