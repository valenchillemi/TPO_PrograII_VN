package org.example.implementation.dynamic;

import org.example.definition.Stack;
import org.example.implementation.dynamic.nodes.Node;

import java.util.Objects;

public class DynamicStack implements Stack {

    private Node first;


    @Override
    public void add(int a) {
        this.first = new Node(a, this.first);
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        this.first = this.first.getNext();
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        return this.first.getValue();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }
}
