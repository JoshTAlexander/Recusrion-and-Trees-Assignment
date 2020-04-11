import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


/** @author 
 *  <Josh Alexander>
 * This class contains the test cases for Worksheet2 solutions.
 *  <WRITE YOUR TEST CASES BELOW>
 */

public class Worksheet2Test {
	
 @Test // test of negate all
	  public void test1() {
		 
		Tree<Integer>t = new Tree<>(86, new Tree<>(47, new Tree<>(-11), new Tree<>(52)),
				new Tree<>(99, new Tree<>(91), new Tree<>()));
		Tree<Integer>expected = new Tree<>(-86, new Tree<>(-47, new Tree<>(11), new Tree<>(-52)),
				new Tree<>(-99, new Tree<>(-91), new Tree<>()));
	    
	    Tree<Integer> actual = Worksheet2.negateAll(t);
	    assertEquals(expected, actual);
	    
	 }

 @Test //test of all even for true
     public void test2() {
	 
		Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
				new Tree<>(98, new Tree<>(92), new Tree<>()));
		boolean expected = true;
	    
	    boolean actual = Worksheet2.allEven(t);
	    assertEquals(expected, actual);
	    
	 }
 
 @Test //test of all even for false
 public void test3() {
 
	Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	boolean expected = false;
    
    boolean actual = Worksheet2.allEven(t);
    assertEquals(expected, actual);
    
 }
 
 @Test //test of depth
 public void test4() {
 
	Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	int expected = 2;
    
    int actual = Worksheet2.depth(t,52);
    assertEquals(expected, actual);
    
 }
 
 @Test //test of preorder
 public void test5() { 
 
	Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	List<Integer>expected = new List<>(86,new List<>(44,new List<>(22,new List<>(52,new List<>(98,new List<>(91,new List<>()))))));
    
    List<Integer> actual = Worksheet2.preorder(t);
    assertEquals(expected, actual);
    
 }
 
 @Test //test of search tree for true
 public void test6() {
	 
	Tree<Integer>t = new Tree<>(86, new Tree<>(47, new Tree<>(-11), new Tree<>(49)),
			new Tree<>(99, new Tree<>(91), new Tree<>()));
	boolean expected = true;
   
   boolean actual = Worksheet2.isSearchTree(t);
   assertEquals(expected, actual);
   
}
 
 @Test //test of search tree for false
 public void test7() { 
	 
	Tree<Integer>t = new Tree<>(86, new Tree<>(47, new Tree<>(-11), new Tree<>(100)),
			new Tree<>(99, new Tree<>(91), new Tree<>()));
	boolean expected = false;
   
   boolean actual = Worksheet2.isSearchTree(t);
   assertEquals(expected, actual);
   
}
 
 @Test // test for max
 public void test8() {
 
	Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	int expected = 98;
    
    int actual = Worksheet2.max(t);
    assertEquals(expected, actual);
    
 }
 
@Test // test of delete with 2 children
 public void test9() {
	 
	Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	Tree<Integer> expected = new Tree<>(52, new Tree<>(44, new Tree<>(22), new Tree<>()),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
    
    Tree<Integer> actual = Worksheet2.delete(t,86);
    assertEquals(expected, actual);
    
 }	

@Test // test of delete with 1 child
public void test10() {
	 
	Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	Tree<Integer> expected = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(91, new Tree<>(), new Tree<>()));
   
   Tree<Integer> actual = Worksheet2.delete(t,98);
   assertEquals(expected, actual);
   
}

@Test // test of delete no children
public void test11() {
	 
	Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	Tree<Integer> expected = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>()),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
   
   Tree<Integer> actual = Worksheet2.delete(t,52);
   assertEquals(expected, actual);
   
}

@Test //test of is balanced for false
public void test12() { 
	 
	Tree<Integer>t = new Tree<>(86, new Tree<>(47, new Tree<>(-11), new Tree<>(100)),
			new Tree<>());
	boolean expected = false;
  
  boolean actual = Worksheet2.isHeightBalanced(t);
  assertEquals(expected, actual);
  
}

@Test //test of is balanced for true
public void test13() { 
	 
	Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	boolean expected = true;
  
  boolean actual = Worksheet2.isHeightBalanced(t);
  assertEquals(expected, actual);
  
}


@Test //test of insert when x<root
public void test14() { 
	 
	Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	Tree<Integer>expected = new Tree<>(86, new Tree<>(44, new Tree<>(5), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
  
	Tree<Integer> actual = Worksheet2.insertHB(t,5);
  assertEquals(expected, actual);
  
}

@Test //test of insert when x>root
public void test15() { 
	 
	Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	Tree<Integer>expected = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>(100)));
	Tree<Integer> actual = Worksheet2.insertHB(t,100);
  assertEquals(expected, actual);
  
}

@Test //test of deleteHB
public void test16() { 
	 
	Tree<Integer>t = new Tree<>(86, new Tree<>(44, new Tree<>(22), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	Tree<Integer>expected = new Tree<>(86, new Tree<>(44, new Tree<>(), new Tree<>(52)),
			new Tree<>(98, new Tree<>(91), new Tree<>()));
	Tree<Integer> actual = Worksheet2.deleteHB(t,22);
  assertEquals(expected, actual);
  
}

}

