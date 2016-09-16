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
  @Test
  public void find_findsWordAssociatedWithEquivalentId_wordTwo() {
    Word.clear();
    Word wordOne = new Word("bark");
    Word wordTwo = new Word("dog");
    assertEquals(wordTwo, Word.find(wordTwo.getId()));
  }
  @Test
  public void getDefinitions_returnsEmptyArrayListUntilDefinitionsAdded_0() {
    Word.clear();
    Word word = new Word("bark");
    assertEquals(0, word.getDefinitions().size());
  }
  @Test
  public void addDefinition_AddNewDefinitionToList_true() {
    Word.clear();
    Word word = new Word("bark");
    Definition definition = new Definition("sound a dog makes");
    word.addDefinition(definition);
    assertEquals(true, word.getDefinitions().contains(definition));
  }
}
