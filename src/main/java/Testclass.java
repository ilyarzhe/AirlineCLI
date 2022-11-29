package main.java;


import java.util.ArrayList;
import java.util.Arrays;

public class Testclass {
    public static void main(String[] args){
    ArrayList<String> numbers = new ArrayList<>(Arrays.asList("h","r"));
    System.out.println(numbers);
    numbers.remove("k");
    System.out.println(numbers);
    }
}
