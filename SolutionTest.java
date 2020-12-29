package com.blankj.hard._025;
import com.blankj.structure.ListNode;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import java.lang.ArithmeticException;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void TestReverseKGroupsWithHeadNull_1(){
        ListNode actual = solution.reverseKGroup(ListNode.createTestData("[]"), -1);
        assertNull(actual);
    }


    @Test
    public void TestReverseKGroupsWithHeadNull_2(){
        ListNode actual = solution.reverseKGroup(ListNode.createTestData("[]"), 0);
        assertNull(actual);
    }




    @Test
    public void TestReverseKGroupsWithHeadNull_3(){
        ListNode actual = solution.reverseKGroup(ListNode.createTestData("[]"), 1);
        assertNull(actual);
    }

    @Test
    public void TestReverseKGroupWith_k_isZero() throws Exception {
        try {
            ListNode actual = solution.reverseKGroup(ListNode.createTestData("[1]"), 0);
            fail("Not throw exception");
        } catch (Exception e) {
            assertThat(e, CoreMatchers.instanceOf(ArithmeticException.class));
            assertEquals(e.getMessage(), "/ by zero");
        }
    }

    @Test
    public void TestReverseKGroupWith_k_isN() throws Exception {
        try {
            ListNode actual = solution.reverseKGroup(ListNode.createTestData("[1]"), -1);
            fail("Not throw exception");
        } catch (Exception e) {
            assertThat(e, CoreMatchers.instanceOf(ArithmeticException.class));
            assertEquals(e.getMessage(), "/ k must greater than 0");
        }
    }

    @Test
    public void TestReverseKGroupsWith_k_(){
        ListNode actual = solution.reverseKGroup(ListNode.createTestData("[1]"), 1);
        String actualString = actual.toString(actual);
        ListNode expect = ListNode.createTestData("[1]");
        String expectString = expect.toString(expect);
        assertEquals(expectString, actualString);
    }

    @Test
    public void TestReverseKGroupsWith_k_greaterTh(){
        ListNode actual = solution.reverseKGroup(ListNode.createTestData("[1]"), 2);
        String actualString = actual.toString(actual);
        ListNode expect = ListNode.createTestData("[1]");
        String expectString = expect.toString(expect);
        assertEquals(expectString, actualString);
    }

    @Test
    public void TestReverseKGroupsWith_k_isSmThanLengthOfListNode(){
        ListNode actual = solution.reverseKGroup(ListNode.createTestData("[1,2,3]"), 2);
        String actualString = actual.toString(actual);
        ListNode expect = ListNode.createTestData("[2,1,3]");
        String expectString = expect.toString(expect);
        assertEquals(expectString, actualString);
    }

    @Test
    public void TestReverseKGroupsWith_k_isEqualToLength(){
        ListNode actual = solution.reverseKGroup(ListNode.createTestData("[1,2,3]"), 3);
        String actualString = actual.toString(actual);
        ListNode expect = ListNode.createTestData("[3,2,1]");
        String expectString = expect.toString(expect);
        assertEquals(expectString, actualString);
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        ListNode actual = solution.reverseKGroup(ListNode.createTestData("[1,2,3,4,5,6,7,8]"), 3);
//        String actualString = actual.toString(actual);
//        ListNode expect = ListNode.createTestData("[3,2,1,6,5,4,7,8]");
//        String expectString = expect.toString(expect);
//        assertEquals(expectString, actualString);
//        assert
//    }
}