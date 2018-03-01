import java.lang.UnsupportedOperationException;

/**
Author1: Charlie Broadbent
Author2: Yuting Su
Date: Feb 21 2018
It is a class that extends CircularArrayDeque superclass to act as a stack that stores methods.
*/
public class CallStack extends CircularArrayDeque<Method>
{
    private SimulationComponent sim;
    
    // Class constructor
    public CallStack(SimulationComponent sim)
    {
        this.sim = sim;
    }
    
    //Overrides to prevent this method to be used.
    //@throws UnsupportedOperationException if this method is called.
    public Method getFirst()
    {
        throw new UnsupportedOperationException();
    }
    
    //Overrides to prevent this method to be used.
    //@param item
    //@throws UnsupportedOperationException if this method is called.
    public void addFirst(Method item)
    {
        throw new UnsupportedOperationException();
    }
    
    //Overrides to prevent this method to be used.
    //@throws UnsupportedOperationException if this method is called.
    public Method removeFirst()
    {
        throw new UnsupportedOperationException();
    }
    
    //Overrides to addLast normally as well as add the item to GraphicalStack.
    //@param item
    public void addLast(Method item)
    {
        super.addLast(item);
        sim.addMethodToGraphicalStack(item);
    }
    
    //Overrides to removeLast normally as well as remove the item to GraphicalStack.
    //@ returns the method that is removed.
    public Method removeLast()
    {
        Method removed = super.removeLast();
        sim.removeMethodFromGraphicalStack(removed);
        return removed;
    }
}