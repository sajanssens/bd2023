package javabd.slides.h11_specialclasses;


import org.w3c.dom.Node;

import java.util.Iterator;

public class LocalClasses {

    public Iterator<Integer> iterator() {
        class LinkedListIterator implements Iterator<Integer> {
            private Node currentNode = null;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Integer next() {
                Integer value = Integer.valueOf(currentNode.getNodeValue());
                currentNode = currentNode.getNextSibling();
                return value;
            }

            @Override
            public void remove() {
            }
        }
        return new LinkedListIterator();
    }

    public static void main(String[] args) {
        Iterator<Integer> iterator = new LocalClasses().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
