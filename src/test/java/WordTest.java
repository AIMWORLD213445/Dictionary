import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @Test
  public void Word_instantiatesCorrectly_true() {
   Word word = new Word("bark");
   assertEquals(true, word instanceof Word);
  }
  @Test
  public void getSetWord_getsInputWord_String() {
   Word word = new Word("bark");
   assertEquals("bark", word.getSetWord());
  }
  @Test
  public void all_returnsAllWords_true(){
    Word wordOne =new Word("bark");
    Word wordTwo =new Word("dog");
    assertEquals(true, Word.all().contains(wordOne));
    assertEquals(true, Word.all().contains(wordTwo));
  }
  @Test
  public void clear_clearsTheArrayListOfWords_0(){
    Word word = new Word("bark");
    Word.clear();
    assertEquals(0, Word.all().size());
  }

  @Test
  public void getId_instantiatesAnId_1() {
    Word.clear();
    Word freshWord = new Word("bark");
    assertEquals(1, freshWord.getId());
  }
}
