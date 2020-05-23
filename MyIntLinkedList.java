package MyIntLinkedList;

import linkedList.DoubleLinkedListNode;

public class MyIntLinkedList {


    private DoubleLinkedListNode listHead;
    private DoubleLinkedListNode tail;
    private int size;

    public MyIntLinkedList() {
        listHead = new DoubleLinkedListNode();
        tail = new DoubleLinkedListNode();
        listHead.next(tail);
        tail.prev(listHead);
        this.size =0;
    }

    public MyIntLinkedList(MyIntLinkedList c) {
        this.listHead = c.getListHead();
        this.tail = c.getTail();
        this.size = c.getSize();
    }
    public DoubleLinkedListNode getListHead() {
        return listHead;
    }

    public int getSize() {
        return this.size;
    }

    private DoubleLinkedListNode getTail() {
        return this.tail;
    }

    public void add(int index, int element) {
        if (index < 0 || index > this.size)
            System.out.println("Index out of bound exception thrown");

        else {
            if (index == this.size)
                this.add(element);
            else {
                DoubleLinkedListNode it = new DoubleLinkedListNode(listHead.value(),this.getListHead(),null);

                DoubleLinkedListNode newElement = new DoubleLinkedListNode(element,null,this.tail);
                if (index == 0) {

                    newElement.next(listHead.next());
                    listHead.next().prev(newElement);
                    newElement.prev(null);
                    listHead.next(newElement);
                    this.size++;
                } else {
                    int counter = 0;
                    while(counter<index){
                        it = it.next();
                        counter++;
                    }

                    newElement.next(it);
                    newElement.prev(it.prev());
                    it.prev(newElement);
                  //  it.next().prev(newElement);
                    newElement.prev().next(newElement);
                   // it.next(newElement);
                    this.size++;
                }
            }
        }
    }

    public boolean add(int element) {
        DoubleLinkedListNode newElement = new DoubleLinkedListNode(element);
 //       DoubleLinkedListNode last = new DoubleLinkedListNode();
        if (this.size == 0) {
            listHead = newElement;
            this.tail = listHead;
            this.size++;
        } else {
            this.tail.next(newElement);
            this.tail = newElement;
            this.tail.prev(listHead.next());
            this.size++;
        }
//        newElement.value(element);
//        newElement.next(this.tail);
//        last = this.tail.prev();
//        last.next(newElement) ;
//        tail.prev(newElement);
//        this.size++;


        return true;
    }

    public int size() {

        return getSize();
    }

    public boolean contains(int e) {
        DoubleLinkedListNode it = listHead;

        while (it.next() != null) {
            if (it.value() == e) {
                return true;
            }
            it = it.next();
        }
        return false;
    }

    public int get(int index) {
        DoubleLinkedListNode it = listHead;
        if (index < 0 || index >= this.size) {
            System.out.println("Throwing index out of bound exception");
            return -1;
        }
            for (int i = 0; i < index; i++) {
                it = it.next();
            }
            return it.value();
        }


    public int indexOf(int e) {
        DoubleLinkedListNode it = listHead;
        int counter = 0;
        while (it != null) {

            if (it.value() == e) {
                return counter;
            }
            counter++;
            it = it.next();
        }

        return -1;
    }

    public int lastIndexOf(int e) {
        DoubleLinkedListNode it = this.tail;
        int counter=this.getSize();

        while (it != null) {
            counter--;
            if (it.value() == e)
                return counter;
            it = it.prev();
            it = it.next();
        }
        return -1;
    }

    public boolean remove(int e) {

        DoubleLinkedListNode it = listHead;

        if (this.getSize() == 0 || this.contains(e) == false) {
            return false;
        }
        int ind = this.indexOf(e);

        if (ind == 0) {
            it.next().prev(null);
            this.size--;
            return true;
        } else if (ind == this.getSize() - 1) {
            it.next().prev(null);
            this.tail = it.prev();
            this.size--;
            return true;
        } else {
            it.next(it.prev());
            it.prev(it.next());
            this.size--;
            return true;
        }

    }

    public int removeElementAtIndex(int index) {


        if (index < 0 || index >= this.getSize()) {
            return -1;
        }
        int e = this.get(index);
        boolean isRemoved = this.remove(e);
        if (isRemoved) {
            return e;
        }
        return -1;


    }

    public void clear() {
        listHead = null;
        this.tail = listHead;
        this.size = 0;
    }

    public int set(int index, int e) {
        DoubleLinkedListNode it = listHead;
        if (index < 0 || index >= size()) {
            System.out.println("Throwing index out of bound exception");
            return -1;
        }
        for (int i = 0; i < index - 1; i++) {
            it = it.next();
        }
        int prevValue = it.value();

        it.value(e);
        return prevValue;
    }

    public boolean addAll(MyIntLinkedList c) {
        if (c.size == 0) {
            return false;
        }
        DoubleLinkedListNode it = listHead;
        while (it.next() != null) {
            it = it.next();
        }
        it.next(c.listHead);
        this.size += c.size;
        return true;
    }

    public boolean addAll(int index, MyIntLinkedList c) {

        if (index < 0 || index >= size()) {
            System.out.println("Throwing index out of bound exception");
            return false;
        }
        if (index == 0) {
            c.tail.next(this.listHead);
            this.listHead.prev(c.tail);
            this.listHead = c.listHead;
            this.size += c.size;
            return true;
        }
        DoubleLinkedListNode it = listHead;
        int counter = 0;
        while (counter < index) {
            it = it.next();
            counter++;
        }
        c.tail.next(it);
        // it.prev().next(c.listHead);
        it.prev(c.tail);
        c.listHead.next().prev(it.prev());
        this.size += c.size;
        return true;

    }

    public int[] toArray() {
        int[] array = new int[this.getSize()];
        DoubleLinkedListNode it = listHead;
        int i = 0;
        while (it.next() != null) {
            array[i++] = it.value();
            it = it.next();
        }
        array[i] = it.value();
        return array;
    }
}

