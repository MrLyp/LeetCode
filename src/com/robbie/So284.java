package com.robbie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class So284 {
    static class PeekingIterator implements Iterator<Integer> {

        private ArrayList<Integer> arrayList = new ArrayList<>();

        private int index = 0;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            while (iterator.hasNext()) {
                arrayList.add(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return arrayList.get(index);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return arrayList.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < arrayList.size();
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator iterator = new PeekingIterator(list.iterator());
        System.out.println(iterator.next());
        System.out.println(iterator.peek());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
