package com.csw.shuanFa.JieGou;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    //删除节点
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            node = null;
            return;
        }
        // 取缔下一节点
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //翻转链表
    public ListNode reverse(ListNode head) {
        //prev表示前继节点
        ListNode prev = null;
        while (head != null) {
            //temp记录下一个节点，head是当前节点
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    //中间元素
    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // fast.next = null 表示 fast 是链表的尾节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //判断是否为循环链表
    public Boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    //合并两个已排序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }

        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }

        return dummy.next;
    }
    /*链表排序
    可利用归并、快排等算法实现*/

    // 归并排序
    public ListNode sortListGuiBing(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);

        ListNode right = sortListGuiBing(mid.next);
        mid.next = null;
        ListNode left = sortListGuiBing(head);

        return mergeTwoLists(left, right);
    }

    // 快速排序
    public ListNode sortListKuaiSu(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode start, ListNode end) {
        if (start == end) {
            return;
        }

        ListNode pt = partition(start, end);
        quickSort(start, pt);
        quickSort(pt.next, end);
    }

    private ListNode partition(ListNode start, ListNode end) {
        int pivotKey = start.val;
        ListNode p1 = start, p2 = start.next;
        while (p2 != end) {
            if (p2.val < pivotKey) {
                p1 = p1.next;
                swapValue(p1, p2);
            }
            p2 = p2.next;
        }

        swapValue(start, p1);
        return p1;
    }

    private void swapValue(ListNode node1, ListNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    //删除倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preDelete = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        // 此时head为正数第N个节点
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }

    //两个链表是否相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode currA = headA;
        ListNode currB = headB;
        int lengthA = 0;
        int lengthB = 0;

        // 让长的先走到剩余长度和短的一样
        while (currA != null) {
            currA = currA.next;
            lengthA++;
        }
        while (currB != null) {
            currB = currB.next;
            lengthB++;
        }

        currA = headA;
        currB = headB;
        while (lengthA > lengthB) {
            currA = currA.next;
            lengthA--;
        }
        while (lengthB > lengthA) {
            currB = currB.next;
            lengthB--;
        }

        // 然后同时走到第一个相同的地方
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        // 返回交叉开始的节点
        return currA;
    }
}
