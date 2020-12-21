package com.okgo.leetcode.stack.q341;

import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/11 17:40
 * @title Function
 */
public interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
}
