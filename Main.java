import java.util.*;
class Node
{
    int key;
    Node left,right;
    public Node(int data)
    {
        key=data;
        left=right=null;
    }
}
class BinaryTree
{
    Node root;
    
    BinaryTree()
    {
        root=null;
        
    }
    public void insert(int key)
    {
        root=insertbin(root,key);
    }
    Node insertbin(Node root,int key)
    {
        if(root==null)
        {
            root=new Node(key);
            return root;
        }
        if(key<root.key)
        {
            root.left=insertbin(root.left,key);
        }
        else if(key>root.key)
        {
            root.right=insertbin(root.right,key);
        }
        return root;
    }
    public void intravers(Node node)
    {
         if (node != null)
         {
           intravers(node.left);
            System.out.print(node.key + " ");
            intravers(node.right);
         }
    }
    public boolean search(int data)
    {
        Node temp=root;
        while(temp!=null)
        {
            if(temp.key==data)
            {
                return true;
            }
            else if(data<temp.key)
            {
                temp=temp.left;
            }
            else if(data>temp.key)
            {
                temp=temp.right;
            }
           }
        return false;
    }
    public void delete(int data)
    {
        root=deletert(root,data);
    }
    Node deletert(Node temp,int data)
    {
        if(temp==null)
        {
            return temp;
        }
        if(temp.key>data)
        {
            temp.left=deletert(temp.left,data);
        }
        else if(temp.key<data)
        {
            temp.right=deletert(temp.right,data);
        }
        else
        {
            if(temp.left==null)
            {
                return temp.right;
            }
            else if(temp.right==null)
            {
                return temp.left;
            }
            temp.key= min (temp.right);
        	temp.right = deletert(temp.right, temp.key);
        }
        return temp;
    }  
    private int min (Node node)
  {
    int minValue = node.key;
    while (node.left != null)
      {
	minValue = node.left.key;
	node = node.left;
      }
    return minValue;
  }
    }

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		BinaryTree tree=new BinaryTree();
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
		    int k=sc.nextInt();
		    tree.insert(k);
		}
		tree.intravers(tree.root);
		System.out.println(" ");
		int a=sc.nextInt();
		System.out.println(tree.search(a));
		System.out.println(" ");
		int b=sc.nextInt();
		tree.delete(b);
		tree.intravers(tree.root);
	}
}
