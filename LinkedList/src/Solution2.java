/**
 * Created by upupgogogo on 2018/5/12.下午8:07
 */
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(pre.next != null){
            if (pre.next.val == val){
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
            }
            else
                pre = pre.next;
        }
        return dummyHead.next;
    }
}