public class Stack<T>
{
    private T[] stack = (T[]) new Object[1];
    private int currentWriteAddress = 0;

    public void push(T value)
    {
        if(currentWriteAddress>=stack.length)
        {
            resize();
        }
        stack[currentWriteAddress]=value;
        currentWriteAddress++;
    }

    public T pop()
    {
        if(currentWriteAddress==0)
        {
            throw new RuntimeException("Cannot pop from empty stack");
        }

        currentWriteAddress--;

        T returnValue = stack[currentWriteAddress];
        stack[currentWriteAddress]=null;

        return returnValue;
    }

    private void resize()
    {
        T[] newStack = (T[]) new Object[stack.length*2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack=newStack;
    }
}
