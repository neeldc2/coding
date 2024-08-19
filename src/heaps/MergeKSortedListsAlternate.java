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
public class MergeKSortedListsAlternate {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        if (lists.length == 0) {
            return result;
        }
        Queue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }

        ListNode temp = result;
        while (!queue.isEmpty()) {
            ListNode smallestListNode = queue.poll();
            temp.next = new ListNode(smallestListNode.val);

            smallestListNode = smallestListNode.next;

            if (smallestListNode != null) {
                queue.offer(smallestListNode);
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));
        print(mergeKSortedLists.mergeKLists(new ListNode[]{node1, node2, node3}));
        print(mergeKSortedLists.mergeKLists(new ListNode[]{}));
    }

    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
