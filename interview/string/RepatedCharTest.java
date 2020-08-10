package string;
import org.junit.Test;
import static org.junit.Assert.*;

public class RepatedCharTest {

    @Test
    public void testFirstNonRepeatedCharacter() {
        assertEquals('J', RepeatedChar.firstNonRepeatedCharacter("Java"));
        assertEquals('i', RepeatedChar.firstNonRepeatedCharacter("simplest")); }
    @Test
    public void testFirstNonRepeatingChar() {
        assertEquals('J', RepeatedChar.firstNonRepeatingChar("Java"));
        assertEquals('i', RepeatedChar.firstNonRepeatingChar("simplest"));
     }

    @Test public void testGetFirstNonRepeatedChar(){
        assertEquals('J', RepeatedChar.getFirstNonRepeatChar("Java"));
        assertEquals('i', RepeatedChar.getFirstNonRepeatChar("simplest"));
    }

}
