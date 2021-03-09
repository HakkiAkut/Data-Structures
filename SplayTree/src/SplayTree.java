import java.util.Arrays;

public class SplayTree {
    public Node root;

    public SplayTree(Node node) {
        this.root = node;
    }

    /**
     * inserts elements to the splay tree
     *
     * @param ele is inserted element
     */
    public void insert(int ele) {
        Node parent = root;
        if (parent == null) {
            root = new Node(ele);
        } else {
            while (true) {
                if (ele > parent.data) {
                    if (parent.right == null) {
                        parent.right = new Node(ele);
                        parent.right.parent = parent;
                        splay(parent.right);
                        break;
                    } else {
                        parent = parent.right;
                        continue;
                    }
                } else {
                    if (parent.left == null) {
                        parent.left = new Node(ele);
                        parent.left.parent = parent;
                        splay(parent.left);
                        break;
                    } else {
                        parent = parent.left;
                        continue;
                    }
                }
            }

        }
    }

    /**
     * makes left child new parent(right rotation)
     *
     * @param c child node
     * @param p parent node
     */
    public void makeLeftChildParent(Node c, Node p) {
        if (p.parent != null) {
            c.parent = p.parent;
            if (c.parent.left == p) {
                c.parent.left = c;
            } else {
                c.parent.right = c;
            }
        } else {
            c.parent = null;
            if (root == p) {
                this.root = c;
            }
        }
        p.parent = c;
        if (c.right != null) {
            p.left = c.right;
        } else {
            p.left = null;
        }
        c.right = p;
    }

    /**
     * makes right child new parent(left rotation)
     *
     * @param c child node
     * @param p parent node
     */
    public void makeRightChildParent(Node c, Node p) {
        if (p.parent != null) {
            c.parent = p.parent;
            if (c.parent.left == p) {
                c.parent.left = c;
            } else {
                c.parent.right = c;
            }
        } else {
            c.parent = null;
            if (root == p) {
                this.root = c;
            }
        }
        p.parent = c;
        if (c.left != null) {
            p.right = c.left;
        } else {
            p.right = null;
        }
        c.left = p;
    }

    /**
     * makes x new root
     *
     * @param x node that will be new root
     */
    public void splay(Node x) {
        while (x.parent != null) {
            if (x.parent.right == x) {
                makeRightChildParent(x, x.parent);
            } else {
                makeLeftChildParent(x, x.parent);
            }
        }
    }

    /**
     * finds node which has same data as ele.
     *
     * @param ele searched element
     * @return Node with same element with ele
     */
    public Node findNode(int ele) {
        Node current = root;
        if (current == null) {
            return null;
        }
        while (true) {
            if (current.data == ele) {
                splay(current);
                return current;
            } else {
                if (ele > current.data) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        break;
                    }
                } else {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        break;
                    }
                }
            }
        }
        splay(current);
        return null;
    }

    /**
     * remove node in splay tree
     *
     * @param node removed node
     */
    public void remove(Node node) {
        if (node != null) {
            if (root.right != null && root.left != null) {
                Node newRoot = node.left;
                while (newRoot.right != null) {
                    makeRightChildParent(newRoot.right, newRoot);
                    newRoot = node.left;
                }
                newRoot.parent = null;
                newRoot.right = root.right;
                root.right.parent = newRoot;
                root = newRoot;
            } else if (root.left != null) {
                root = root.left;
                root.parent = null;
            } else if (root.right != null) {
                root = root.right;
                root.parent = null;
            } else {
                root = null;
            }
        }
    }

    /**
     * prints current splay tree
     *
     * @param filename file that printed
     */
    public void print(String filename) {
        int[] array = new int[(int) (Math.pow(2, (findHeight(root))) - 1)];
        Arrays.fill(array, Integer.MIN_VALUE);
        array = findArray(root, 0, array);
        for (int a : array) {
            if (a == Integer.MIN_VALUE) {
                System.out.print("- ");
                Main.writeResultToFile(filename, "- ");
            } else {
                System.out.print(a + " ");
                Main.writeResultToFile(filename, a + " ");
            }
        }
        System.out.println();
        Main.writeResultToFile(filename, "\n");
    }

    /**
     * adds splay tree elements in array for printing
     *
     * @param node  node that will be added to array
     * @param i     index of node
     * @param array which node data will be added
     * @return array after adding node
     */
    public int[] findArray(Node node, int i, int[] array) {
        if (node != null) {
            array[i] = node.data;
            array = findArray(node.left, 2 * i + 1, array);
            array = findArray(node.right, 2 * i + 2, array);
        }
        return array;
    }

    /**
     * finds height for creating array
     *
     * @param node current node will be find height
     * @return height of node
     */
    int findHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = findHeight(node.left);
            int rightHeight = findHeight(node.right);
            if (leftHeight > rightHeight) {
                return (leftHeight + 1);
            } else {
                return (rightHeight + 1);
            }
        }
    }
}