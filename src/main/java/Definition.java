import java.util.List;
import java.util.ArrayList;


public class Definition {
  private String mDefineWord;
  private int mId;
  private static List<Definition> instances = new ArrayList<Definition>();

  public Definition (String defineWord){
    mDefineWord = defineWord;
    instances.add(this);
    mId = instances.size();
  }

  public String getDefineWord(){
    return mDefineWord;
  }

  public static List<Definition> all() {
   return instances;
  }

  public static void clear() {
   instances.clear();
  }

  public int getId() {
   return mId;
  }

  public static Definition find(int id) {
   return instances.get(id - 1);
  }
}
