import java.lang.UnsupportedOperationException;

/**
 * The class that simulates function calls using a stack.
 * @author Yingqi Ding, 2018-05-06
 */

public class CallStack extends CircularArrayDeque<Method>
{
   private SimulationComponent comp;

   public CallStack(SimulationComponent comp)
   {
      this.comp = comp;
   }

   /** The method should not be implemented.
       @throws UnsupportedOperationException
    */
   public void addFirst(Method item)
   {
      throw new UnsupportedOperationException();
   }

   /** The method should not be implemented.
       @throws UnsupportedOperationException
    */
   public Method removeFirst()
   {
      throw new UnsupportedOperationException();
   }

   /** The method should not be implemented.
       @throws UnsupportedOperationException
    */
   public Method getFirst()
   {
      throw new UnsupportedOperationException();
   }

   /** Inserts the specified element at the back of this stack.
       @param item the method to add
    */
   public void addLast(Method item)
   {
      super.addLast(item);
      comp.addMethodToGraphicalStack(item);
   }

   /** Retrieves and removes the last method of this stack.
       @return the last method of this stack
       @throws NoSuchElementException if this stack is empty
    */
   public Method removeLast()
   {
      Method item = super.removeLast();
      comp.removeMethodFromGraphicalStack(item);
      return item;
   }
}