/**
 * Created by upupgogogo on 2018/5/12.下午7:32
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {

            while (head != null && head.val == val) {
                ListNode delNode = head;
                head = head.next;
                delNode.next = null;
            }
            if (head == null)
                return null;
            ListNode pre = head;
            while(pre.next != null){
                if (pre.next.val == val){
                    ListNode delNode = pre.next;
                    pre.next = delNode.next;
                    delNode.next = null;
                }
                else
                    pre = pre.next;
            }
            return head;
    }
}
