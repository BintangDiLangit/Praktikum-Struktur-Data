/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendahuluan_prak_7;

import java.util.Stack;

/**
 *
 * @author str5
 */
public class Node {

    public int id;
    public String data;
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.print("{ " + id + ", " + data + " } ");
    }
}

class tree {

    public Node root;

    public tree() {
        root = null;
    }

    public Node find(int key) {
        Node current = root;
        while (current.id != key) {
            if (key < current.id) {
                current = current.leftChild;

            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int a = root.id;
        int l = max(root.leftChild);
        int r = max(root.rightChild);

        if (l > a) {
            a = l;
        }
        if (r > a) {
            a = r;
        }
        return a;
    }

    public int min(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int a = root.id;
        int l = min(root.leftChild);
        int r = min(root.rightChild);

        if (l < a) {
            a = l;
        }
        if (r < a) {
            a = r;
        }
        return a;
    }

    public void insert(int id, String data) {
        Node newNode = new Node();
        newNode.id = id;
        newNode.data = data;
        if (root == null) {
            root = newNode;
        } else {
            if (cek(id)) {
                System.out.println("Data atau ID tidak boleh sama !!!");
            }else{
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
            }

        }
    }

    public boolean cek(int key) {
        Node cur = root;
        while (cur.id != key) {
            if (key < cur.id) {
                cur = cur.leftChild;
            } else {
                cur = cur.rightChild;
            }
            if (cur == null) {
                return false;
            }

        }
        return true;
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.id != key) {
            parent = current;
            if (key < current.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.println("Preorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.println("Inorder traversal: ");
                InOrder(root);
                break;
            case 3:
                System.out.println("Postorder traversal: ");
                PostOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.id + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void InOrder(Node localRoot) {
        if (localRoot != null) {
            InOrder(localRoot.leftChild);
            System.out.print(localRoot.id + " ");
            InOrder(localRoot.rightChild);
        }
    }

    private void PostOrder(Node localRoot) {
        if (localRoot != null) {
            PostOrder(localRoot.leftChild);
            PostOrder(localRoot.rightChild);
            System.out.print(localRoot.id + " ");
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "....................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.id);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < nBlanks * 2 - 2; i++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println(
                "....................................................");
    }

}
