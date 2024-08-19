package heaps;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode Link: https://leetcode.com/problems/merge-k-sorted-lists/description/
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * <p>
 * Example 2:
 * Input: lists = []
 * Output: []
 * <p>
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if (lists.length == 0) {
            return result;
        }
        Queue<Integer> queue = new PriorityQueue(lists.length);

        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.offer(listNode.val);
                listNode = listNode.next;
            }
        }

        if (!queue.isEmpty()) {
            result = new ListNode(queue.poll());
        }

        ListNode temp = result;
        while (!queue.isEmpty()) {
            temp.next = new ListNode(queue.poll());
            temp = temp.next;
        }

        return result;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode node1 = new ListNode(5, new ListNode(4, new ListNode(6)));
        ListNode node2 = new ListNode(15, new ListNode(14, new ListNode(16)));
        mergeKSortedLists.mergeKLists(new ListNode[]{node1, node2});
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
