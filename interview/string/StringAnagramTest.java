package string;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringAnagramTest {

    @Test
    public void testIsAnagram(){
        assertTrue(AnagramCheck.isAnagram("word", "wrdo"));
        assertFalse(AnagramCheck.isAnagram("fill", "fil"));
    }
    @Test
    public void testIAnagram(){
        assertTrue(AnagramCheck.iAnagram("word", "wrdo"));
        assertFalse(AnagramCheck.iAnagram("fill", "fil"));
    }

    @Test
    public void testCheckAnagram(){
        assertTrue(AnagramCheck.checkAnagram("word", "wrdo"));
        assertFalse(AnagramCheck.checkAnagram("fill", "fil"));
    }
}
