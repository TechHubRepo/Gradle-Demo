package com.techhub.gradlemain;

public class Table {

    private final String[] headers;

    private final String[][] data;

    private int[] columnWidths;

    public static void main(String[] args) {
        // Example data
        String[] headers = {"Name", "Age", "City", "Occupation"};
        String[][] data = {
                {"Alice", "30", "New York", "Engineer"},
                {"Bob", "25", "San Francisco", "Designer"},
                {"Charlie", "35", "Chicago", "Teacher"},
                {"Diana", "28", "Los Angeles", "Doctor"}
        };


        System.out.println(new Table(headers, data).getTableText());
    }

    public Table(String[] headers, String[][] data){
        this.headers = headers;
        this.data = data;
        calculateColumnWidths();
    }

    public String getTableText() {

        // Print header row
        String separator = getHeaderSeparator(this.columnWidths);
        StringBuilder tableText = getRow(this.headers, this.columnWidths);
        tableText.insert(0,"\n").insert(0,separator).append("\n").append(separator).append("\n");

        // Print data rows
        for (String[] row : this.data) {
            tableText.append(getRow(row, this.columnWidths)).append("\n");
        }
        tableText.append(separator).append("\n");
        return tableText.toString();
    }

    private void calculateColumnWidths() {
        int columns = headers.length;
        this.columnWidths = new int[columns];

        // Initialize with header lengths
        for (int i = 0; i < columns; i++) {
            this.columnWidths[i] = this.headers[i].length();
        }

        // Update with max data lengths
        for (String[] row : this.data) {
            for (int i = 0; i < columns; i++) {
                if (row[i].length() > this.columnWidths[i]) {
                    this.columnWidths[i] = row[i].length();
                }
            }
        }
    }

    private StringBuilder getRow(String[] row, int[] columnWidths) {
        StringBuilder rowBuilder = new StringBuilder();
        // Build row with padding and alignment
        for (int i = 0; i < row.length; i++) {
            rowBuilder.append("|");
            rowBuilder.append(" ");
            rowBuilder.append(String.format("%-" + columnWidths[i] + "s", row[i]));
            rowBuilder.append(" ");
        }
        rowBuilder.append("|");
        return rowBuilder;
    }

    private String getHeaderSeparator(int[] columnWidths) {
        StringBuilder separator = new StringBuilder();
        for (int width : columnWidths) {
            separator.append("+");
            separator.append("-".repeat(width + 2));
        }
        separator.append("+");
        return separator.toString();
    }
}
