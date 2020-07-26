import com.sun.org.apache.bcel.internal.generic.NEW;

class A {
  private String [] strings;

  public A () {
    strings = new String[]{"first", "second"};
  }

  public String [] getStrings() {
    return strings.clone();
  }

  public void setStrings(String [] strings) {
    this.strings = strings.clone();
  }
  
  public static void main(String[] args) {
    System.out.println(new Object().equals(new Object()));
}
}