
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
}
