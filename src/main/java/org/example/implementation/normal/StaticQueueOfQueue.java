package org.example.implementation.normal;

import org.example.definition.Queue;
import org.example.definition.QueueOfQueue;

public class StaticQueueOfQueue implements QueueOfQueue {
    private final QueueOfQueue[] queuesArray;
    private int count;
    private int n; // tamaño de cada cola y cantidad de colas dentro de la cola

    public StaticQueueOfQueue(int n) {
        this.queuesArray = new QueueOfQueue[n];
        this.count = 0;
        this.n = n;
    }

    @Override
    public void addQueue(QueueOfQueue queue) {
        if (count == n) {
            throw new RuntimeException("Cantidad máxima de elementos alcanzada");
        }
        if (getSize() != n) {
            throw new RuntimeException("Cada cola debe tener exactamente " + n + " elementos.");
        }
        queuesArray[count] = queue;
        count++;
    }

    @Override
    public void removeQueue() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            queuesArray[i] = queuesArray[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public QueueOfQueue getFirstQueue() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return queuesArray[0];
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public int getN() {
        return n;
    }

    @Override
    public QueueOfQueue concatenate(QueueOfQueue... queue) {
        return null;
    }
}
