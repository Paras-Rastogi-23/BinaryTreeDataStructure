// Program to create a tree and find Inorder,Preorder & Postorder
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int value;
    Node left;
    Node right;
}

class BinaryTree{
    public Node createNewNode(int value){
        Node n  = new Node();
        n.value = value;
        n.left  = null;
        n.right = null;
        return(n);
    }
    public void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public int getSumOfNodes(Node node){
        if(node == null)
            return 0;
        return (node.value + getSumOfNodes(node.left) + getSumOfNodes(node.right));
    }

    public int getEvenOddDifference(Node node){
        if(node == null)
            return 0;
        return (node.value - getEvenOddDifference(node.left) - getEvenOddDifference(node.right));
    }
    public int getNumberOfNodes(Node node){
        if(node == null)
            return 0;
        return 1+getNumberOfNodes(node.left)+getNumberOfNodes(node.right);
    }

    public int getNumberOfLeafNodes(Node node){
        if(node ==null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        return getNumberOfLeafNodes(node.left)+getNumberOfLeafNodes(node.right);
    }

    public int getHeightOfTree(Node node){
        if(node == null)
            return -1;
        return max(getHeightOfTree(node.left),getHeightOfTree(node.right))+1;

    }
    public int max(int a , int b){
        return a>b?a:b;
    }

    public void printValuesAtGivenLevel(Node node , int level){
        if(node == null) {
            return;
        }
        if(level == 1){
            System.out.print(node.value + " ");
            return;
        }
        printValuesAtGivenLevel(node.left,level-1);
        printValuesAtGivenLevel(node.right,level-1);
    }

    public void levelOrderTraversalWithoutRecursion(Node node){
        if(node == null){
          return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while (q.size() >0){
            Node top = q.remove();
            System.out.print(top.value+" ");

            if(top.left != null){
                q.add(top.left);
            }

            if(top.right != null){
                q.add(top.right);
            }
        }
    }

    public void reverseLevelOrderTraversalWithoutUsingRecursion(Node node){
        if(node == null){
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        Stack<Node> s = new Stack<Node>();
        q.add(node);

        while(q.size() >0){
            Node top = q.remove();

            if(top.right != null){
                q.add(top.right);
            }

            if(top.left != null){
                q.add(top.left);
            }
            s.push(top);
        }

        while (s.size()!=0){
            System.out.print(s.pop().value + " ");
        }
    }

    public void levelOrderTraversalLineByLineWithoutRecursion(Node node){
        if(node == null)return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (true){
             int count = q.size();
             if(count == 0)
                 break;
             while (count>0){
                 Node top = q.remove();
                 System.out.print(top.value+" ");

                 if(top.left != null){
                     q.add(top.left);
                 }
                 if(top.right != null){
                     q.add(top.right);
                 }

                 count--;
             }
            System.out.println();
        }
    }
    int max_level;
    public void leftViewOfBinaryTree(Node node, int level){
        if(node == null)return;

        if(level >= max_level){
            System.out.print(node.value+" ");
            max_level++;
        }
         leftViewOfBinaryTree(node.left,level+1);
         leftViewOfBinaryTree(node.right ,level+1);
    }
    int max_level2;
    public void rightViewOfBinaryTree(Node node, int level){
        if(node == null)return;

        if(level >= max_level2){
            System.out.print(node.value+" ");
            max_level2++;
        }
        rightViewOfBinaryTree(node.right ,level+1);
        rightViewOfBinaryTree(node.left,level+1);
    }

    public void getInorderWithoutRecursion(Node node){
        if(node == null)return;
        Stack<Node> s = new Stack<>();
        while(node !=null){
            s.push(node);
            node = node.left;
        }

        while(s.size()> 0){
            Node top = s.pop();
            System.out.print(top.value+" ");
            if(top.right != null){
                Node tmp = top.right;
                while(tmp !=null){
                    s.push(tmp);
                    tmp = tmp.left;
                }
            }
        }

    }

    public void getPreorderWithoutRecursion(Node node){
        if(node == null){
            return;
        }
        Node n = node;
        Stack<Node> s = new Stack<>();
        while (node != null){
            System.out.print(node.value+" ");
            s.push(node);
            node = node.left;
        }
        while (s.size()>0){
            Node t = s.pop();
            if(t.right != null){
                Node tmp = t.right;
                while (tmp != null){
                    System.out.print(tmp.value + " ");
                    s.push(tmp);
                    tmp = tmp.left;
                }
            }
        }
    }

    public void getPostorderWithoutRecursion(Node node){
        if(node == null)return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(node);
        while (s1.size() > 0){
            Node t = s1.pop();
            if(t.left != null)
                s1.push(t.left);
            if(t.right != null)
                s1.push(t.right);
            s2.push(t);
        }
        while (s2.size()>0) {
            System.out.print(s2.pop().value+" ");
        }
    }

    public Node getMirrorTree(Node node){
        if(node == null)
            return null;
        Node n = node.left;
        node.left = node.right;
        node.right = n;
        getMirrorTree(node.left);
        getMirrorTree(node.right);
        return (node);
    }
    public Node deleteTree(Node node){
        if(node == null) return null;

        node.left = deleteTree(node.left);
        node.right= deleteTree(node.right);

        System.out.println("Delete node : "+node.value);
        node = null;
        return(node);
    }

    public boolean checkIdenticalTree(Node node1 , Node node2){
        if(node1 ==null && node2 == null)
            return true;
        if((node1 == null && node2 !=null)||(node2 == null && node1 != null))
            return false;
        return ((node1.value == node2.value) && checkIdenticalTree(node1.left , node2.left) && checkIdenticalTree(node1.right,node2.right));

    }
}

public class BinaryTreeDataStructure {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree b = new BinaryTree();
        Node root    = b.createNewNode(2);
        root.left    = b.createNewNode(7);
        root.right   = b.createNewNode(5);
        root.left.left   = b.createNewNode(2);
        root.left.right   = b.createNewNode(6);
        root.right.right   = b.createNewNode(9);
        root.left.right.left   = b.createNewNode(5);
        root.left.right.right   = b.createNewNode(11);
        root.right.right.left   = b.createNewNode(4);

        Node root2    = b.createNewNode(2);
        root2.left    = b.createNewNode(7);
        root2.right   = b.createNewNode(5);
        root2.left.left   = b.createNewNode(2);
        root2.left.right   = b.createNewNode(6);
        root2.right.right   = b.createNewNode(9);
        root2.left.right.left   = b.createNewNode(5);
        root2.left.right.right   = b.createNewNode(11);
        root2.right.right.left   = b.createNewNode(4);

        System.out.println("Inorder : ");
        b.inorder(root);
        System.out.println();
        System.out.println("Preorder : ");
        b.preorder(root);
        System.out.println();
        System.out.println("PostOrder : ");
        b.postOrder(root);

        System.out.println("\n\nSum of all the nodes of tree : "+ b.getSumOfNodes(root));
        System.out.println("\nDifference of all the Even/Odd nodes of tree : "+ b.getEvenOddDifference(root));
        System.out.println("\nNumber of nodes in tree : "+ b.getNumberOfNodes(root));
        System.out.println("\nNumber of leaf nodes in tree : "+ b.getNumberOfLeafNodes(root));
        System.out.println("\nThe Height of tree : "+ b.getHeightOfTree(root));

//        System.out.println("Enter the level at which you want to know the values");
//        int level = Integer.parseInt(br.readLine());
//        System.out.println("\n Value at level "+level+" : ");
//        b.printValuesAtGivenLevel(root,level);

        //display the nodes of tree level wise
        for (int i = 1; i <= b.getHeightOfTree(root)+1 ; i++) {
            System.out.println("\nThe elements at level"+i+ " : ");
            b.printValuesAtGivenLevel(root,i);
        }

        System.out.println("\nLever order traversal of tree : ");
        b.levelOrderTraversalWithoutRecursion(root);

        System.out.println("\nReverse level order traversal : ");
        for(int j = b.getHeightOfTree(root)+1; j>=0;j--){
            b.printValuesAtGivenLevel(root,j);
        }

        System.out.println("\nReverse Level Order Traversal Without Using Recursion is : ");
        b.reverseLevelOrderTraversalWithoutUsingRecursion(root);

        System.out.println("\nLevel Order Traversal Line by Line Without Recursion : ");
        b.levelOrderTraversalLineByLineWithoutRecursion(root);

        System.out.println("\n leftViewOfBinaryTree : ");
        b.leftViewOfBinaryTree(root , 0);

        System.out.println("\nrightViewOfBinaryTree : ");
        b.rightViewOfBinaryTree(root , 0);

        System.out.println("\nThe inorder Traversal without using recursion is : ");
        b.getInorderWithoutRecursion(root);

        System.out.println("\nThe preorder Traversal without using recursion is : ");
        b.getPreorderWithoutRecursion(root);

        System.out.println("\nThe postorder Traversal without using recursion is : ");
        b.getPostorderWithoutRecursion(root);

        System.out.println("\nThe Mirror tree is in InOrder traversal is : ");
        Node mirror = b.getMirrorTree(root);
        b.getInorderWithoutRecursion(mirror);


        System.out.println("\nAfter deletion of tree : ");
        Node deleteTree = b.deleteTree(root);
        System.out.println("After Deletion of tree it becomes : "+deleteTree);

        System.out.print("Check whether root and root2 both trees are identical or not : ");
        System.out.print(b.checkIdenticalTree(root,root2));
    }
}
