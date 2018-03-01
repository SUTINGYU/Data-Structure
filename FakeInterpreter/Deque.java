import java.util.NoSuchElementException;
/** An interface for the Deque ADT, abridged from java.util.Deque.
    @param <E> The type of elements held in this deque.
    @author Jed Yang
*/
public interface Deque<E>
{
   /** Inserts the specified element at the front of this deque.
       @param item the element to add
   */
   public void addFirst(E item);
   
   /** Inserts the specified element at the back of this deque.
       @param item the element to add
   */
   public void addLast(E item);
   
   /** Retrieves and removes the first element of this deque.
       @return the first element of this deque
       @throws NoSuchElementException if this deque is empty
   */
   public E removeFirst();
   
   /** Retrieves and removes the last element of this deque.
       @return the last element of this deque
       @throws NoSuchElementException if this deque is empty
   */
   public E removeLast();
   
   /** Retrieves, but does not remove, the first element of this deque.
       @return the first element of this deque
       @throws NoSuchElementException if this deque is empty
   */
   public E getFirst();
   
   /** Retrieves, but does not remove, the last element of this deque.
       @return the last element of this deque
       @throws NoSuchElementException if this deque is empty
   */
   public E getLast();
   
   /** Returns true if this deque is empty. 
       @return true if this deque is empty; false otherwise.
   */
   public boolean isEmpty();
   
   /** Removes all items from this deque. */
   public void clear();
}
