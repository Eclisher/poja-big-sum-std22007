package com.company.base.endpoint.rest.controller;

import com.company.base.endpoint.BigSumController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigSumControllerTest {

    @Test
    public void testGetBigSum() {
        BigSumController bigSumController = new BigSumController();
        String result = bigSumController.getBigSum("1000000000000000000000", "2");
        assertEquals("1000000000000000000002", result, "The result should be the sum of the two numbers");
    }

    @Test
    public void testGetBigSumInvalidInput() {
        BigSumController bigSumController = new BigSumController();
        String result = bigSumController.getBigSum("abc", "def");
        assertEquals("Invalid input. Please provide valid numeric values for 'a' and 'b'.", result,
                "The result should be an error message for invalid input");
    }
    @Test
    public void testGetBigSumNegativeNumbers() {
        BigSumController bigSumController = new BigSumController();
        String result = bigSumController.getBigSum("-1000000000000000000000", "-2");
        assertEquals("-1000000000000000000002", result, "The result should be the sum of the two negative numbers");
    }

    @Test
    public void testGetBigSumZero() {
        BigSumController bigSumController = new BigSumController();
        String result = bigSumController.getBigSum("0", "0");
        assertEquals("0", result, "The result should be zero for the sum of two zeros");
    }

    @Test
    public void testGetBigSumLargeNumbers() {
        BigSumController bigSumController = new BigSumController();
        String result = bigSumController.getBigSum(
                "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "1"
        );
        assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                result, "The result should be the sum of a large number and 1");
    }
}
