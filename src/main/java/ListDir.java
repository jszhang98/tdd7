import java.io.File;

public class ListDir {
    public boolean listAllFileAndDirectory(String dir) {
        File file = new File(dir);
        String[] allList = file.list();
        boolean result = allList==null?false:true;
        if (allList!=null) {
            for (String str : allList) {
                System.out.println(str);
            }
        }
        return result;
    }
}
