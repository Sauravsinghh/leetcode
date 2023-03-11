class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        List<Integer> arr = new ArrayList<>();
        while(head!=null){
            arr.add(head.val);
            head=head.next;
            n++;
        }
        TreeNode node = sortedArrayToBST(arr, 0, n - 1);
        return node;
    }

    TreeNode sortedArrayToBST(List<Integer> arr, int start, int end) {
 
        /* Base Case */
        if (start > end) {
            return null;
        }
 
        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr.get(mid));
 
        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);
 
        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);
         
        return node;
    }    
}