//*******************************************************
// Class: AssignmentTwo
// Author: Hugh Seeley
// Date Created: 20241014
// Modified:20241014
//
// Attributes:  -E() elements
//              -stackSize int
//              -stackCapacity int final static
//
// Methods:     +Constructor GenericStack()
//              +Constructor GenericStack(int)
//
//              +getSize() : Int - returns stack size
//              +peek() : Element - returns element at stack size - 1
//              +push() : Void - pushes object onto stack, resizing if needed
//              +pop() : Element - pulls an element out of the stack, resolves memory leaks, exception if no elements in stack
//
//********************************************************


//public class GenericStack<E> {
//    private java.util.ArrayList<E> list = new java.util.ArrayList<>();
//
//    public int getSize() {
//        return list.size();
//    }
//
//    public E peek() {
//        return list.get(getSize() - 1);
//    }
//
//    public void push(E o) {
//        list.add(o);
//    }
//
//    public E pop() {
//        E o = list.get(getSize() - 1);
//        list.remove(getSize() - 1);
//        return o;
//    }
//
//    public boolean isEmpty() {
//        return list.isEmpty();
//    }
//
//    @Override
//    public String toString() {
//        return "stack: " + list.toString();
//    }
//}

@SuppressWarnings("unchecked")
public class GenericStack<E> {
    private E[] elements;
    private int stackSize;
    private static final int stackCapacity = 10;

    //Stack with default capacity
    public GenericStack() {
        elements = (E[]) new Object[stackCapacity];
        stackSize = 0;
    }

    //Stack with specified capacity
    public GenericStack(int capacity) {
        elements = (E[]) new Object[capacity];
        stackSize = 0;
    }

    public int getSize() {
        return stackSize;
    }

    public E peek() {
        return elements[stackSize - 1];
    }

    public void push(E o) {
        if (stackSize == elements.length) {
            resize();
        }
        elements[stackSize++] = o;
    }

    public E pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
        E o = elements[--stackSize];
            elements[stackSize] = null; // Avoid memory leaks
        return o;
    }

    public boolean isEmpty() {
        return stackSize == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newElements = (E[]) new Object[stackCapacity * 2];
        for (int i = 0; i < stackSize; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("stack: [");
        for (int i = 0; i < stackSize; i++) {
            result.append(elements[i]);
            if (i < stackSize - 1) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }

}
