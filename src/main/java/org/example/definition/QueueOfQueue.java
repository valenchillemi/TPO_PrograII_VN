package org.example.definition;

public interface QueueOfQueue {

    /**
     * Postcondición: Acola una cola en la cola de colas.
     * @param queue a acolar
     */
    void addQueue(QueueOfQueue queue);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita la primer cola).
     */
    void removeQueue();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     *
     * @return Devuelve la primer cola.
     */
    QueueOfQueue getFirstQueue();

    /**
     *
     * @return el tamaño de la cola de colas
     */
    int getSize();

    /**
     *
     * @return el tamaño de cada cola de la cola
     */
    int getN();

    QueueOfQueue concatenate(QueueOfQueue... queue);

}
