import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @Test
  public void Definition_instantiatesCorrectly_true() {
   Definition definition = new Definition("the sound a dog makes","dictionaryfan333");
   assertEquals(true, definition instanceof Definition);
  }
  @Test
  public void Definition_definitionGetterWorks_String() {
   Definition definition = new Definition("the sound a dog makes","dictionaryfan333");
   assertEquals("the sound a dog makes", definition.getDefineWord());
  }
  @Test
  public void Definition_userNamegetterWorks_String() {
   Definition definition = new Definition("the sound a dog makes","dictionaryfan333");
   assertEquals("dictionaryfan333", definition.getUserName());
  }
}
