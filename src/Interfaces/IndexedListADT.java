package Interfaces;

public interface IndexedListADT<T> extends ListADT<T>{
   public void add(int index, T element);
   public void set(int index, T elem);
   public void add(T element);
   public T get(int index);
   public int indexOf(T element);
   public T remove(int index);
}
