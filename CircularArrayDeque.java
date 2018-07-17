import java.util.NoSuchElementException;

/**
 * An implementation for the Deque ADT.
 * @param <E> The type of elements held in this deque.
 * @author Yingqi Ding, 2018-05-06
 */

public class CircularArrayDeque<E> implements Deque<E>
{
   private E[] items;
   private E first;
   private E last;
   private int firstIndex;
   private int lastIndex;
   private int count;
   private int capacity;

   /** Constructor.
    */
   public CircularArrayDeque()
   {
      @SuppressWarnings("unchecked")
      E[] tmp = (E[]) new Object[10];
      items = tmp;
      first = null;
      last = null;
      firstIndex = 0;
      lastIndex = 0;
      count = 0;
      capacity = 10;
   }

   /** Inserts the specified element at the front of this deque.
       @param item the element to add
    */
   public void addFirst(E item)
   {
      ensureCapacity();
      first = item;
      if (count == 0)
      {
         last = item;
      }
      else
      {
         firstIndex = (firstIndex - 1 + capacity) % capacity;
      }
      items[firstIndex] = item;
      count++;
   }
   
   /** Inserts the specified element at the back of this deque.
       @param item the element to add
    */
   public void addLast(E item)
   {
      ensureCapacity();
      last = item;
      if (count == 0)
      {
         first = item;
      }
      else
      {
         lastIndex = (lastIndex + 1) % capacity;
      }
      items[lastIndex] = item;
      count++;
   }
   
   /** Retrieves and removes the first element of this deque.
       @return the first element of this deque
       @throws NoSuchElementException if this deque is empty
    */
   public E removeFirst()
   {
      if (count == 0)
      {
         throw new NoSuchElementException("Can't remove the front. The deque is empty.");
      }

      E temp = first;
      items[firstIndex] = null;
      if (count > 1)
      {
         firstIndex = (firstIndex + 1) % capacity;
         first = items[firstIndex];
      }
      count--;
      return temp;
   }
   
   /** Retrieves and removes the last element of this deque.
       @return the last element of this deque
       @throws NoSuchElementException if this deque is empty
    */
   public E removeLast()
   {
      if (count == 0)
      {
         throw new NoSuchElementException("Can't remove the back. The deque is empty.");
      }

      E temp = last;
      items[lastIndex] = null;
      if (count > 1)
      {
         lastIndex = (lastIndex - 1 + capacity) % capacity;
         last = items[lastIndex];
      }
      count--;
      return temp;
   }

   /** Retrieves, but does not remove, the first element of this deque.
       @return the first element of this deque
       @throws NoSuchElementException if this deque is empty
    */
   public E getFirst()
   {
      if (count == 0)
      {
         throw new NoSuchElementException("Can't get the front. The deque is empty.");
      }
      return first;
   }
   
   /** Retrieves, but does not remove, the last element of this deque.
       @return the last element of this deque
       @throws NoSuchElementException if this deque is empty
    */
   public E getLast()
   {
      if (count == 0)
      {
         throw new NoSuchElementException("Can't get the back. The deque is empty.");
      }
      return last;
   }
   
   /** Returns true if this deque is empty. 
       @return true if this deque is empty; false otherwise.
    */
   public boolean isEmpty()
   {
      return count == 0;
   }
   
   /** Removes all items from this deque. */
   public void clear()
   {
      @SuppressWarnings("unchecked")
      E[] newTmp = (E[]) new Object[10];
      items = newTmp;
      first = null;
      last = null;
      firstIndex = 0;
      lastIndex = 0;
      count = 0;
      capacity = 10;
   }

   private void ensureCapacity()
   {
      if (firstIndex == (lastIndex + 2) % capacity)
      {
         @SuppressWarnings("unchecked")
         E[] newItems = (E[]) new Object[capacity * 2];
         for (int i = 0; i < count; i++)
         {
            newItems[i] = items[firstIndex];
            firstIndex = (firstIndex + 1) % capacity;
         }
         items = newItems;
         capacity *= 2;
         firstIndex = 0;
         lastIndex = count - 1;
      }
   }
}