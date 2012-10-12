package com.ffbit;

/**
 * Recursive implementation of the Pascal Triangle.
 * 
 * @author ffbit
 * 
 */
public class PascalTriangle {

    /**
     * Get element of the Pascal Triangle for the following zero-base cell and
     * row indexes.
     * 
     * @param cell
     *            zero-based positive cell index.
     * @param row
     *            zero-based positive row index.
     * @return element for the following zero-base cell and row indexes.
     * @throws IllegalArgumentException
     *             if
     *             <ul>
     *             <li>cell index is negative</li>
     *             <li>cell index is greater than row one</li>
     *             </ul>
     */
    public int getElement(int cell, int row) {
        if (cell > row) {
            throw new IllegalArgumentException("Cell is greater than row: "
                    + cell + ">" + row);
        }

        if (cell < 0) {
            throw new IllegalArgumentException("Cell can't be negative: "
                    + cell);
        }

        return compute(cell, row);
    }

    private int compute(int cell, int row) {
        if (cell == 0 || cell == row) {
            return 1;
        } else {
            int offset = 1;
            return compute(cell - offset, row - offset)
                    + compute(cell, row - offset);
        }
    }
}
