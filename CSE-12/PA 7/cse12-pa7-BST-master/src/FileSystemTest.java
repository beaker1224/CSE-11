import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.*;
import org.junit.*;

public class FileSystemTest {
    @Test
    public void testDAddDup(){
        FileSystem files = new FileSystem();
        String name1 = "1";
        String name2 = "2";
        String dir = "/Chrome";
        String date1 = "2024/05/23";
        String date2 = "2024/05/23";
        files.add(name1, dir, date1);
        files.add(name2, dir, date2);
        files.add(name2, dir, date2);
        ArrayList<FileData> f2 = files.dateTree.get(date2);
        assertEquals(2, f2.size());
        assertEquals("2", files.findFileNamesByDate(date2).get(1));
    }

    @Test
    public void testAddDuplicates(){
        FileSystem files = new FileSystem();
        String name1 = "1";
        String dir = "/Chrome";
        String date1 = "2024/05/23";
        files.add(name1, dir, date1);
        files.add(name1, dir, date1);
        ArrayList<FileData> f1 = files.dateTree.get(date1);
        assertEquals(1, f1.size());
    }
    @Test
    public void testDateOrder(){
        FileSystem files = new FileSystem();
        files.add("f1.txt", "/Chrome", "2024/01/01");
        files.add("f2.txt", "/Chrome", "2024/02/01");
        files.add("f3.txt", "/Chrome", "2024/03/01");
    
        List<String> result = files.outputDateTree();

        assertEquals(3, result.size());
        assertTrue(result.get(0).contains("2024/01/01"));
        assertTrue(result.get(1).contains("2024/02/01"));
        assertTrue(result.get(2).contains("2024/03/01"));
    

}