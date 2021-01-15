package textEditor.core.structures;
//import java.util.Comparator;
//import java.util.*;


public class NewStructure  {


private int size;
private final int DefaultCapacity=200000;
String  [] array;

public NewStructure(){
  array=new String [DefaultCapacity];
  size=0;

}
public int size(){
  return size;
}
public boolean isEmpty(){
  return size==0;
}


public void add(String element){
  if(array.length<=size){
    String[]tmp=new String[size*DefaultCapacity];
    for(int i=0;i<array.length;i++){
      tmp[i]=array[i];
    }
    array=tmp;
  }
  /*int i=0;
  while(array[i]!=null){
    i++;
  }
  array[i]=element;
  size++;*/
   array[size]=element;
   size++;


  /* for (int i = 0; i < size; i++)
        {
            for (int j = i + 1; j < size; j++) {

                if (array[i].compareTo(array[j])>0)
                {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }*/
}
public String remove(int index){
  if(index<0 || index>size){
    throw new IndexOutOfBoundsException();
  }
  String saved= (String)array[index];
  array[index]=null;
  for(int i =index;i<size-1;i++){
    array[i]=array[i+1];
  }
  array[size-1]=null;
  size--;
  return saved;
}
public String get(int index){
  if(index<0 || index>size){
    throw new IndexOutOfBoundsException();
  }
  return (String)array[index];
}
public int binarySearch(String array[],String element){

int low=0;
int high=size-1;
int mid=(low+high)/2 ;

while(low<=high){
  if(array[mid].equals(element)){
  return mid  ;
  }else{
    if(array[mid].compareTo(element)<0){
      low=mid+1;}
    else{
    high=mid-1;}
  }
   mid=(low+high)/2;
}
return -1;

}
public boolean contains(String element){
  /*boolean result=false;
  for(int i=0;i<size;i++){
    if(array[i].equals(element)){
      return true;
    }
  }
  return result;*/
if(binarySearch(array, element)==-1){
  return false;
}
else{
  return true;
}

}
public void set(int index,String elem){
  if(index<0 || index>size){
    throw new IndexOutOfBoundsException();
  }
  array[index]=elem;
}
public static void main(String[] args){
		NewStructure  newList = new NewStructure();

		newList.add("b");
		newList.add("d");
		newList.add("a");
		newList.add("c");

		newList.add("z");

    System.out.println(newList.get(0));
    System.out.println(newList.get(1));
    System.out.println(newList.get(2));
    System.out.println(newList.get(3));


		System.out.println(newList.get(4));
		System.out.println(newList.remove(3));
    System.out.println(newList.get(3));
		System.out.println(newList.contains("q"));
    System.out.println(newList.contains("z"));
    System.out.println(newList.contains("d"));
    System.out.println(newList.size());
    System.out.println(newList.isEmpty());
		}


}
