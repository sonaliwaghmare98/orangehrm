package com.skillio.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Sample {

    String x, y, result;

    List<String> listOfFruits = new ArrayList<>();

    Map<String, Integer> fruits = new HashMap<>();

    Map<String, List> fruitsList = new HashMap<>();

    String fruitName;

    @Given("Executing first step of first scenario")
    public void m1() {
        System.out.println("First step of first scenario");
    }

    @Given("print hello world")
    public void printHelloWorld() {
        System.out.println("Hello world!");
    }

    @Given("print hi")
    public void printHi() {
        System.out.println("Hi");
    }

    @Given("I have {string} and {string}")
    public void acceptTwoNumbers(String x, String y) {
        this.x = x;
        this.y = y;
    }

    @When("I add them")
    public void addNumbers() {
        result = x + y;
    }

    @Then("print the result")
    public void addResult() {
        System.out.println("Result: " + result);
    }

    @Given("I have following fruits:")
    public void acceptLisOfFruits(List<String> listOfFruits) {
        this.listOfFruits = listOfFruits;
    }

    @Then("print the entire list")
    public void printFruitsList() {
        for (String fruit : listOfFruits) {
            System.out.println(fruit);
        }
    }

    @Given("I have following fruits with quantity:")
    public void acceptFruitsWithQuantity(Map<String, Integer> fruits) {
        this.fruits = fruits;
    }

    @Then("print the entire list of fruits")
    public void printFruitList() {
        Set<String> keys = fruits.keySet();
        for (String key : keys) {
            System.out.println(fruits.get(key));
        }
    }

    @Given("I have following table of fruits:")
    public void dataTableOfFruits(DataTable fruitsList) {
        this.fruitsList = fruitsList.asMap(String.class, List.class);
    }

    @Then("print the entire table of fruits")
    public void printDataTableOfFruits() {
        Set<String> keys = fruitsList.keySet();
        for (String key : keys) {
            System.out.printf("%-10s", key);
            List data = fruitsList.get(key);
            for (Object value : data) {
                System.out.printf("%-7s", value);
            }
            System.out.println();
        }

    }

    @Given("I have a {string}")
    public void acceptFruit(String fruitName) {
        this.fruitName = fruitName;

    }

    @Then("print its name")
    public void printFruitName() {
        System.out.println("Fruit Name: " + fruitName);
    }

    @Given("I have a {int}")
    public void acceptFromExcel(int rowNo) throws IOException {
        String basePath = System.getProperty("user.dir");
        String filePath = "/src/test/resources/DataFiles/fruits.xlsx";
        FileInputStream fis = new FileInputStream(basePath + filePath);
        Workbook book= new XSSFWorkbook(fis);
        Sheet sheet=book.getSheetAt(0);
        Row row=sheet.getRow(rowNo);
        fruitName=row.getCell(1).getStringCellValue();

    }
}
