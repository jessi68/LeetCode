/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

   public String serialize(TreeNode root) {
    if (root == null) {
      return "[]";
    }

    List<String> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node == null) {
        list.add("null");
        continue;
      } else {
        list.add("" + node.val);
      }

      if (node.left != null) {
        queue.offer(node.left);
      } else {
        queue.offer(null);
      }

      if (node.right != null) {
        queue.offer(node.right);
      } else {
        queue.offer(null);
      }
    }

    // null
    for (int i = list.size() - 1; i >= 0; i--) {
      if (list.get(i).equals("null")) {
        list.remove(i);
      } else {
        break;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
      if (i == list.size() - 1) {
        sb.append("]");
      } else {
        sb.append(",");
      }
    }

    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.equals("[]") || data.length() <= 2) {
      return null;
    }

    String[] strArray = data.substring(1, data.length() - 1).split(",");
    Queue<String> list = new LinkedList<>();
    list.addAll(Arrays.asList(strArray));

    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.valueOf(list.poll()));
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      String leftVal = list.poll();
      if (leftVal == null || leftVal.equals("null")) {
        node.left = null;
      } else {
        TreeNode leftNode = new TreeNode(Integer.valueOf(leftVal));
        node.left = leftNode;
        queue.offer(leftNode);
      }

      String rightVal = list.poll();
      if (rightVal == null || rightVal.equals("null")) {
        node.right = null;
      } else {
        TreeNode rightNode = new TreeNode(Integer.valueOf(rightVal));
        node.right = rightNode;
        queue.offer(rightNode);
      }
    }

    return root;
  }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));