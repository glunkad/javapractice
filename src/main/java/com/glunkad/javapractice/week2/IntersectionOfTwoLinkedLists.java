package com.glunkad.javapractice.week2;

import java.util.HashSet;

//public class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) {
//          val = x;
//          next = null;
//      }
//}

public class IntersectionOfTwoLinkedLists {
    // TC : O(n+m) SC : O(n)
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA;
        HashSet<ListNode> seen = new HashSet<>();

        while(a != null){
            seen.add(a);
            a = a.next;
        }

        ListNode b = headB;
        while( b!= null){
            if(seen.contains(b)){
                return b;
            }
            b = b.next;
        }
        return null;
    }

    // TC : O(n+m) SC : O(1)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            if(a!=null){
                a = a.next;
            }
            else{
                a = headB;
            }
            if(b!=null){
                b = b.next;
            }
            else{
                b = headA;
            }
        }
        return a;
    }
    public static void main(String[] args){

    }
}
