import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @Test
  public void Word_instantiatesCorrectly_true() {
   Word word = new Word("bark");
   assertEquals(true, word instanceof Word);
  }
  @Test
  public void Word_setWordGetterWorks_String() {
   Word word = new Word("bark");
   assertEquals("bark", word.getSetWord());
  }

}
