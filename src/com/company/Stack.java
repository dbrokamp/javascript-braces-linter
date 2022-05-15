package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Stacks are LIFO - last in, first out
 * Temporary container for data
 * Abstract data structure - set of rules for interacting with built-in data structure
 * Built-in data structure used - ArrayList
 * T is generic type in Java
 *
 */
public class Stack<T> {

    private List<T> data;

    public Stack() {
        data = new ArrayList<>();
    }

    public void push(T element) {
        data.add(element);
    }

    public T pop() {
        if (data.isEmpty()) {
            return null;
        } else {
            return data.remove(data.size() - 1);
        }
    }

    public T peek() {
        if (data.isEmpty()) {
            return null;
        } else {
            return data.get(data.size() - 1);
        }

    }

}