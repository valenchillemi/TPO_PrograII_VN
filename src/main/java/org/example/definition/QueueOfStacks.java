package org.example.definition;

public interface QueueOfStacks {

    /**
     * Postcondición: Acola una pila en la cola de pilas
     * @param stack a acolar
     */
    void add(Stack stack);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita la primer pila).
     */
    void removeStack();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     *
     * @return Devuelve el primer stack.
     */
    Stack getFirstSk();

    /**
     *
     * @return el tamaño de la cola de pilas
     */
    int getSize();

    /**
     *
     * @return el tamaño de cada pila
     */
    int getN();
}
