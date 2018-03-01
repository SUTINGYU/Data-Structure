import java.util.NoSuchElementException;

/**
 * Testing code for a circular array deque implementation.  If all tests pass,
 * nothing is printed. If a test fails, a message is printed to narrow down the
 * cause of the errors.  You are welcome (and encouraged!) to modify this code
 * to suit your needs.
 * @author Anna Rafferty
 * @author Jed Yang
 */
public class DequeTester
{

   /**
    * main takes no command line arguments and goes through a series of tests
    * for addFirst, addLast, getFirst, getLast, clear, and isEmpty. How well it
    * tests is partially dependent on your initial array size.
    * 
    * I encourage you to read through the code to understand what it test, and
    * to modify maxValue to make sure you're hitting relevant possible edge
    * cases in your implementation. Draw out the deque on paper to make sure
    * you understand what's happening. You can add a toString implementation to
    * your CircularArrayDeque if you want it to print nicely. This may help
    * with debugging.
    */
   public static void main(String[] args)
   {
      Deque<Integer> deque = new CircularArrayDeque<Integer>();

      // First, try adding some items to the front of the deque
      int maxValue = 20;
      for (int i = 0; i < maxValue; i++)
      {
         deque.addFirst(i);
         if (deque.getFirst() != i)
         {
            System.out.println("Just added " + i + " to front, but get is " + deque.getFirst());
         }
         if (deque.getLast() != 0)
         {
            System.out.println("0 should be back of queue, but it's " + deque.getLast());
         }
      }

      // Now, clear it and make sure it's empty
      deque.clear();
      if (!deque.isEmpty())
      {
         System.out.println("isEmpty() returns false directly after deque is cleared.");
      }
      // We'll try clearing one more time since we should be able to clear an empty deque
      deque.clear();
      if (!deque.isEmpty())
      {
         System.out.println("isEmpty() returns false directly after deque is cleared.");
      }

      // We'll also check that we throw the right exceptions for an empty deque.
      try
      {
         deque.getFirst();
         System.out.println("Called getFirst on an empty stack, but no exception was thrown");
      }
      catch(NoSuchElementException e)
      {
         ;// Nothing to do - we want an exception when geting an empty stack
      }

      try
      {
         deque.getLast();
         System.out.println("Called getLast on an empty stack, but no exception was thrown");
      }
      catch(NoSuchElementException e)
      {
         ;// Nothing to do - we want an exception when geting an empty stack
      }

      try
      {
         deque.removeFirst();
         System.out.println("Called removeFirst on an empty stack, but no exception was thrown");
      }
      catch(NoSuchElementException e)
      {
         ;// Nothing to do - we want an exception when geting an empty stack
      }

      try
      {
         deque.removeLast();
         System.out.println("Called removeLast on an empty stack, but no exception was thrown");
      }
      catch(NoSuchElementException e)
      {
         ;// Nothing to do - we want an exception when geting an empty stack
      }

      // Now, we'll start again, this time adding to the back
      deque = new CircularArrayDeque<Integer>();
      for (int i = 0; i < maxValue; i++)
      {
         deque.addLast(i);
         if (deque.getLast() != i)
         {
            System.out.println("Just added " + i + " to back, but get is " + deque.getLast());
         }
         if (deque.getFirst() != 0)
         {
            System.out.println("0 should be front of queue, but it's " + deque.getFirst());
         }
      }

      // Now we'll remove everything from the front, checking that getFirst and
      // getLast return the correct values.
      for (int i = 0; i < maxValue; i++)
      {
         int removed = deque.removeFirst();
         if (removed != i)
         {
            System.out.println("Just removed " + i + " from front, but actual removed value is " + removed);
         }
         if (i != maxValue - 1)
         {
            if (deque.getFirst() != i+1)
            {
               System.out.println((i+1) + " should be front of queue, but it's " + deque.getFirst());
            }
            if (deque.getLast() != maxValue - 1)
            {
               System.out.println((maxValue-1) + " should be back of queue, but it's " + deque.getLast());
            }
         }
      }

      // Deque should be empty
      if (!deque.isEmpty())
      {
         System.out.println("Everything removed but deque not empty - get front is " + deque.getFirst());
      }

      // Now intersperse some adding and removing from front and back
      // We'll add 0, -1, ... , -5 to back, then 1, ..., 5 to front, then -6 and -7 to back.
      int valuesInQueue = 0;// Keeping a count of the values in the queue so we know how many we should remove
      for (int i = 0; i > -6; i--)
      {
         deque.addLast(i);
         valuesInQueue++;
         if (deque.getLast() != i)
         {
            System.out.println("Just added " + i + " to back, but get is " + deque.getLast());
         }
         if (deque.getFirst() != 0)
         {
            System.out.println("0 should be front of queue, but it's " + deque.getFirst());
         }
      }

      for (int i = 1; i < 6; i++)
      {
         deque.addFirst(i);
         valuesInQueue++;
         if (deque.getLast() != -5)
         {
            System.out.println("Last should remain at -5 but get is " + deque.getLast());
         }
         if (deque.getFirst() != i)
         {
            System.out.println("Just added " + i + " to front, but get is " +deque.getFirst());
         }
      }

      for (int i = -6; i >= -7; i--)
      {
         deque.addLast(i);
         valuesInQueue++;
         if (deque.getLast() != i)
         {
            System.out.println("Just added " + i + " to back, but get is " + deque.getLast());
         }
         if (deque.getFirst() != 5)
         {
            System.out.println("5 should be front of queue, but it's " + deque.getFirst());
         }
      }

      // Now we'll try removing, alternating between front and back
      int backValue = -7;
      int frontValue = 5;
      while (valuesInQueue >= 2)  // We remove two values every round
      {
         System.out.println("valuesInQueue: " + valuesInQueue);
         int removed = deque.removeLast();
         valuesInQueue--;
         if (removed != backValue)
         {
            System.out.println("Should have removed " + backValue + " but actual removed value is " + removed);
         }
         backValue++;
         if (deque.getLast() != backValue)
         {
            System.out.println("Last should be " + backValue + " but is " + deque.getLast());
         }
         valuesInQueue--;
         removed = deque.removeFirst();
         if (removed != frontValue)
         {
            System.out.println("Should have removed " + frontValue + " but actual removed value is " + removed);
         }
         frontValue--;
         if (deque.getLast() != backValue)
         {
            System.out.println("Last should be " + backValue + " but is " + deque.getLast());
         }
         if (deque.getFirst() != frontValue)
         {
            System.out.println("First should be " + frontValue + " but is " + deque.getFirst());
         }
      }
   }
}
