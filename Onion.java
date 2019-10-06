//Alpha version
import java.util.Arrays;

public class Onion{

  byte[] binary;

  public Onion(byte[] binary) throws Exception{

    if((binary.length%2 == 0) || !(isBinary(binary))){
      throw new Exception("Input must be binary and odd in length.");
    }
    else{
      //ToDo
      this.binary = onionRecusive(binary);
    }

  }

  public byte[] stringToByte(String str){

    byte[] temp= new byte[str.length()];
    for(int pos=0; pos>str.length();pos++){
      temp[pos]= (byte)str.charAt(pos);
    }
    return temp;
  }

  public static int getFirst(int num){
    while(num > 1){
      num=num/10;
      System.out.println(num);
    }
    return num;
  }

  public byte[] getByteList(){
    return binary;
  }

public boolean isBinary(byte[] list) {
 boolean binary = true;
 int pos=-1;
 while(binary==true && pos<list.length-1){
   pos++;
   if(list[pos]>1){
     binary=false;
   }
 }
 return binary;
}

public byte flip(byte x){
  if(x == 1){
    return 0;
  }
    else {
      return 1;
    }
  }

//ToDo
public byte[] onionRecusive(byte[] list){
  //ToDo
  Onion temp;
  byte[] tempList = new byte[list.length];;
  int pos=1;
  if(list.length == 1){ //Base case
    tempList[0]=flip(list[0]);
  }
  else{
    try{
      temp = new Onion(Arrays.copyOfRange(list, 1, list.length-1));
      tempList[0]=flip(list[0]);
      for(byte x: temp.binary){
        tempList[pos] = x;
        pos++;
      }
      tempList[list.length-1]=flip(list[list.length-1]);
      System.out.println(" "+Arrays.toString(tempList));

    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  return tempList;
}

  public static void main(String[] args) {
    //testing
    byte[] list={0,1,0,1,0,1,0,1,0};
    byte[] list2;
    byte[] list3 = {0,1};
    list2 = Arrays.copyOfRange(list3, 1, list.length-1);
    System.out.println(Arrays.toString(list));
    System.out.println(Arrays.toString(list2));
    System.out.println(Arrays.toString(list3));
    System.out.println(Arrays.toString(list2));
    System.out.println("=====Testing Onion=====>>");
///**
    try{
      Onion x = new Onion(list);
      System.out.println(Arrays.toString(x.binary));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
//*/
  }
}
