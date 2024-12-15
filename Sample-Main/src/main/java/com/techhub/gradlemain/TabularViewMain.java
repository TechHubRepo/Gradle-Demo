package com.techhub.gradlemain;

public class TabularViewMain {

    public static void main(String[] args) {
        String[] headers = {"Name", "Age", "City", "Occupation"};
        String[][] data = {
                {"Ram Niwash", "30", "New York", "Engineer"},
                {"Purshtom Dass", "31", "San Francisco", "Designer"},
                {"Prem Kumar", "37", "Chicago", "Teacher"},
                {"Kuldeep Singh", "23", "Los Angeles", "Doctor"},
                {"Sajjan Kumar", "34", "Los Angeles", "Police Officer"}
        };
        TabularView tabularView = new TabularView(headers, data);
        System.out.println(tabularView.getTabularText());
    }
}
