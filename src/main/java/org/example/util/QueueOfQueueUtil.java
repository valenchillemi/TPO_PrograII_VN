package org.example.util;

import org.example.definition.QueueOfQueue;
import org.example.implementation.normal.StaticQueueOfQueue;

public class QueueOfQueueUtil {

    public static QueueOfQueue copyQueueOfQueue(QueueOfQueue qoq) {
        QueueOfQueue original = new StaticQueueOfQueue(qoq.getLenght());
        QueueOfQueue copy = new StaticQueueOfQueue(qoq.getLenght());

        while (!qoq.isEmpty()) {
            copy.addQueue(qoq.getFirstQueue());  // generamos una copia de la orginal y una copia auxiliar
            original.addQueue(qoq.getFirstQueue());
            qoq.removeQueue();
        }
        while (!original.isEmpty()) {
            qoq.addQueue(original.getFirstQueue()); // volvemos a completar la cola original que quedo vacía
            original.removeQueue();
        }

        return copy; // devolvemos una copia de la cola de colas original
    }
}
