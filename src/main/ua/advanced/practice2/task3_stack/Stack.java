package main.ua.advanced.practice2.task3_stack;

import main.ua.advanced.practice2.Container;

public interface Stack extends Container {

    // Pushes the specified element onto the top.
    void push(Object element);

    // Removes and returns the top element.
    Object pop();

    // Returns the top element.
    Object top();
}