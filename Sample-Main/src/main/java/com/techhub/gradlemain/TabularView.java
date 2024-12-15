package com.techhub.gradlemain;

/**
 * TabularData is the text representation of Table data.
 *
 * @author Ram Niwash
 */
public class TabularView {

    /* The NEW_LINE Constant */
    private static final String NEW_LINE = "\n";

    /* The VERTICAL_BAR Constant */
    private static final String VERTICAL_BAR = "|";

    /* The ONE_SPACE Constant */
    private static final String ONE_SPACE = " ";

    /* The PLUS Constant */
    private static final String PLUS = "+";

    /* The MINUS Constant */
    private static final String MINUS = "-";

    /* The STR_S Constant */
    private static final String S = "s";

    /* The PERCENTAGE_MINUS Constant */
    private static final String PERCENTAGE_MINUS = "%-";

    /* The ZERO Constant */
    private static final byte ZERO = 0;

    /* The TWO Constant */
    private static final byte TWO = 2;

    /* The headers of table */
    private final String[] headers;

    /* The rows data of table */
    private final String[][] data;

    /* Width of each column */
    private int[] columnWidths;

    public TabularView(String[] headers, String[][] data) {
        this.headers = headers;
        this.data = data;
        this.calculateColumnWidths();
    }

    public String getTabularText() {
        String headSeparator = this.getHeaderSeparator(this.columnWidths);
        StringBuilder tabularText = new StringBuilder(headSeparator);
        tabularText.append(NEW_LINE).append(this.getRowText(this.headers, this.columnWidths))
                .append(NEW_LINE).append(headSeparator);

        for (String[] row : this.data) {
            tabularText.append(NEW_LINE).append(this.getRowText(row, this.columnWidths));
        }

        tabularText.append(NEW_LINE).append(headSeparator);
        return tabularText.toString();
    }

    private void calculateColumnWidths() {
        int columns = headers.length;
        this.columnWidths = new int[columns];

        for (int i = ZERO; i < columns; i++) {
            this.columnWidths[i] = this.headers[i].length();
        }

        for (String[] row : this.data) {
            for (int i = ZERO; i < columns; i++) {
                if (row[i].length() > this.columnWidths[i]) {
                    this.columnWidths[i] = row[i].length();
                }
            }
        }
    }

    private StringBuilder getRowText(String[] row, int[] columnWidths) {
        StringBuilder rowBuilder = new StringBuilder();
        for (int i = ZERO; i < row.length; i++) {
            rowBuilder.append(VERTICAL_BAR);
            rowBuilder.append(ONE_SPACE);
            rowBuilder.append(String.format(PERCENTAGE_MINUS + columnWidths[i] + S, row[i]));
            rowBuilder.append(ONE_SPACE);
        }
        rowBuilder.append(VERTICAL_BAR);
        return rowBuilder;
    }

    private String getHeaderSeparator(int[] columnWidths) {
        StringBuilder headSeparator = new StringBuilder();
        for (int width : columnWidths) {
            headSeparator.append(PLUS);
            headSeparator.append(MINUS.repeat(width + TWO));
        }
        headSeparator.append(PLUS);
        return headSeparator.toString();
    }
}
