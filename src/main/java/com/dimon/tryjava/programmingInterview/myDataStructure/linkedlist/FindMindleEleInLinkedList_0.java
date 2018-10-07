package com.dimon.tryjava.programmingInterview.myDataStructure.linkedlist;

import java.util.LinkedList;

public class FindMindleEleInLinkedList_0 {

//    https://javarevisited.blogspot.com/2012/12/how-to-find-middle-element-of-linked-list-one-pass.html


    public static void main(String args[])
    {

        LinkedList l=new LinkedList();
        l.add(2);
        l.add(3);
        l.add(9);
        l.add(4);

        java.util.Iterator i1=l.iterator();
        java.util.Iterator i2=l.iterator();

        int i=0;
        int middle = 0;
        while(i1.hasNext())
        {
            if(i==0)
            {
                i1.next();
                i=1;

            }
            else if(i==1)
            {
                if(i1.hasNext())
                {

                    i1.next();

                    middle=(Integer) i2.next();
                    i=0;
                }
            }
        }
        System.out.println("middle"+middle);



    }

}
