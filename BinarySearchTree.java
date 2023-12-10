import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

public class BinarySearchTree {
    Node root;

    public void insert(int data) {
        Node node = new Node(data);
        if (this.root == null) {
            this.root = node;
            return;
        }

        Node curr = this.root;
        while (curr != null) {
            if (data > curr.data) {
                if (curr.right == null) {
                    curr.right = node;
                    return;
                }
                curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = node;
                    return;
                }
                curr = curr.left;
            }
        }

    }

    public void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                size--;
            }
            System.out.println("");
        }
    }

    //TODO: Revisit
    public Node remove(int data) {
        Node node = search(data);
        Node parent = searchParent(data);

        if (node == null) {
            return null;
        }

        // node is leaf
        if (node.left == null && node.right == null) {
            // find if node is left or right of parent
            if (parent == null) {
                root = null;
                return node;
            }
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return node;
        } else if (node.left == null || node.right == null) { // node has single child

            if (node == root) {
                if (node.left != null) {
                    root = node.left;
                    node.left = null;
                } else {
                    root = node.right;
                    node.right = null;
                }
                return node;
            }

            if (parent.left == node) {
                if (node.left != null) {
                    parent.left = node.left;
                    node.left = null;
                } else {
                    parent.left = node.right;
                    node.right = null;
                }
                return node;
            } else {
                if (node.left != null) {
                    parent.right = node.left;
                    node.left = null;
                } else {
                    parent.right = node.right;
                    node.right = null;
                }
                return node;
            }
        } else { // node has two children
            Node curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            Node replacement = curr;

            if (replacement.right != null) {
                Node parentOfReplacement = searchParent(replacement.data);
                parentOfReplacement.left = replacement.right;
                replacement.right = null;
            }
            replacement.left = node.left;
            replacement.right = node.right;
            node.left = null;
            node.right = null;
            if (node == root) {
                root = replacement;
                return node;
            }
            if (node == parent.left) {
                parent.left = replacement;
            } else {
                parent.right = replacement;
            }
            return node;
        }
    }

    // binary search
    public Node search(int data) {
        Node curr = this.root;

        while (true) {
            if (curr.data == data) {
                return curr;
            } else if (curr.left != null && data <= curr.left.data) {
                curr = curr.left;
            } else if (curr.right != null && data >= curr.right.data) {
                curr = curr.right;
            } else {
                return null;
            }
        }
    }

    private Node searchParent(int data) {
        Node curr = this.root;
        Node parent = null;

        while (true) {
            if (curr.data == data) {
                return parent;
            } else if (curr.left != null && data < curr.data) {
                parent = curr;
                curr = curr.left;
            } else if (curr.right != null && data > curr.data) {
                parent = curr;
                curr = curr.right;
            } else {
                return null;
            }
        }
    }

    public void bfs_traversal() {
        Queue <Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr.data);
            if(curr.left!=null) {
                queue.add(curr.left);
            }
            if(curr.right!=null) {
                queue.add(curr.right);
            }
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        Queue <Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);


        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelItems = new ArrayList<>();
            while(levelSize > 0) {
                Node curr = queue.poll();
                levelItems.add(curr.data);
                if(curr.left!=null) {
                    queue.add(curr.left);
                }
                if(curr.right!=null) {
                    queue.add(curr.right);
                }
                levelSize--;
            }
            result.add(levelItems);
        }
        return result;
    }

    public void dfs(String order) {
        helper(root, order);
    }

    private void helper(Node node, String order) {
        if(node == null) return;
        if(order.equals("pre")) {
            System.out.println(node.data);
            helper(node.left, "pre");
            helper(node.right, "pre");
        } else if(order.equals("post")) {
            helper(node.left, "post");
            helper(node.right, "post");
            System.out.println(node.data);
        } else if(order.equals("in")) {
            helper(node.left, "in");
            System.out.println(node.data);
            helper(node.right, "in");
        }
        
    }
}
