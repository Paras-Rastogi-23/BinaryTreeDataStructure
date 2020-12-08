// Program to create a tree and find Inorder,Preorder & Postorder
import java.io.*;
import java.util.*;

class Node{
    int value;
    Node left;
    Node right;
    int height;
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

        while (q.size()>0){
             int count = q.size();
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
        return ((node1.value == node2.value) &&
                checkIdenticalTree(node1.left , node2.left) &&
                checkIdenticalTree(node1.right,node2.right));
    }

    public int findTheLevelOfNode(Node node , int nodeValue ,int level){
        if(node == null) {
            return 0;
        }
        int l;
       if(nodeValue == node.value) {
           return level;
       }
       l =findTheLevelOfNode(node.left,nodeValue,level+1);
       if(l>0)
           return l;

       l = findTheLevelOfNode(node.right,nodeValue,level+1);
       return l;
    }

    public void getTopViewOfTree(Node node){
        if(node == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        TreeMap<Integer , Integer> treeMap = new TreeMap<>();
        q.add(node);

        while (!q.isEmpty()){
            Node temp = q.remove();
            int h = temp.height;
            if(!treeMap.containsKey(h)){
                treeMap.put(h, temp.value);
            }
            if(temp.left != null)
            {
                q.add(temp.left);
                temp.left.height = h-1;
            }
            if(temp.right != null)
            {
                q.add(temp.right);
                temp.right.height = h+1;
            }
        }
        System.out.print(treeMap.values());
    }

    public void getBottomViewOfTree(Node node){
        if(node == null)
            return;
        Queue<Node> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        q.add(node);
        while (q.size()>0){
            Node temp =  q.remove();
            int ht = temp.height;
            map.put(ht,temp.value);


            if(temp.left != null){
                q.add(temp.left);
                temp.left.height = ht-1;
            }
            if(temp.right != null){
                q.add(temp.right);
                temp.right.height = ht+1;
            }
        }
        System.out.println(map.values());
    }

    public void getBoundaryNodesOfTree(Node node){
        if(node == null)return;
        System.out.print(node.value+" ");
        printLeftBoundary(node.left);
        printLeaves(node.left);
        printLeaves(node.right);
        printRightBoundary(node.right);
    }

    public void printLeftBoundary(Node node){
        if(node == null)
            return;
        if(node.left!=null){
            System.out.print(node.value+" ");
            printLeftBoundary(node.left);
        }else if(node.right!=null){
            System.out.print(node.value+" ");
            printLeftBoundary(node.right);
        }
    }

    public void printLeaves(Node node){
        if(node == null)return;
        printLeaves(node.left);
        if(node.left==null && node.right ==null)
            System.out.print(node.value+" ");
        printLeaves(node.right);
    }

    public void printRightBoundary(Node node){
        if(node == null)
            return;
        if(node.right!=null)
        {
            printRightBoundary(node.right);
            System.out.print(node.value+" ");
        }else if(node.left!=null)
        {
           printRightBoundary(node.left);
           System.out.print(node.value+" ");
        }
    }

    public void printVerticalOrderOfTree(Node node){
        if(node == null)return;
        int ht = 0;
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer , ArrayList<Integer>>();
        getVerticalOrderOfTree(node , ht , map);
        for (Map.Entry<Integer , ArrayList<Integer>> m: map.entrySet()){
            System.out.println(m.getValue());
        }
    }

    public void getVerticalOrderOfTree(Node node , int height , TreeMap<Integer,ArrayList<Integer>> map){
        if(node == null)return;

        if(!map.containsKey(height)){
            ArrayList<Integer> l = new ArrayList<>();
            l.add(node.value);
            map.put(height,l);
        }
        else{
            ArrayList<Integer> l = map.get(height);
            l.add(node.value);
            map.put(height,l);
        }
        getVerticalOrderOfTree(node.left,height-1,map);
        getVerticalOrderOfTree(node.right,height+1,map);
    }

    public void printVerticalSumOfTree(Node node){
        if(node == null)return;
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        getVerticalSumOfTree(node,0,map);
        map.forEach((k,v) ->{
            System.out.format("\nSum of nodes at Level %d --> %d",k,v);
        });

    }

    public void getVerticalSumOfTree(Node node , int height , TreeMap<Integer,Integer> m){
        if(node == null)return;
        int value = (!m.containsKey(height)?0:m.get(height));
        m.put(height,value+node.value);
        getVerticalSumOfTree(node.left , height-1,m);
        getVerticalSumOfTree(node.right,height+1,m);
    }

    public void sumOfNodeValuesLevelWise(Node node){
        if(node == null)return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int i =1;
        while (q.size()>0){
            int count = q.size();
            int sum = 0;
            while (count>0){
                Node top = q.remove();
                sum += top.value;
                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
                count--;
            }
            System.out.println("The Sum of the value of nodes at level "+i++ +" is : "+sum);
        }
   }

   public boolean recursiveSearch(Node node ,int key){
        if(node == null) return false;
        if(node.value == key) return true;
        return (recursiveSearch(node.left , key) || recursiveSearch(node.right , key));
   }

   public boolean iterativeSearch(Node node ,int key){
        if(node == null) return false;
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while (q.size()>0){
            Node temp  = q.remove();
            if(temp.value == key)
                return true;
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
        return false;
   }

    public void printInSpiralForm(Node node) {
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        s1.push(node);
        while (!s1.isEmpty() || !s2.isEmpty()) {

            while (!s1.isEmpty()) {
                Node tmp = s1.pop();
                System.out.print(tmp.value + " ");

                if (tmp.right != null) {
                    s2.push(tmp.right);
                }

                if (tmp.left != null) {
                    s2.push(tmp.left);
                }
            }
            System.out.println();

            while (!s2.isEmpty()) {
                Node tmp = s2.pop();
                System.out.print(tmp.value + " ");

                if (tmp.left != null) {
                    s1.push(tmp.left);
                }

                if (tmp.right != null) {
                    s1.push(tmp.right);
                }
            }
            System.out.println();
        }
    }

    public void printValuesBetweenGivenLevels(Node node, int level , int level1 , int level2){
        if(node == null) {
            return;
        }
        if(level==level1 && level2>0){
            System.out.print(node.value + " ");
            level=level-1;
        }
        printValuesBetweenGivenLevels(node.left,level+1,level1,level2-1);
        printValuesBetweenGivenLevels(node.right,level+1,level1,level2-1);
    }

    public void getMaximumWidthOfBinaryTree(Node node){
        if(node == null)return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int max_width =0;
        while (q.size()>0){
            int count = q.size();
            if(count>max_width)max_width=count;
            while (count>0){
                Node top = q.remove();
                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
                count--;
            }
        }
        System.out.print(" "+max_width);
    }

    public boolean whetherTreesAreMirrorTreesOrNot(Node node1 , Node node2){
        if(node1 == null && node2 == null)return true;
        if(node1 == null || node2 == null)return false;
        return (node1.value == node2.value
                && whetherTreesAreMirrorTreesOrNot(node1.left,node2.right)
                && whetherTreesAreMirrorTreesOrNot(node1.right,node2.left));
    }

    public boolean whetherTreesAreMirrorStructuresOrNot(Node node1 , Node node2){
        if(node1==null && node2==null)return true;
        if(node1==null || node2==null)return false;
        return ((node1 != null && node2 != null)
                && whetherTreesAreMirrorStructuresOrNot(node1.left,node2.right)
                && whetherTreesAreMirrorStructuresOrNot(node1.right,node2.left));
    }

    public boolean whetherTreesAreSameStructuresOrNot(Node node1 , Node node2){
        if(node1==null && node2==null)return true;
        if(node1==null || node2==null)return false;
        return ((node1 != null && node2 != null)
                && whetherTreesAreSameStructuresOrNot(node1.left,node2.left)
                && whetherTreesAreSameStructuresOrNot(node1.right,node2.right));
    }

    public boolean whetherTreeFoldableOrNot(Node node){
        boolean result = whetherTreesAreMirrorStructuresOrNot(node.left,node.right);
        return result;
    }

    public boolean areIsomorphicTrees(Node node1 , Node node2){
        if(node1==null && node2 == null)return true;
        if(node1==null || node2==null)return false;
        if(node1.value != node2.value)return false;

        return ((areIsomorphicTrees(node1.left,node2.left)
                && areIsomorphicTrees(node1.right,node2.right))
                ||
                (areIsomorphicTrees(node1.left,node2.right)
                && areIsomorphicTrees(node1.right,node2.left)));
    }

    public int getWidthOfParticularLevelOfTree(Node node , int level){
        if(node == null)
            return 0;
        if(level == 1)
            return 1;
        return (getWidthOfParticularLevelOfTree(node.left,level-1)
                +getWidthOfParticularLevelOfTree(node.right,level-1));
    }

    public void createDoubleTreeOfGivenTree(Node node){
        if(node ==null)return;
        createDoubleTreeOfGivenTree(node.left);
        createDoubleTreeOfGivenTree(node.right);
        Node newNode = createNewNode(node.value);
        newNode.left = node.left;
        node.left = newNode;
    }
    int preIndex;
    public Node createTreeByPreorderAndInorder(int[] pre,int[] in , int start, int end){
        if(start>end)return null;
        Node node = createNewNode(pre[preIndex++]);
        if(start == end)return node;

        int inorderIndex = getIndexOfNodeInInorderArray(node.value,in,start,end);
        node.left = createTreeByPreorderAndInorder(pre,in,start,inorderIndex-1);
        node.right= createTreeByPreorderAndInorder(pre,in,inorderIndex+1,end);
        return node;
    }

    public int getIndexOfNodeInInorderArray(int value , int[] in , int start , int end){
        for(int i=start;i<=end;i++){
            if(in[i] == value)
                return i;
        }
        return -1;
    }

    public int getHeightOfTreeByIterativeMethod(Node node){
        if(node == null)
            return -1;
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        int height =-1;
        while (q.size()>0){
            int size = q.size();

            while (size >0){
                Node temp = q.remove();
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right !=null){
                    q.add(temp.right);
                }
                size--;
            }
            height += 1;
        }
        return height;
    }
    int diameter=0;
    public int getDiameterOfTree(Node node){
        if(node == null)return 0;
        if(node.left == null && node.right==null)return 1;

        int lh = getDiameterOfTree(node.left);
        int rh = getDiameterOfTree(node.right);

        diameter = Math.max(diameter , (lh+rh+1));
        return (Math.max(lh,rh)+1);
    }

    public boolean checkForHeightBalancedTree(Node node){
        if(node == null)return true;
        if(node.left == null && node.right == null)return true;
        int lh = getHeightOfTree(node.left);
        int rh = getHeightOfTree(node.right);
        return (((lh>rh?lh-rh:rh-lh)<=1) && checkForHeightBalancedTree(node.left) && checkForHeightBalancedTree(node.right));
        /** ALTERNATIVE METHOD & BEST ALSO

         public int ifHeightBalancedTree(Node node) {
         if (node == null) {
         return 0;
         }

         if(node.left == null && node.right == null) {
         return 1;
         }

         int lH = ifHeightBalancedTree(node.left);
         int rH = ifHeightBalancedTree(node.right);

         if(lH == -1 || rH == -1 || Math.abs(lH - rH) > 1) {
         return -1;
         }

         return Math.max(lH, rH) + 1;
         }
         IN this method if return -1  --> false   then --> true*/
    }

    public boolean ifRootToLeafPathSumMatches(Node node , int givenSum){
        if(node == null)return false;
        if(node.left == null && node.right == null && givenSum == node.value)return true;

        return ifRootToLeafPathSumMatches(node.left,givenSum-node.value)
                || ifRootToLeafPathSumMatches(node.right,givenSum-node.value);
    }

    public void printRootToLeaf(Node node){
        if(node == null)return;
        int[] arr = new int[20];
        printRootToLeafImplementation(arr , 0 ,node);
    }

    public void printRootToLeafImplementation(int[] arr ,int length,Node node){
        if(node == null)return;
        arr[length]=node.value;
        if(node.left == null && node.right==null)
            printRootToLeafImpArray(arr,length);
        printRootToLeafImplementation(arr,length+1,node.left);
        printRootToLeafImplementation(arr,length+1,node.right);
    }

    public void printRootToLeafImpArray(int[] arr ,int length){
        int max =0;
        for (int i = 0; i <= length; i++) {
            System.out.print(arr[i]+" ");
            if(max<arr[i])max=arr[i];

        }
        System.out.println(" And Node containing largest value as : "+max);
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

        Node rootToBeModifiedIntoDoubleMode    = b.createNewNode(2);
        rootToBeModifiedIntoDoubleMode.left    = b.createNewNode(7);
        rootToBeModifiedIntoDoubleMode.right   = b.createNewNode(5);
        rootToBeModifiedIntoDoubleMode.left.left   = b.createNewNode(2);
        rootToBeModifiedIntoDoubleMode.left.right   = b.createNewNode(6);
        rootToBeModifiedIntoDoubleMode.right.right   = b.createNewNode(9);
        rootToBeModifiedIntoDoubleMode.left.right.left   = b.createNewNode(5);
        rootToBeModifiedIntoDoubleMode.left.right.right   = b.createNewNode(11);
        rootToBeModifiedIntoDoubleMode.right.right.left   = b.createNewNode(4);

        Node rootToBeDeleted    = b.createNewNode(2);
        rootToBeDeleted.left    = b.createNewNode(7);
        rootToBeDeleted.right   = b.createNewNode(5);
        rootToBeDeleted.left.left   = b.createNewNode(2);
        rootToBeDeleted.left.right   = b.createNewNode(6);
        rootToBeDeleted.right.right   = b.createNewNode(9);
        rootToBeDeleted.left.right.left   = b.createNewNode(5);
        rootToBeDeleted.left.right.right   = b.createNewNode(11);
        rootToBeDeleted.right.right.left   = b.createNewNode(4);

        Node newRoot            = b.createNewNode(2);
        newRoot.left            = b.createNewNode(7);
        newRoot.right           = b.createNewNode(5);
        newRoot.left.left       = b.createNewNode(2);
        newRoot.left.left.left  = b.createNewNode(19);
        newRoot.left.right      = b.createNewNode(6);
        newRoot.right.right     = b.createNewNode(9);
        newRoot.right.right.right       = b.createNewNode(10);
        newRoot.left.right.left = b.createNewNode(5);
        newRoot.left.right.left.left    = b.createNewNode(15);
        newRoot.left.right.left.right   = b.createNewNode(17);
        newRoot.left.right.right = b.createNewNode(11);
        newRoot.right.right.left = b.createNewNode(4);
        newRoot.right.right.left.left   = b.createNewNode(3);
        newRoot.right.right.left.right  = b.createNewNode(1);

        Node foldableRoot = b.createNewNode(1);
        foldableRoot.left = b.createNewNode(2);
        foldableRoot.right = b.createNewNode(3);
        foldableRoot.left.left = b.createNewNode(4);
        foldableRoot.left.right = b.createNewNode(5);
        foldableRoot.right.left = b.createNewNode(6);
        foldableRoot.right.right = b.createNewNode(7);

        Node heightBalancedTree    = b.createNewNode(2);
        heightBalancedTree.left    = b.createNewNode(7);
        heightBalancedTree.right   = b.createNewNode(5);
        heightBalancedTree.left.left   = b.createNewNode(2);
        heightBalancedTree.left.right  = b.createNewNode(6);
        heightBalancedTree.right.left  = b.createNewNode(1);
        heightBalancedTree.right.right = b.createNewNode(9);
        heightBalancedTree.left.right.left   = b.createNewNode(5);
        heightBalancedTree.left.right.right  = b.createNewNode(11);
        heightBalancedTree.right.right.left  = b.createNewNode(4);


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
        System.out.println("\nThe Height of tree : "+ b.getHeightOfTree(root2));

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
        Node deleteTree = b.deleteTree(rootToBeDeleted);
        System.out.println("After Deletion of tree it becomes : "+deleteTree);


        System.out.print("Check whether root and root2 both trees are identical or not : ");
        System.out.print(b.checkIdenticalTree(root,root2));

        System.out.print("\nEnter the value of Node whose level you want to find out : ");
        int nodeValue = Integer.parseInt(br.readLine());
        int levelOfNode = b.findTheLevelOfNode(root,nodeValue,1);
        System.out.println(levelOfNode!=0?"The level at which "+nodeValue+" is present : "+levelOfNode:nodeValue+" is not present in the tree");

        System.out.println("The top view of tree is :");
        b.getTopViewOfTree(root);

        System.out.println("The bottom view of tree is :");
        b.getBottomViewOfTree(root);

        System.out.println("The Boundary nodes of tree are :");
        b.getBoundaryNodesOfTree(newRoot);

        System.out.println("\nThe Vertical-Order nodes of tree are :");
        b.printVerticalOrderOfTree(root);

        System.out.println("\nThe vertical Sum of tree :");
        b.printVerticalSumOfTree(root);

        System.out.println("\nThe Sum of elements at certain levels are given below :");
        b.sumOfNodeValuesLevelWise(root);

        System.out.println("Enter the element which you want to search in the tree");
        int key =Integer.parseInt(br.readLine());
        System.out.println(b.recursiveSearch(root,key)?"Yes element "+key+" is present" : "No Element "+key+" is not present");
        System.out.println(b.iterativeSearch(root,key)?"Yes element "+key+" is present" : "No Element "+key+" is not present");

        System.out.println("Preorder : ");
        b.preorder(root);

        System.out.println("\nSpiral form of tree is given below :");
        b.printInSpiralForm(newRoot);

        System.out.println("\nThe node Values between two level 2 and 4 are :-");
        b.printValuesBetweenGivenLevels(newRoot,1,2,4);

        System.out.println("\nThe Maximum width of Binary tree is :-");
        b.getMaximumWidthOfBinaryTree(newRoot);

        System.out.println("\nThe tree root and root2 are mirror trees :-  ");
        System.out.print(b.whetherTreesAreMirrorTreesOrNot(root,root2));

        System.out.println("\nThe tree root and root2 are mirror Structure trees :-  ");
        System.out.print(b.whetherTreesAreMirrorStructuresOrNot(root,root2));

        System.out.println("\nThe trees have same Structure trees :-  ");
        System.out.print(b.whetherTreesAreSameStructuresOrNot(newRoot,newRoot));

        System.out.println("\nThe tree is foldable or not :-  ");
        System.out.print(b.whetherTreeFoldableOrNot(foldableRoot));

        // isomorphic means having property of same structure or mirror structure but data should be same in both case.
        System.out.println("\nThe trees are Isomorphic or not :-  ");
        System.out.print(b.areIsomorphicTrees(root,root2));
        System.out.println("\nSecond example");
        System.out.print("\nThe trees are Isomorphic or not :-  ");
        System.out.print(b.areIsomorphicTrees(root,root));

        System.out.println("\nThe width of a particular 4th-level of tree is :-");
        System.out.print(b.getWidthOfParticularLevelOfTree(newRoot,4));

        System.out.println("\nCreate Double tree of a given tree");
        System.out.print("Inorder of tree before DoubleCreation :- ");
        b.inorder(rootToBeModifiedIntoDoubleMode);
        b.createDoubleTreeOfGivenTree(rootToBeModifiedIntoDoubleMode);
        System.out.print("\nInorder of tree after DoubleCreation:- ");
        b.inorder(rootToBeModifiedIntoDoubleMode);

        int[] inorder_array = {9,2,6,4,7,1,3,8,5};
        int[] preorder_array= {1,2,9,4,6,7,3,5,8};
        System.out.println("\nCreate A Binary Tree by Inorder and Preorder");
        System.out.print("\nInorder = ");
        for (int i = 0; i < inorder_array.length; i++) {
            System.out.print(inorder_array[i]+" ");
        }
        System.out.print("\nPreorder = ");
        for (int i = 0; i < preorder_array.length; i++) {
            System.out.print(preorder_array[i]+" ");
        }
        Node rootCreatedByInorderAndPreorder = b.createTreeByPreorderAndInorder(preorder_array,inorder_array,0,inorder_array.length-1);
        System.out.print("\npostOrder after create a tree by its inorder and preorder is : ");
        b.postOrder(rootCreatedByInorderAndPreorder);

        System.out.print("\nHeight of tree by Iterative Method :- ");
        int height = b.getHeightOfTreeByIterativeMethod(root);
        System.out.print(height);

        System.out.print("\nDiameter of tree OR Maximum Distance between any two leaf node is :- ");
        b.getDiameterOfTree(newRoot);
        System.out.print(b.diameter);

        System.out.println("\nCheck whether tree is HeightBalancedTree or Not :- ");
        System.out.print(b.checkForHeightBalancedTree(heightBalancedTree));

        System.out.println("\nRoot To Leaf Path Sum Matches by given sum :- ");
        System.out.print(b.ifRootToLeafPathSumMatches(newRoot,37));

        System.out.println("\nAll Root to leaf paths are :- ");
        b.printRootToLeaf(newRoot);

    }
}




