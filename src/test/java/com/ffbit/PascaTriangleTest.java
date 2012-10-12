package com.ffbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.ffbit.PascalTriangle;

@RunWith(Parameterized.class)
public class PascaTriangleTest {
    private int cell;
    private int row;
    private int expected;

    private PascalTriangle triangle;

    public PascaTriangleTest(int cell, int row, int expected) {
        this.cell = cell;
        this.row = row;
        this.expected = expected;
    }

    @Before
    public void init() {
        triangle = new PascalTriangle();
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                        { 0, 0, 1 },
                        { 0, 1, 1 },
                        { 1, 1, 1 },
                        { 1, 2, 2 },
                        { 3, 7, 35 }
                });
    }

    @Test
    public void testElement() throws Exception {
        assertThat(triangle.getElement(cell, row), equalTo(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCellGreaterThanRow() throws Exception {
        triangle.getElement(2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCell() throws Exception {
        triangle.getElement(-1, 0);
    }

}
