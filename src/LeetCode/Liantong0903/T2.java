//package LeetCode.Liantong0903;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
///**
// * @ClassName T2
// * @Author Demin Peng
// * @Date 2024/9/3 21:44
// * @Description TODO
// */
//
//public class T2 {
//
//    public static List<Integer> preorderTraversal(TreeNode root) {
//        //请在此处完成相关代码
//
//    }
//    public static TreeNode stringToTreeNode(String input) {
//        input = input.trim();
//        if (input.length() == 0) {
//            return null;
//        }
//        if ("[]".equals(input)) {
//            return null;
//        }
//        input = input.substring(1, input.length() - 1);
//        String[] parts = input.split(",");
//        String item = parts[0];
//        TreeNode root = new TreeNode(Integer.parseInt(item));
//        Queue<TreeNode> nodeQueue = new LinkedList<>();
//        nodeQueue.add(root);
//
//        int index = 1;
//        while(!nodeQueue.isEmpty()) {
//            TreeNode node = nodeQueue.remove();
//
//            if (index == parts.length) {
//                break;
//            }
//
//            item = parts[index++];
//            item = item.trim();
//            if (!item.equals("null")) {
//                int leftNumber = Integer.parseInt(item);
//                node.left = new TreeNode(leftNumber);
//                nodeQueue.add(node.left);
//            }
//
//            if (index == parts.length) {
//                break;
//            }
//
//            item = parts[index++];
//            item = item.trim();
//            if (!item.equals("null")) {
//                int rightNumber = Integer.parseInt(item);
//                node.right = new TreeNode(rightNumber);
//                nodeQueue.add(node.right);
//            }
//        }
//        return root;
//    }
//
//    public static String integerArrayListToString(List<Integer> nums, int length) {
//        if (length == 0) {
//            return "[]";
//        }
//
//        String result = "";
//        for(int index = 0; index < length; index++) {
//            Integer number = nums.get(index);
//            result += Integer.toString(number) + ", ";
//        }
//        return "[" + result.substring(0, result.length() - 2) + "]";
//    }
//
//    public static String integerArrayListToString(List<Integer> nums) {
//        return integerArrayListToString(nums, nums.size());
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
////            Main mainClass = new Main();
////            TreeNode root = mainClass.stringToTreeNode(line);
////            List<Integer> ret = new Solution().preorderTraversal(root);
//
//            TreeNode root = stringToTreeNode(line);
//
//            List<Integer> ret = preorderTraversal(root);
//
//            String out = integerArrayListToString(ret);
//
//            System.out.print(out);
//        }
//    }
//
//    class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode() {}
//        TreeNode(int val) { this.val = val; }
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//}
