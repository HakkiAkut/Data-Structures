class Node {
    public int data;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}