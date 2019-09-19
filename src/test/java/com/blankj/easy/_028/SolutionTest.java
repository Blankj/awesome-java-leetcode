package com.blankj.easy._028;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void TestImplementStrWithNeedleIsPartOfHayStack(){
        Integer actual = solution.strStr("1,2,3,4", "1,2");
        Integer expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void TestImplementStrWithNeedleIsNotPartOfHayStack(){
        Integer actual = solution.strStr("1,2,3,4", "2,1");
        Integer expected = -1;
        assertEquals(actual, expected);
    }

    @Test
    public void TestImplementStrWithNeedleIsNone(){
        Integer actual = solution.strStr("1,2,3,4", "");
        Integer expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void TestImplementStrWithLenNeedleGreaterThanLenHayStack(){
        Integer actual = solution.strStr("1,2,3,4", "1,2,3,4,5");
        Integer expected = -1;
        assertEquals(actual, expected);
    }

    @Test
    public void TestImplementStrWithLenNeedleEqualToLenHayStack(){
        Integer actual = solution.strStr("1,2,3,4", "1,2,3,4");
        Integer expected = 0;
        assertEquals(actual, expected);
    }

}