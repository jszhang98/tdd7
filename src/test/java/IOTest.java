import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class IOTest {
    @Test
    public void testListDirectory(){

        ListDir listDir = new ListDir();
        String dir = "\\";
        boolean result = listDir.listAllFileAndDirectory(dir);
        assertTrue(result);
        dir = "\\test";
        result = listDir.listAllFileAndDirectory(dir);
        assertFalse(result);
    }
    @Test
    public void testGetSpecificFilesWithExtension(){
        FileWithExtension fileWithExtension = new FileWithExtension();
        File[] str = fileWithExtension.getFiles("\\",".ini");
        int result  = str.length;
        assertEquals(2,result);

        str = fileWithExtension.getFiles("\\test",".ini");
        result = str.length;
        assertEquals(2,result);

        str = fileWithExtension.getFiles("\\test","ini");
        result = str.length;
        assertEquals(0,result);

    }
    @Test
    public void testFileOrDirExist(){
        //a file exist
        FileOrDirExist fileOrDirExist = new FileOrDirExist();
        String name = "\\test\\a.ini";
        boolean result = fileOrDirExist.isFileOrDirExist(name);
        assertTrue(result);
        //a dir exist
        name = "\\test\\test1";
        result = fileOrDirExist.isFileOrDirExist(name);
        assertTrue(result);

        // a file doesn't exist
        name = "\\test\\xxx.ini";
        result = fileOrDirExist.isFileOrDirExist(name);
        assertFalse(result);

        // a dir doesn't exist
        name = "\\test\\xxx";
        result = fileOrDirExist.isFileOrDirExist(name);
        assertFalse(result);

        String a = "aaa";
        a.compareTo("bbbb");
    }
}
