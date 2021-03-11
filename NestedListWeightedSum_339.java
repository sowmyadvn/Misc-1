/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*
Time and space: O(N) where N is number of nested integers, Space: O(N)
Approach:
1. Iterate through entire list 
2. Check if the innerList is integer or a list
3. If integer, add the value to sum. If not, recursively call inner list and add it to sum
*/
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0)
            return 0;
        return dfs(nestedList, 0, 1, 0);
    }
    
    private int dfs(List<NestedInteger> nestedList, int index, int depth, int sum) {
        if(index == nestedList.size())
            return sum; 
        if(nestedList.get(index).isInteger()) {
            int val = nestedList.get(index).getInteger();
            sum = sum + dfs(nestedList, index+1, depth, sum + val*depth);
        }
        else {
            List<NestedInteger> innerList = nestedList.get(index).getList();
            sum = sum + dfs(innerList, 0, depth+1, 0);
        }
        return sum;
    }
}