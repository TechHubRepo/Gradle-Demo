package com.techhub.gradlemain;

import java.util.ArrayList;
import java.util.List;

public class TableFormatter {

    public static void main(String[] args) {
        // Example data
        String[] headers = {"Name", "Age", "City", "Occupation"};
        String[][] data = {
                {"Alice", "30", "New York", "Engineer"},
                {"Bob", "25", "San Francisco", "Designer"},
                {"Charlie", "35", "Chicago", "Teacher"},
                {"Diana", "28", "Los Angeles", "Doctor"},
                {"Eleanor", "40", "A very long city name that exceeds fifty characters to test wrapping", "A very long occupation description that also exceeds fifty characters for wrapping"},
                {"Franklin Delano Roosevelt", "51", "Warm Springs, Georgia, USA", "President of the United States with a long term of service"},
                {"Jonathan Livingston Seagull", "N/A", "An imaginary beachside in the universe of the book", "Protagonist of a philosophical novel"},
                {"Alexandria Cassandra", "29", "A mystical city with a name that spans beyond thirty characters", "A creative artist and visionary with an extended portfolio"},
                {"Beatrice", "33", "A town with a historic background and scenic beauty", "Historian and writer with a passion for storytelling"}
        };

        // Print formatted table
        printTable(headers, data);
    }

    public static void printTable(String[] headers, String[][] data) {
        // Calculate column widths
        int[] columnWidths = calculateColumnWidths(headers, data);

        // Print header row
        printRow(headers, columnWidths, true);

        // Print data rows
        for (String[] row : data) {
            printRow(row, columnWidths, false);
        }
    }

    private static int[] calculateColumnWidths(String[] headers, String[][] data) {
        int columns = headers.length;
        int[] columnWidths = new int[columns];

        // Initialize with header lengths
        for (int i = 0; i < columns; i++) {
            columnWidths[i] = headers[i].length();
        }

        // Update with max data lengths
        for (String[] row : data) {
            for (int i = 0; i < columns; i++) {
                String[] wrappedText = wrapText(row[i], 30); // Assuming a max width of 30 characters
                for (String line : wrappedText) {
                    if (line.length() > columnWidths[i]) {
                        columnWidths[i] = line.length();
                    }
                }
            }
        }

        return columnWidths;
    }

    private static void printRow(String[] row, int[] columnWidths, boolean isHeader) {
        StringBuilder builder = new StringBuilder();

        // Wrap each column's text and calculate the maximum number of lines
        List<String[]> wrappedColumns = new ArrayList<>();
        int maxLines = 0;
        for (int i = 0; i < row.length; i++) {
            String[] wrappedText = wrapText(row[i], 30); // Assuming a max width of 30 characters
            wrappedColumns.add(wrappedText);
            maxLines = Math.max(maxLines, wrappedText.length);
        }

        // Print each line of the wrapped text
        for (int line = 0; line < maxLines; line++) {
            builder.setLength(0); // Clear the builder
            for (int i = 0; i < wrappedColumns.size(); i++) {
                builder.append("|");
                builder.append(" ");
                String text = (line < wrappedColumns.get(i).length) ? wrappedColumns.get(i)[line] : "";
                builder.append(String.format("%-" + columnWidths[i] + "s", text));
                builder.append(" ");
            }
            builder.append("|");
            System.out.println(builder);
        }

        // Print separator for headers
        if (isHeader) {
            StringBuilder separator = new StringBuilder();
            for (int width : columnWidths) {
                separator.append("+");
                separator.append("-".repeat(width + 2));
            }
            separator.append("+");
            System.out.println(separator);
        }
    }

    private static String[] wrapText(String text, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int start = 0;
        while (start < text.length()) {
            int end = Math.min(start + maxWidth, text.length());
            lines.add(text.substring(start, end));
            start = end;
        }
        return lines.toArray(new String[0]);
    }
}
