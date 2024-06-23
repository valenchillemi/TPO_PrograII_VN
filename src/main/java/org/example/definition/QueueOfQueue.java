package org.example.definition;

import org.example.implementation.normal.StaticQueueOfQueue;

public interface QueueOfQueue {

    /**
     * Postcondición: Acola una cola en la cola de colas.
     * @param queue a acolar
     */
    void addQueue(Queue queue);

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
    Queue getFirstQueue();

    /**
     *
     * @return el tamaño de la cola de colas
     */
    int getLenght();

    /**
     *
     * @param queue cola/s a concatenar
     * @return nueva instancia de cola de colas concatenando las que ingresaron por parámetro
     */
    QueueOfQueue concatenate(int lenght, QueueOfQueue... queue);

    /**
     *
     * @param queueOfQueue
     * @return una cola con todos los elementos de las colas de la cola de colas
     */
    Queue flat (QueueOfQueue queueOfQueue);

    /**
     *
     * @param queueOfQueue
     * @return cola de colas invertida (también sus colas internas invertidas)
     */
    QueueOfQueue reverseWithDepth (QueueOfQueue queueOfQueue);

}
