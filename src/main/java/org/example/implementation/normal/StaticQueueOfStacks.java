package org.example.implementation.normal;

import org.example.definition.QueueOfStacks;
import org.example.definition.Stack;

public class StaticQueueOfStacks implements QueueOfStacks {
    private final Stack[] skArray;
    private int count;
    private int n; // tamaño de cada pila y cantidad de pilas dentro de la cola (para simetría nxn)

    public StaticQueueOfStacks(int n) {
        this.skArray = new StaticStack[n];
        this.count = 0;
        this.n = n;
    }

    @Override
    public void add(Stack stack) {
        if (count == n) {
            throw new RuntimeException("Cantidad máxima de elementos alcanzada");
        }
        if (stack.size() != n) {
            throw new RuntimeException("Cada pila debe tener exactamente " + n + " elementos.");
        }
        skArray[count] = stack;
        count++;
    }

    @Override
    public void removeStack() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            skArray[i] = skArray[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Stack getFirstSk() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return skArray[0];
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public int getN() {
        return n;
    }
}
