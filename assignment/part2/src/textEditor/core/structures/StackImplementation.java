package textEditor.core.structures;

import java.util.EmptyStackException;

import textEditor.util.PropertiesLoader;
import java.util.LinkedList;


public class StackImplementation <E> extends AbstractStack<E>{

protected int maxUndos;
protected LinkedList<E> list ;

 public StackImplementation(){
  maxUndos = 10;
  list = new LinkedList<E>();
}

public void push(E e){
  if(size()<maxUndos){
  list.addLast(e);}
  else{
    while(size()>=maxUndos){
    list.remove();}
    list.addLast(e);
  }
}

public  E top() throws EmptyStackException{
  try{
    return list.getLast();
  }catch(EmptyStackException e){
    System.out.println("Empty stack!");
  }
  return list.getLast();
}

public  E pop() throws EmptyStackException{
  try{
    return list.removeLast();
  }catch(EmptyStackException e){
    System.out.println("Empty stack!");

  }
  return list.removeLast();
}

public  int size(){
  return list.size();
}

public  boolean isEmpty(){
  return list.size()==0;
}


    public void display()
    {
        for(int i=0;i<list.size();i++){
          System.out.println(list.get(i));
        }
    }





public static void main(String[] args)
    {
        // create Object of Implementing class
        StackImplementation obj = new StackImplementation();
        // insert Stack value
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);
          obj.push(45);
            obj.push(84);
              obj.push(4);
                obj.push(24);
                  obj.push(789);
                  obj.push(1);
                      obj.display();
                      System.out.println("________");
                      obj.push(111);
                        obj.push(23);
                          obj.push(0);


      
        obj.display();

        // print Top element of Stack
        System.out.printf("\nTop element is %d\n", obj.top());

        obj.pop();
        obj.pop();

        obj.display();

        System.out.printf("\nTop element is %d\n", obj.top());
    }

}
