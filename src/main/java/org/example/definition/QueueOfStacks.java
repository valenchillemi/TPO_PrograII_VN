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
     * @return la variable count con un getter
     */
    int getSize();

    /**
     *
     * @return la variable n con un getter. Es el tamaño de cada pila para asegurar nxn (matriz).
     */
    int getN();
}
