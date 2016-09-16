public class Definition {
  private String mDefineWord;
  private String mUserName;

  public Definition (String defineWord, String userName){
    mDefineWord = defineWord;
    mUserName = userName;
  }
  public String getDefineWord(){
    return mDefineWord;
  }
  public String getUserName(){
    return mUserName;
  }
}
