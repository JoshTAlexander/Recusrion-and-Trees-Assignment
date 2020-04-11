/**
 * @author <Josh Alexander>
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1

	/**
	 * @param t a tree
	 * @return opposite signs of all elements
	 */
	static Tree<Integer> negateAll(Tree<Integer> t) {
		if (t.isEmpty()==true) {
			return new Tree<>();
		}
		else return new Tree<Integer>(t.getValue()*-1,negateAll(t.getLeft()), negateAll(t.getRight()));
	}

	// Exercise 2
	
	/**
	 * @param a a tree
	 * @return true if all elements are even, false otherwise
	 */
	static boolean allEven(Tree<Integer> a) {
		if (a.isEmpty()==true) {
			return true;
		}
		else if (a.getValue()%2==0) {
			return allEven(a.getLeft()) && allEven(a.getRight()) ;
		}
		else return false;
		}

	// Exercise 3

	/**
	 * @param a a tree
	 * @param x an element in the tree
	 * @return the depth of x
	 */
	static int depth(Tree<Integer> a, int x) {
		if (a.isEmpty()==true) {
			return -1;
		}
		else if(x > a.getValue()) {
        	return 1 + depth(a.getRight(),x);
        }
		else if (x < a.getValue()) {
        	return 1 + depth (a.getLeft(),x);
        }
        else return 0;
	}

	// Exercise 4
    /**
	 * @param <E> 
	 * @param a a list
	 * @param b a list
	 * @return the lists merged
	 */
	static<E> List<E> append(List<E> a, List<E> b){
		if (a.isEmpty()) {
			return b;
		}
		else {
			return new List<E>(a.getHead(), append(a.getTail(), b));
		}
	}
	
	/**
	 * @param <E>
	 * @param a a tree
	 * @return a preorder list of elements
	 */	
    static <E> List<E> preorder(Tree<E> a) { 
		if (a.isEmpty()==true) {
			return new List<E>();
		}
		else if (a.getLeft().isEmpty()==true) {
			return new List<E>(a.getValue(),preorder(a.getRight()));
		}
		else if (a.getLeft().isEmpty()==false) {
			return new List<E>(a.getValue(),append(preorder(a.getLeft()), preorder(a.getRight())));
		}
		else return new List<E>();
    }

    // Exercise 5
    /**
     * @param a a tree
     * @return the minimum value of the tree
     */
    static int min(Tree<Integer> a) { if (a.isEmpty()==true) {
		throw new IllegalArgumentException();
	    }
	    if (a.getLeft().isEmpty()==false && a.getLeft().getValue() < a.getValue()) {
		return max(a.getLeft());
	    }
	    else return a.getValue();
    }

    /**
     * @param a a tree
     * @return true if the tree is a BST
     */
static boolean isSearchTree(Tree<Integer> a) {
	if (a.isEmpty()==true) {
		return true;
	}
	else if (a.getLeft().isEmpty()==false && a.getValue() < max(a.getLeft())) {
		return false;
	   }
	else if (a.getRight().isEmpty()==false && a.getValue() > min(a.getRight())) {
			return false;
	 }
	else return isSearchTree(a.getRight()) && isSearchTree(a.getLeft());
	}

    // Exercise 6

	/**
	 * @param a a tree
	 * prints out the elements in descending order
	 */
	static void printDescending(Tree<Integer> a) {
		if (a.isEmpty()==true) {
			return;
		}
		printDescending(a.getRight());
		if (a.isEmpty()==false) {
			System.out.print(a.getValue() + " ");
		}
		printDescending(a.getLeft());
	}

	// Exercise 7

	/**
	 * @param a a tree
	 * @return the max element in the tree
	 */
	static int max(Tree<Integer> a) {
		if (a.isEmpty()==true) {
			throw new IllegalArgumentException();
		}
		else if (a.getRight().isEmpty()==false && a.getRight().getValue() > a.getValue()) {
			return max(a.getRight());
		}
		else return a.getValue();
	}

	// Exercise 8

	/**
	 * @param a a tree
	 * @param x the element to be deleted
	 * @return a new BST without x 
	 */
	static Tree<Integer> delete(Tree<Integer> a, int x) {
		if (a.isEmpty()==true) {
		    return new Tree<Integer>();
		}
		else if (a.getValue()==x && a.getLeft().isEmpty()==true && a.getRight().isEmpty()==true) {
		    return new Tree<Integer>();
		}
		else if (a.getValue()==x && a.getLeft().isEmpty()==false && a.getRight().isEmpty()==true) {
			return new Tree<Integer>(a.getLeft().getValue(), a.getLeft().getLeft(), a.getRight());
		}
		else if (a.getValue()==x && a.getLeft().isEmpty()==true && a.getRight().isEmpty()==false) {
			return new Tree<Integer>(a.getRight().getValue(), a.getLeft(), a.getRight().getRight());
		}
		else if (a.getValue()==x && a.getLeft().isEmpty()==false && a.getRight().isEmpty()==false) {
			return new Tree<Integer>(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), a.getRight());
		}
		else return new Tree<>(a.getValue(),delete(a.getLeft(),x), delete(a.getRight(),x));
		
	}

	// Exercise 9
	/**
	 * @param <E>
	 * @param a a tree
	 * @return true if the tree is balanced, else false
	 */
	static <E> boolean isHeightBalanced(Tree<E> a) {
		if (a.isEmpty()==true) {
			return true;
		}
		else if (Math.abs(a.getRight().getHeight() - a.getLeft().getHeight()) > 1){
	        return false;
		}
		else return isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());
	}

	// Exercise 10
	
	/**
	 * @param a a tree
	 * @return the balance factor between left and right
	 */
	static int balanceFactor(Tree<Integer> a) {
		return ( a.getRight().getHeight() - a.getLeft().getHeight());
	}

	/**
	 * @param a a tree
	 * @param x a value to insert
	 * @return a AVL tree with x included
	 */
	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		if (a.isEmpty()==true) {
			return new Tree<>(x,new Tree<>(),new Tree<>());
			
		}
		else if (x<a.getValue()) {
			if (isHeightBalanced(a)==true) {
				if (a.getLeft().isEmpty()) {
					return new Tree<>(a.getValue(),new Tree<>(x),a.getRight());
				}
				else return new Tree<>(a.getValue(),insertHB(a.getLeft(),x),a.getRight());
			}
			else if (balanceFactor(a)==-2) {
				if(balanceFactor(a.getLeft())==-1) {
					return new Tree<>(a.getLeft().getValue(),a.getLeft().getLeft(),new Tree<>(a.getValue()));
				}
				else if(balanceFactor(a.getLeft())==1) {
					return new Tree<>(a.getLeft().getRight().getValue(),new Tree<>(a.getLeft().getValue()),new Tree<>(a.getValue()));
				}
			}
		}
		else if (x>a.getValue()) {
			if (isHeightBalanced(a)==true) {
				if (a.getRight().isEmpty()==true) {
					return new Tree<>(a.getValue(),a.getLeft(), new Tree<>(x));
				}
				else return new Tree<>(a.getValue(),a.getLeft(),insertHB(a.getRight(),x));
			}
			else if (balanceFactor(a)==2) {
				if(balanceFactor(a.getRight())==1) {
					return new Tree<>(a.getRight().getValue(),new Tree<>(a.getValue()),a.getRight().getRight());
				}
				else if(balanceFactor(a.getRight())==-1) {
					return new Tree<>(a.getRight().getLeft().getValue(),new Tree<>(a.getValue()),new Tree<>(a.getRight().getValue()));
				}
			}
		}
		else return new Tree<>(a.getValue(),insertHB(a.getLeft(),x),insertHB(a.getRight(),x));
		return a;
	}

	/**
	 * @param a a tree
	 * @param x a number to be deleted
	 * @return a AVL tree with x deleted
	 */
	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		a=delete(a,x);
        if (isHeightBalanced(a)==true) {
        	return a;
        }
        else if (balanceFactor(a)==-2) {
			if(balanceFactor(a.getLeft())==-1) {
				return new Tree<>(a.getLeft().getValue(),a.getLeft().getLeft(),new Tree<>(a.getValue()));
			}
			else if(balanceFactor(a.getLeft())==1) {
				return new Tree<>(a.getLeft().getRight().getValue(),new Tree<>(a.getLeft().getValue()),new Tree<>(a.getValue()));
			}
		}
        else if (balanceFactor(a)==2) {
			if(balanceFactor(a.getRight())==1) {
				return new Tree<>(a.getRight().getValue(),new Tree<>(a.getValue()),a.getRight().getRight());
			}
			else if(balanceFactor(a.getRight())==-1) {
				return new Tree<>(a.getRight().getLeft().getValue(),new Tree<>(a.getValue()),new Tree<>(a.getRight().getValue()));
			}
	    }
        else return new Tree<>(a.getValue(),deleteHB(a.getLeft(),x),deleteHB(a.getRight(),x));
		return a;
	}

}

