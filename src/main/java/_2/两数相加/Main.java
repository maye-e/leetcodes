package _2.两数相加;

public class Main {
    public static void main(String[] args) {

        ListNode pre1 = new ListNode(7);
        ListNode cur1 = pre1;
        cur1.next = new ListNode(8);
        cur1 = cur1.next;
        cur1.next = new ListNode(9);

        ListNode pre2 = new ListNode(3);
        ListNode cur2 = pre2;
        cur2.next = new ListNode(2);

        ListNode listNode = addTwoNumbers(pre1, pre2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
     * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);//返回的链表，指向头节点的前一个
        ListNode cur = pre;//定义了一个游标，同时指向节点，后面游标会移动进行操作
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
