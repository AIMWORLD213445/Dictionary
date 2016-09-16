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
  public void Definition_userNameGetterWorks_String() {
   Definition definition = new Definition("the sound a dog makes","dictionaryfan333");
   assertEquals("dictionaryfan333", definition.getUserName());
  }
  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition definitionOne = new Definition("the sound a dog makes","dictionaryfan333");
    Definition definitionTwo = new Definition("the surface layer of a tree","dictionaryfan333");
    assertEquals(true, Definition.all().contains(definitionOne));
    assertEquals(true, Definition.all().contains(definitionTwo));
  }
  @Test
  public void clear_emptiesAllDefinitonsFromArrayList_0() {
    Definition definition = new Definition("the sound a dog makes","dictionaryfan333");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_definitionsInstantiateWithAnID_1() {
    Definition.clear();
    Definition definition = new Definition("the sound a dog makes","dictionaryfan333");
    assertEquals(1, definition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_definitionTwo() {
    Definition definitionOne = new Definition("the sound a dog makes","dictionaryfan333");
    Definition definitionTwo = new Definition("the surface layer of a tree","dictionaryfan333");
    assertEquals(Definition.find(definitionTwo.getId()), definitionTwo);
  }
}
