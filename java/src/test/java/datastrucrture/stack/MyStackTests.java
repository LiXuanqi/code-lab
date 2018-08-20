package datastrucrture.stack;

import datastructure.stack.MyStack;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStackTests {

    @Test
    public void emptyTest() {
        MyStack stack = new MyStack();
        assertEquals(true, stack.empty());
        stack.push(1);
        assertEquals(false, stack.empty());
        stack.pop();
        assertEquals(true, stack.empty());
    }

    @Test
    public void peekTest() {
        MyStack stack = new MyStack();
        assertEquals(null, stack.peek());
        stack.push(1);
        assertEquals(new Integer(1), stack.peek());
    }

    @Test
    public void pushTest() {
        MyStack stack = new MyStack();
        stack.push(1);
        assertEquals(new Integer(1), stack.peek());
        stack.push(2);
        assertEquals(new Integer(2), stack.peek());
    }

    @Test
    public void popTest() {
        MyStack stack = new MyStack();
        assertEquals(null, stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(new Integer(3), stack.pop());
        assertEquals(new Integer(2), stack.pop());
        assertEquals(new Integer(1), stack.pop());
    }
}
