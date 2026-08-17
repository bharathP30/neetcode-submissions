/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> res;
    public List<Integer> inorderTraversal2(TreeNode root) {
        res = new ArrayList<>();
        inorder(root);
        return res;
    }

    private void inorder (TreeNode node){
        if( node == null ) return;

        inorder(node.left);
        res.add(node.val);
        inorder(node.right);
    }
    // we can simulate the recursive inorder traversal iteratively
    // we need to reach the last left node till it is not null
    // and keep moving up and add right node
    // a stack is useful here to keep track of visited nodes
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while( current != null || !stack.isEmpty() ){
            while( current != null ){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current.val);
            current = current.right;

        }
            return list;
    }
}
