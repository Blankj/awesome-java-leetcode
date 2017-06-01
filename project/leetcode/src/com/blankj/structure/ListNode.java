package com.blankj.structure;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/18
 *     desc  :
 * </pre>
 */
public class ListNode {

    public int      val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String str = "[" + String.valueOf(val);
        ListNode p = next;
        while (p != null) {
            str += ", " + String.valueOf(p.val);
            p = p.next;
        }
        return str + "]";
    }

    public static ListNode createTestData(int[] data) {
        int len =  len = data.length;
        if (len == 0) return null;
        ListNode[] listNode = new ListNode[len + 1];
        listNode[0] = new ListNode(data[0]);
        for (int i = 1; i < len; i++) {
            listNode[i] = new ListNode(data[i]);
            listNode[i - 1].next = listNode[i];
        }
        return listNode[0];
    }
}
