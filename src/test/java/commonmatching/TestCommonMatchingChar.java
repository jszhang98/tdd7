package commonmatching;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCommonMatchingChar {
    @Test
    public void testIsmatch(){
        CommonMatchingChar commonMatchingChar = new CommonMatchingChar();

        String toBeMatched = "a";
        String matchedStrWithChar = "aa.";
        boolean result = commonMatchingChar.isMatch(toBeMatched,matchedStrWithChar);
        assertFalse(result);


        toBeMatched = "aa";
        matchedStrWithChar = "aa";
        result = commonMatchingChar.isMatch(toBeMatched,matchedStrWithChar);
        assertTrue(result);

        /////
        toBeMatched = "aaa";
        matchedStrWithChar = "a.";
        result = commonMatchingChar.isMatch(toBeMatched,matchedStrWithChar);
        assertFalse(result);

        toBeMatched = "aaaa";
        matchedStrWithChar = "a*a";
        result = commonMatchingChar.isMatch(toBeMatched,matchedStrWithChar);
        assertTrue(result);

        toBeMatched = "aaaa";
        matchedStrWithChar = "a*a";
        result = commonMatchingChar.isMatch(toBeMatched,matchedStrWithChar);
        assertTrue(result);

        toBeMatched = "aa";
        matchedStrWithChar = "a.";
        result = commonMatchingChar.isMatch(toBeMatched,matchedStrWithChar);
        assertTrue(result);

        toBeMatched = "aa";
        matchedStrWithChar = "a*";
        result = commonMatchingChar.isMatch(toBeMatched,matchedStrWithChar);
        assertTrue(result);

        toBeMatched = "aa";
        matchedStrWithChar = "b*";
        result = commonMatchingChar.isMatch(toBeMatched,matchedStrWithChar);
        assertFalse(result);

        toBeMatched = "aasdfasfasfa";
        matchedStrWithChar = "badf*dsf.";
        result = commonMatchingChar.isMatch(toBeMatched,matchedStrWithChar);
        assertFalse(result);
    }
}
