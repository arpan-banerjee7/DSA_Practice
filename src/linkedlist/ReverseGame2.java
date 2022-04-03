package linkedlist;

//  https://www.hackerrank.com/contests/test-your-skils-in-linked-list/challenges/reverse-linked-list-iv
// 
public class ReverseGame2 {
	SinglyLinkedListNode head;

	private static int canReverse(SinglyLinkedListNode head, int k) {
		int count = 0;
		while (head != null && count != k) {
			head = head.next;
			count++;
		}
		return count;
	}

	private static SinglyLinkedListNode reverse(SinglyLinkedListNode head, int k) {
		int leftLength = canReverse(head, k);
		if (k > leftLength)
			k = leftLength;
		SinglyLinkedListNode curr = head;
		SinglyLinkedListNode prev = null;
		SinglyLinkedListNode next = null;

		int count = 0;
		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		k++;
		if (next != null) {
			head.next = reverse(next, k);
		}
		return prev;
	}

	public static SinglyLinkedListNode reverse_game(SinglyLinkedListNode start) {
		// Write your code here
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
		rg.head = new SinglyLinkedListNode(1);
		SinglyLinkedListNode second = new SinglyLinkedListNode(2);
		SinglyLinkedListNode third = new SinglyLinkedListNode(3);
		SinglyLinkedListNode fourth = new SinglyLinkedListNode(4);
		SinglyLinkedListNode fifth = new SinglyLinkedListNode(5);

		rg.head.next = second; // Link first node with the second node
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;

		SinglyLinkedListNode node = reverse_game(rg.head);
		rg.printList(node);

	}

}
