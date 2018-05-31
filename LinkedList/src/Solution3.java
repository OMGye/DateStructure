/**
 * Created by upupgogogo on 2018/5/12.下午8:07
 */
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {

       if(head == null){
           return null;
       }
       head.next = removeElements(head.next,val);
       return head.val == val ? head.next : head;
    }
}