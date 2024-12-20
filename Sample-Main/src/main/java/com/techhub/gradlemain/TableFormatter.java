package com.techhub.gradlemain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableFormatter {

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

    /* The PERCENTAGE_MINUS Constant */
    private static final String EQUAL = "=";

    /* The EMPTY_TEXT Constant */
    private static final String EMPTY_TEXT = "";

    /* The ZERO Constant */
    private static final byte ZERO = 0;

    /* The TWO Constant */
    private static final byte TWO = 2;

    /* The THIRTY Constant */
    private static final byte THIRTY = 30;

    /* The maxColumnWidth  */
    private final int[] maxColumnWidth;

    /* The table headers  */
    private final String[] headers;

    /* The table columns data */
    private final String[][] data;

    /* The columnWidths  */
    private int[] columnWidths;

    private boolean enableRowSeparator;

    public TableFormatter(String[] headers, String[][] data) {
        this.headers = headers;
        this.data = data;
        this.maxColumnWidth = new int[this.headers.length];
        Arrays.fill(this.maxColumnWidth, THIRTY);
        this.calculateColumnWidths();
    }

    private void calculateColumnWidths() {
        int columns = this.headers.length;
        this.columnWidths = new int[columns];

        for (int i = ZERO; i < columns; i++) {
            columnWidths[i] = this.headers[i].length();
        }

        for (String[] row : this.data) {
            for (int i = ZERO; i < columns; i++) {
                String[] wrappedText = wrapText(row[i], this.maxColumnWidth[i]);
                for (String line : wrappedText) {
                    if (line.length() > columnWidths[i]) {
                        columnWidths[i] = line.length();
                    }
                }
            }
        }
    }

    public String getTableText() {

        StringBuilder tableText = new StringBuilder();

        String headSeparator = this.getSeparator(EQUAL);
        String rowSeparator = EMPTY_TEXT;

        if (this.enableRowSeparator) {
            rowSeparator = this.getSeparator(MINUS) + NEW_LINE;
        }

        tableText.append(headSeparator)
                .append(NEW_LINE)
                .append(this.getRowText(this.headers))
                .append(headSeparator)
                .append(NEW_LINE);

        for (String[] row : this.data) {
            tableText.append(this.getRowText(row)).append(rowSeparator);
        }

        if (!this.enableRowSeparator) {
            tableText.append(this.getSeparator(MINUS));
        }

        return tableText.toString();
    }

    public StringBuilder getRowText(String[] row) {

        StringBuilder rowText = new StringBuilder();
        List<String[]> wrappedColumns = new ArrayList<>();
        int maxLines = ZERO;
        for (int i = ZERO; i < row.length; i++) {
            String[] wrappedText = this.wrapText(row[i], this.maxColumnWidth[i]);
            wrappedColumns.add(wrappedText);
            maxLines = Math.max(maxLines, wrappedText.length);
        }

        StringBuilder rowWrapText = new StringBuilder();
        for (int line = ZERO; line < maxLines; line++) {
            rowWrapText.setLength(ZERO);
            for (int i = ZERO; i < wrappedColumns.size(); i++) {
                rowWrapText.append(VERTICAL_BAR);
                rowWrapText.append(ONE_SPACE);
                String text = (line < wrappedColumns.get(i).length) ? wrappedColumns.get(i)[line] : EMPTY_TEXT;
                StringBuilder sb = new StringBuilder(PERCENTAGE_MINUS)
                        .append(this.columnWidths[i]).append(S);
                rowWrapText.append(String.format(sb.toString(), text));
                rowWrapText.append(ONE_SPACE);
            }
            rowWrapText.append(VERTICAL_BAR).append(NEW_LINE);
            rowText.append(rowWrapText);
        }
        return rowText;
    }

    private String[] wrapText(String text, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int start = ZERO;
        while (start < text.length()) {
            int end = Math.min(start + maxWidth, text.length());
            lines.add(text.substring(start, end));
            start = end;
        }
        return lines.toArray(new String[ZERO]);
    }

    public String getSeparator(String separator) {
        StringBuilder headSeparator = new StringBuilder();
        for (int width : this.columnWidths) {
            headSeparator.append(PLUS);
            headSeparator.append(separator.repeat(width + TWO));
        }
        headSeparator.append(PLUS);
        return headSeparator.toString();
    }

    public void setColumnWidths(int... widths) {
        if (widths.length == this.maxColumnWidth.length) {
            System.arraycopy(widths, ZERO, this.maxColumnWidth, ZERO, this.maxColumnWidth.length);
            System.arraycopy(widths, ZERO, this.columnWidths, ZERO, this.maxColumnWidth.length);
        }
    }

    public void setColumnWidth(int columnIndex, int width) {
        this.maxColumnWidth[columnIndex] = width;
        this.columnWidths[columnIndex] = width;
    }

    public void enableRowSeparator(boolean flag) {
        this.enableRowSeparator = flag;
    }
}
