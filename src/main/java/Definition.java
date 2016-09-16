import java.util.List;
import java.util.ArrayList;


public class Definition {
  private String mDefineWord;
  private String mUserName;
  private int mId;
  private static List<Definition> instances = new ArrayList<Definition>();

  public Definition (String defineWord, String userName){
    mDefineWord = defineWord;
    mUserName = userName;
    instances.add(this);
    mId = instances.size();
  }

  public String getDefineWord(){
    return mDefineWord;
  }

  public String getUserName(){
    return mUserName;
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
