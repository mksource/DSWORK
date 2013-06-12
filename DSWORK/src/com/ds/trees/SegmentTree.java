package com.ds.trees;

/**
 * Refer http://letuskode.blogspot.in/2013/
 * @author karthik
 * Segment tree is mainly used to solve the following problem (solve the range queries)
 *   We if have array arr[0....n-1] we should be able to 
 *   a) Find the sum of elements from index l to index r where 0<=l<=r<=n-1
 *   b) Change the value of a specified element of the array[i]=x where 0<=i<=n-1
 *   
 *   The brute force way of solving this problem will give us O(n) for query operation O(1) for update operation
 *   If we store the sum till the index i where i is 0<=i<=n-1 in another array then we will have O(1) for the 
 *   query operation and O(n) for update operation 
 *   
 *   We need to O(logn) time for both the operations 
 *   
 *   Representation of Segment Trees 
 *   
 *   a)The leaf nodes represent the elements of the array
 *   b) The internal nodes represent the merging of the leaf nodes. This will be different for different 
        For example it could be the sum of the nodes.
        
     Segment Tree basically support three operations
     
     a) merge
     b)split
     c)update_single_subtree   
 *      
 */


public class SegmentTree {

}
