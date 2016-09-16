
import java.util.List;
import java.util.ArrayList;

public class Word {
  private String mSetWord;
  private static List<Word> instances = new ArrayList<Word>();
  private List<Definition> mDefinitions;
  private int mId;

  public Word (String setWord){
  mSetWord = setWord;
  instances.add(this);
  mDefinitions = new ArrayList<Definition>();
  mId = instances.size();
  }

  public String getSetWord() {
  return mSetWord;
  }

  public static List<Word> all() {
    return instances;
  }

  public static void clear(){
    instances.clear();
  }

  public int getId(){
    return mId;
  }

  public static Word find(int id){
    return instances.get(id-1);
  }

  public List<Definition> getDefinitions() {
    return mDefinitions;
  }
}
