import java.util.NoSuchElementException;

/**
Author1: Charlie Broadbent
Author2: Yuting Su
Date: Feb 21 2018
It is a class that implements Deque interface in order to creat a circular array deque.
*/

public class CircularArrayDeque<E> implements Deque<E>
{
    private E front;
    private E back;
    private int capacity;
    private int length;
    private int frontIndex;
    private int backIndex;
    private E[] items;
    
    //Class constructor
    public CircularArrayDeque()
    {
        @SuppressWarnings("unchecked")
        E[] tmp = (E[])new Object[10];
        items = tmp;
        this.front = null;
        this.back = null;
        this.length = 0;
        this.frontIndex = 0;
        this.backIndex = 0;
        this.capacity = 10;
    }

    /** Doubles the array in order to add more items.
     ** Put the item that is added to the "0" slot.
   */
    private void doubleArray()
    {
        if (frontIndex == (backIndex + 2) % capacity)
            {
                E[] old = items;
                @SuppressWarnings("unchecked")
                E[] newArray = (E[]) new Object[2 * capacity];
                items = newArray;
                for (int i = 0; i < length; i++)
                    {
                        items[i + 1] = old[frontIndex];
                        frontIndex = (frontIndex + 1) % (capacity);
                    }
                frontIndex = 0;
                backIndex = length;
                capacity = 2 * capacity;
            }
    }
    
    /** Doubles the array in order to add more items.
     ** Put the item that is added to the end of the array.
   */
    private void doubleArrayLast()
    {
        if (frontIndex == (backIndex + 2) % capacity)
            {
                E[] old = items;
                @SuppressWarnings("unchecked")
                E[] newArray = (E[]) new Object[2 * capacity];
                items = newArray;
                for (int i = 0; i < length; i++)
                    {
                        items[i] = old[frontIndex];
                        frontIndex = (frontIndex + 1) % (capacity);
                    }
                frontIndex = 0;
                backIndex = length - 1;
                capacity = 2 * capacity;
            }
    }
    
    /** Inserts the specified element at the front of this deque.
    @param item the element to add
   */
   public void addFirst(E item)
    {
        if (length == 0)
            {
                front = item;
                back = item;    
                items[frontIndex] = item;
                length++;
            }
        else if (length == capacity - 1)
            {
                doubleArray();
                front = item;
                items[frontIndex] = item;
                length++;
            }
        else
            {
                frontIndex = (frontIndex + capacity - 1) % capacity;
                front = item;
                items[frontIndex] = item;
                length++;
            }
    }
   
   /** Inserts the specified element at the back of this deque.
       @param item the element to add
   */
   public void addLast(E item)
    {
        if (length == 0)
            {
                front = item;
                back = item;
                items[backIndex] = item;
                length++;
            }
        else if (length == capacity - 1)
            {
                doubleArrayLast();
                backIndex = (backIndex + 1) % capacity;
                back = item;
                items[backIndex] = item;
                length++;
            }
        else
            {
                backIndex = (backIndex + 1) % capacity;
                back = item;
                items[backIndex] = item;
                length++;
            }
    }
    
   
   /** Retrieves and removes the first element of this deque.
       @return the first element of this deque
       @throws NoSuchElementException if this deque is empty
   */
   public E removeFirst()
    {
        if(length == 0)
        {
            throw new NoSuchElementException("The queue is empty!");
        }
        else if(length == 1)
        {
            E temp = front;
            items[frontIndex] = null;
            front = null;
            back = null;
            length--;
            return temp;
        }
        else if(length == 2)
        {
            E temp = front;
            items[frontIndex] = null;
            frontIndex = (frontIndex + 1) % capacity;
            front = back;
            length--;
            return temp;
        }
        else
        {
            E temp = front;
            items[frontIndex] = null;
            frontIndex = (frontIndex + 1) % capacity;
            front = items[frontIndex];
            length--;
            return temp;
        }
    }
   
   /** Retrieves and removes the last element of this deque.
       @return the last element of this deque
       @throws NoSuchElementException if this deque is empty
   */
   public E removeLast()
    {
        if(length == 0)
        {
            throw new NoSuchElementException("The queue is empty!");
        }
        else if(length == 1)
        {
            E temp = back;
            items[backIndex] = null;
            front = null;
            back = null;
            length--;
            return temp;
        }
        else if(length == 2)
        {
            E temp = back;
            items[backIndex] = null;
            backIndex = ((backIndex + capacity) - 1) % capacity;
            back = items[backIndex];
            length--;
            return temp;
        }
        else
        {
            E temp = back;
            items[backIndex] = null;
            backIndex = ((backIndex + capacity) - 1) % capacity;
            back = items[backIndex];
            length--;
            return temp;
        }
    }
   
   /** Retrieves, but does not remove, the first element of this deque.
       @return the first element of this deque
       @throws NoSuchElementException if this deque is empty
   */
   public E getFirst()
    {
        if (front == null)
        {
            throw new NoSuchElementException("The queue is empty!");
        }
        return front;
    }
   
   /** Retrieves, but does not remove, the last element of this deque.
       @return the last element of this deque
       @throws NoSuchElementException if this deque is empty
   */
   public E getLast()
    {
        if (back == null)
        {
            throw new NoSuchElementException("The queue is empty!");
        }
        return back;
    }
   
   /** Returns true if this deque is empty. 
       @return true if this deque is empty; false otherwise.
   */
   public boolean isEmpty()
    {
        if (length == 0)
        {
            return true;
        }
        return false;
    }
   
   /** Removes all items from this deque. */
   public void clear()
    {
        capacity = 10;
        @SuppressWarnings("unchecked")
        E[] tmp1 = (E[])new Object[10];
        items = tmp1;
        front = null;
        back = null;
        frontIndex = 0;
        backIndex = 0;
        length = 0;
    }
}
