import org.junit.Test;
import tools.Indicator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestHiker {
    @Test
    public void testIsPrefix(){
        Hiker hiker = new Hiker();
        String prefix = "911";
        boolean result = hiker.isPrefix(prefix);
        assertTrue(result);

        prefix = "";
        result = hiker.isPrefix(prefix);
        assertFalse(result);

    }
    @Test
    public void testIsConsistentList(){
        Hiker hiker = new Hiker();
        boolean result = hiker.isConsistentList();
        assertFalse(result);

        List list = new ArrayList();
        list.add("91125426");
        list.add("97625992");
        list.add("9111");
        Hiker hiker1 = new Hiker(list);
        result = hiker1.isConsistentList();
        assertTrue(result);
    }
    @Test
    public void testIndicator(){
        Indicator indicator = new Indicator();
        indicator.alarm(true);
        indicator.alarm(false);
        indicator.alarm(true);
        boolean result = indicator.getStatus();
        assertTrue(result);
        assertEquals(1,indicator.getCounter());


        Indicator indicator1 = new Indicator();
        indicator1.alarm(false);
        indicator1.alarm(false);
        indicator1.alarm(false);
        result = indicator1.getStatus();
        assertFalse(result);
        assertEquals(0,indicator1.getCounter());

    }
}
