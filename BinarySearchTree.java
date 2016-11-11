﻿


import java.io.*;
import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {

  protected TreeNode<E> root;
  protected int size = 0;
  private int leaves;

  /** Create a default binary tree */
  public BinarySearchTree() { }

  /** Create a binary tree from an array of objects */
  public BinarySearchTree(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      insert(objects[i]);
  }

  /** Returns true if the element is in the tree */
  public boolean search(E e) {
    TreeNode<E> current = root; // Start from the root
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else // element matches current.element
        return true; // Element is found
    }
    return false;
  }
    /** Returns true if the element is in the tree
     *  and counts compares
     */
  public boolean search(E e,int[] count) {
    TreeNode<E> current = root; // Start from the root
    while (current != null) {
        count[0]++;
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else // element matches current.element
        return true; // Element is found
    }
    return false;
  }

  /** Insert element o into the binary tree
   * Return true if the element is inserted successfully. 
   *  Uses an iterative algorithm
   */
  public boolean insert(E e) {
    if (root == null)
      root = createNewNode(e); // Create a new root
    else {
      // Locate the parent node
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null)
        if (e.compareTo(current.element) < 0) {
          parent = current;
          current = current.left;
        }
        else if (e.compareTo(current.element) > 0) {
          parent = current;
          current = current.right;
        }
        else
          return false; // Duplicate node not inserted
          
      // Create the new node and attach it to the parent node
      if (e.compareTo(parent.element) < 0)
        parent.left = createNewNode(e);
      else
        parent.right = createNewNode(e);
    }
    size++;
    return true; // Element inserted
  }

  protected TreeNode<E> createNewNode(E e) {
    return new TreeNode<E>(e);
  }

  /** Inorder traversal from the root*/
  public void inorder() {
    inorder(root);
  }

  /** Inorder traversal from a subtree */
  protected void inorder(TreeNode<E> root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.element + " ");
    inorder(root.right);
  }
    /** Inorder traversal from a subtree that records to ArrayList list and @return list */
  protected void inorderList(TreeNode<E> root,ArrayList<E> list) {
    if (root == null) return;
    preorder(root.left);
    list.add(root.element);
    preorder(root.right);
  }

   
  /** Postorder traversal from the root */
  public void postorder() {
    postorder(root);
  }

  /** Postorder traversal from a subtree */
  protected void postorder(TreeNode<E> root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.element + " ");
  }

  /** Preorder traversal from the root */
  public void preorder() {
    preorder(root);
  }

  /** Preorder traversal from a subtree */
  protected void preorder(TreeNode<E> root) {
    if (root == null) return;
    System.out.print(root.element + " ");
    preorder(root.left);
    preorder(root.right);
  }
  
  

  /** Preorder traversal from a subtree that records to ArrayList list and @return list */
  protected ArrayList<E> preorderList(TreeNode<E> croot,ArrayList<E> list) {
    if (croot == null) return list;
    list.add(croot.element);
    preorder(croot.left);
    preorder(croot.right);
    return list;
  }

  /** Inner class tree node */
  public static class TreeNode<E extends Comparable<E>> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E e) {
      element = e;
    }
  }

  /** Get the number of nodes in the tree */
  public int getSize() {
    return size;
  }

  /** Returns the root of the tree */
  public TreeNode getRoot() {
    return root;
  }
   
    /** Returns an ArrayList containing elements in the path from the root leading to the specified element, returns an empty ArrayList if no  such element exists. */
    public ArrayList<E> path(E e){
        java.util.ArrayList<E> list = new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root
            while (current != null) {
      list.add(current.element);
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else // element matches current.element
        return list; // Element is found
    }
        list.clear();
        return list; // Return an array of elements
  }
  
    
        /* Returns the number of leaf nodes in this tree, returns 0 if tree is empty*/
    public int  getNumberOfLeaves(){
        leaves=0;
        getNumberOfLeaves(root);
        return leaves;
    }
    /* Returns the number of leaf nodes in this tree, returns 0 if tree is empty*/
    public int  getNumberOfLeaves(TreeNode<E> root){
        if (root == null) return leaves;
          getNumberOfLeaves(root.left);
          getNumberOfLeaves(root.right);
      if (root.left==null&&root.right==null){
         leaves++;}
      return leaves;
    }
    
    /* Returns an ArrayList containing all elements in preorder of the specified element’s left sub-tree, returns an empty ArrayList if no  such element exists. */
    public ArrayList<E> leftSubTree(E e){
    ArrayList<E> elements = new ArrayList<E>();
            java.util.ArrayList<E> list = new java.util.ArrayList<>();
        TreeNode<E> current = root; 
            while (current != null) {
      
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else // element matches current.element
        return preorderList(current.left,list);//left subtree added to ArrayList and return list
    }
        
        return list; // Return an enpty ArrayList 
    }
 
    /* Returns an ArrayList containing all elements in preorder of the specified element’s right sub-tree, returns an empty ArrayList if no  such element exists. */
    public ArrayList<E> rightSubTree(E e){   
        java.util.ArrayList<E> list = new java.util.ArrayList<>();
        TreeNode<E> current = root; 
            while (current != null) {
      
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else // element matches current.element
          
        return preorderList(current.right,list);//right subtree added to ArrayList and return list
    }
        
        return list; // Return an enpty ArrayList 
    }
    
    /* Returns the inorder predecessor of the specified element, returns null if tree is empty or element 'e' is not in the tree. */
    public E inorderPredecessor(E e){
        TreeNode<E> current = root; // Start from the root
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else // element matches current.element
          break;
    }
    if (current==null){
        return null;
    }
    if (current.left != null)
	return max(current.left).element;

	TreeNode predecessor = null;
	// Start from root and search for predecessor down the tree
		
	while (root != null) {		
            if (current.element == root.element) {
		// by now we might found our predecessor
		break;
            } else if (e.compareTo(root.element)<0) {
		root = root.left;
            } else if (e.compareTo(root.element)>0) {
		predecessor = root;
		root = root.right;
            }
	}
    return (E) predecessor.element;
	}
 
    
    
    private  TreeNode<E> max(TreeNode current) {
	// we found the max node
	if (current.right == null) {
		return current;
	}
	return max(current.right);
	}
    
    /* Returns true if BinarySearchTree  tree1 is structurally identical to BinarySearchTree tree2, otherwise returns false */
    public boolean sameTree(BinarySearchTree two){     
     
        return sameTree(this.root,two.root);
        
    }
    public boolean sameTree(TreeNode one,TreeNode two){
        
        if(one.element==two.element){
            if(one.left==null&&two.left==null){
                if(one.right==null&&two.right==null){
                    return true;
                }
                if (one.right==null||two.right==null){
                return false;}
                return sameTree(one.right,two.right);
            }else if(one.left==null||two.left==null){
                return false;
            }
            if(one.right==null&&two.right==null){
                return sameTree(one.left,two.left);
            }else if (one.right==null||two.right==null){
                return false;
            }
            return sameTree(one.left,two.left)&&sameTree(one.right,two.right);
        }
        return false;
        
    }
    
  /** Delete an element from the binary tree.
   * Return true if the element is deleted successfully
   * Return false if the element is not in the tree */
  public boolean delete(E e) {
    // Locate the node to be deleted and also locate its parent node
    TreeNode<E> parent = null;
    TreeNode<E> current = root;
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        parent = current;
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        parent = current;
        current = current.right;
      }
      else
        break; // Element is in the tree pointed by current
    }
    if (current == null)
      return false; // Element is not in the tree
    // Case 1: current has no left children
    if (current.left == null) {
      // Connect the parent with the right child of the current node
      if (parent == null) {
         root = current.right;
      }
      else {
        if (e.compareTo(parent.element) < 0)
          parent.left = current.right;
        else
          parent.right = current.right;
      }
    }
    else {
      // Case 2 & 3: The current node has a left child
      // Locate the rightmost node in the left subtree of
      // the current node and also its parent
      TreeNode<E> parentOfRightMost = current;
      TreeNode<E> rightMost = current.left;

      while (rightMost.right != null) {
        parentOfRightMost = rightMost;
        rightMost = rightMost.right; // Keep going to the right
      }
      // Replace the element in current by the element in rightMost
      current.element = rightMost.element;
      
      // Eliminate rightmost node
      if (parentOfRightMost.right == rightMost)
        parentOfRightMost.right = rightMost.left;
      else
        // Special case: parentOfRightMost == current
        parentOfRightMost.left = rightMost.left;
    }
    size--;
    return true; // Element inserted
  }
  
  /** Obtain an iterator. Use inorder. */
  public java.util.Iterator iterator() {
    return inorderIterator();
  }

  /** Obtain an inorder iterator */
  public java.util.Iterator inorderIterator() {
    return new InorderIterator();
  }

  // Inner class InorderIterator
  class InorderIterator implements java.util.Iterator {
    // Store the elements in a list
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
    private int current = 0; // Point to the current element in list

    public InorderIterator() {
      inorder(); // Traverse binary tree and store elements in list
    }

    /** Inorder traversal from the root*/
    private void inorder() {
      inorder(root);
    }

    /** Inorder traversal from a subtree */
    private void inorder(TreeNode<E> root) {
      if (root == null)return;
      inorder(root.left);
      list.add(root.element);
      inorder(root.right);
    }

    /** Next element for traversing? */
    public boolean hasNext() {
      if (current < list.size())
        return true;
      return false;
    }

    /** Get the current element and move cursor to the next */
    public Object next() {
      return list.get(current++);
    }

    /** Remove the current element and refresh the list */
    public void remove() {
      delete(list.get(current)); // Delete the current element
      list.clear(); // Clear the list
      inorder(); // Rebuild the list
    }
  }

  /** Remove all elements from the tree */
  public void clear() {
    root = null;
    size = 0;
  }
}
