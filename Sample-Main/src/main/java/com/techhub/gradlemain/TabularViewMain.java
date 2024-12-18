package com.techhub.gradlemain;

public class TabularViewMain {

    public static void main(String[] args) {
//        String[] headers = {"Name", "Age", "City", "Occupation"};
//        String[][] data = {
//                {"Ram Niwash", "30", "New York", "Engineer"},
//                {"Purshtom Dass", "31", "San Francisco", "Designer"},
//                {"Prem Kumar", "37", "Chicago", "Teacher"},
//                {"Kuldeep Singh", "23", "Los Angeles", "Doctor"},
//                {"Sajjan Kumar", "34", "Los Angeles", "Police Officer"}
//        };
//        TabularView tabularView = new TabularView(headers, data);
//        System.out.println(tabularView.getTabularText());

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

        TableFormatter tableFormatter = new TableFormatter(headers,data);
//        tableFormatter.enableRowSeparator(true);
//        tableFormatter.setColumnWidths(10,3,50,100);
//        tableFormatter.setColumnWidth(2,100);
//        tableFormatter.setColumnWidth(3,100);
        String tableText = tableFormatter.getTableText();
        System.out.println(tableText);
    }
}
