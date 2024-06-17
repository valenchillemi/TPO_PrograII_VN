package org.example.implementation.normal;

import org.example.definition.Queue;

public class StaticQueue implements Queue {

    private final int MAX = 10000;
    private final int[] array;
    private int count;

    public StaticQueue() {
        array = new int[MAX];
        count = 0;
    }

    @Override
    public void add(int a) {
        if(count == MAX) {
            throw new RuntimeException("No se puede agregar el elemento");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getFirst() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return array[0];
    }

}
