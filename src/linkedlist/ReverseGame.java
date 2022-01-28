package linkedlist;

// https://www.hackerrank.com/contests/linked-list-game/challenges/reverse-game-3-2/problem

// https://www.hackerrank.com/contests/linked-list-game/challenges/reverse-game-3-2/problem
// Your task is to reverse the clusters of nodes which contains even number of nodes and
// simply return the head.

//Input-    (5) (2 6) (3 9 1) (7 3 8 4)
// Output - (5) (6 2) (3 9 1) (4 8 3 7)
class SinglyLinkedListNode {
	int data;
	SinglyLinkedListNode next;

	SinglyLinkedListNode(int data) {
		this.data = data;
		next = null;
	}
}

public class ReverseGame {
	SinglyLinkedListNode head;

	private static int canReverse(SinglyLinkedListNode head, int k) {
		int count = 0;
		SinglyLinkedListNode temp = head;
		while (temp != null && count != k) {
			temp = temp.next;
			count++;
		}
		return count;// returns true if count==k
	}

	private static SinglyLinkedListNode reverse(SinglyLinkedListNode head, int k) {
		// 1 1 0 6 5 --> when count of chunk less than k, then depending on the count
		// you will have to reverse
		int leftNodesCount = canReverse(head, k);
		if (leftNodesCount < k) {
			return reverse(head, leftNodesCount);
		}

		// if chunk size is odd dn t reverse
		if (k % 2 != 0) {
			SinglyLinkedListNode temp = head;
			SinglyLinkedListNode prev = null;
			int count = 0;
			while (count < k && temp != null) {
				prev = temp;
				temp = temp.next;
				count++;
			}
			k += 1;
			if (temp != null) {
				prev.next = reverse(temp, k);
			}
			return head; // no reverse
		}

		// if chunk size is even then reverse
		SinglyLinkedListNode curr = head;
		SinglyLinkedListNode next = null;
		SinglyLinkedListNode prev = null;
		int count = 0;

		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		k += 1;

		if (next != null) {
			head.next = reverse(next, k);
		}
		return prev;
	}

	public static SinglyLinkedListNode reverse_game(SinglyLinkedListNode start) {
		// Write your code here
		// dn t reverse the first node, next starts from 2,3,4 and so on....
		int k = 2;
		start.next = reverse(start.next, k);
		return start;

	}

	/*
	 * 5 2 6 3 9 1 7 3 8 4
	 */

	public void printList(SinglyLinkedListNode head) {
		SinglyLinkedListNode n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public static void main(String[] args) {
		ReverseGame rg = new ReverseGame();
		rg.head = new SinglyLinkedListNode(0);
//		SinglyLinkedListNode second = new SinglyLinkedListNode(2);
//		SinglyLinkedListNode third = new SinglyLinkedListNode(6);
//		SinglyLinkedListNode fourth = new SinglyLinkedListNode(3);
//		SinglyLinkedListNode fifth = new SinglyLinkedListNode(9);
//		SinglyLinkedListNode six = new SinglyLinkedListNode(1);
//		SinglyLinkedListNode seven = new SinglyLinkedListNode(7);
//		SinglyLinkedListNode eight = new SinglyLinkedListNode(3);
//		SinglyLinkedListNode nine = new SinglyLinkedListNode(8);
//		SinglyLinkedListNode ten = new SinglyLinkedListNode(4);
//
//		rg.head.next = second; // Link first node with the second node
//		second.next = third;
//		third.next = fourth;
//		fourth.next = fifth;
//		fifth.next = six;
//		six.next = seven;
//		seven.next = eight;
//		eight.next = nine;
//		nine.next = ten;
//		SinglyLinkedListNode second = new SinglyLinkedListNode(1);
//		SinglyLinkedListNode third = new SinglyLinkedListNode(0);
//		SinglyLinkedListNode fourth = new SinglyLinkedListNode(6);
//		SinglyLinkedListNode fifth = new SinglyLinkedListNode(5);
//		rg.head.next = second; // Link first node with the second node
//		second.next = third;
//		third.next = fourth;
//		fourth.next = fifth;

		SinglyLinkedListNode node = reverse_game(rg.head);
		rg.printList(node);

	}

}
