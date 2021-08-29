package com.csw.algorithm.JieGou;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    public TreeNode left, right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    // 层次遍历(DFS)
    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, res, 0);
        return res;
    }

    private static void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);

        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }

    /*顺序遍历
        先序遍历: 根->左->右
        中序遍历: 左->根->右
        后序遍历: 左->右->根*/
    // 先序遍历
    public void preTraverse(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }

    // 中序遍历
    public void inTraverse(TreeNode root) {
        if (root != null) {
            inTraverse(root.left);
            System.out.println(root.val);
            inTraverse(root.right);
        }
    }

    // 后序遍历
    public void postTraverse(TreeNode root) {
        if (root != null) {
            postTraverse(root.left);
            postTraverse(root.right);
            System.out.println(root.val);
        }
    }

    // 层次遍历(BFS)
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }

    // "Z"字遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isFromLeft = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            isFromLeft = !isFromLeft;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node;
                if (isFromLeft) {
                    node = ((LinkedList<TreeNode>) queue).pollFirst();
                } else {
                    node = ((LinkedList<TreeNode>) queue).pollLast();
                }
                list.add(node.val);

                if (isFromLeft) {
                    if (node.left != null) {
                        ((LinkedList<TreeNode>) queue).offerLast(node.left);
                    }
                    if (node.right != null) {
                        ((LinkedList<TreeNode>) queue).offerLast(node.right);
                    }
                } else {
                    if (node.right != null) {
                        ((LinkedList<TreeNode>) queue).offerFirst(node.right);
                    }
                    if (node.left != null) {
                        ((LinkedList<TreeNode>) queue).offerFirst(node.left);
                    }
                }
            }
            result.add(list);
        }

        return result;
    }

    //左右翻转
    public void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }

    //最大值
    public int getMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            int left = getMax(root.left);
            int right = getMax(root.right);
            return Math.max(Math.max(left, right), root.val);
        }
    }

    //最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    //最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0) {
            return right + 1;
        } else if (right == 0) {
            return left + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

}



