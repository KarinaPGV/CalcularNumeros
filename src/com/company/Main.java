package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> listNumbers = new ArrayList();
    public static void main(String[] args) {
        validationNumber();
    }

    private static void print(String message){
        System.out.println(message);
    }
    private static void printNumber(Integer gg){
        System.out.println(gg);
    }

    private static String input (String message){
        print(message);
        Scanner getNumber = new Scanner(System.in);
        return getNumber.nextLine();
    }

    private static Integer getUserNumbers () {
        return Integer.parseInt(input("Ingrese un número:"));
    }

    public static Integer media(Integer sumNumbers,Integer numLeng) {
        return sumNumbers/numLeng;
    }

    private static void validationNumber() {
        boolean validNumber = true;
        while (validNumber) {
            Integer addNumber =getUserNumbers();
            if (addNumber == -1) {
                validNumber= false;
                print("Finalizado el programa");
                print("El número más grande es:"+ String.valueOf(greaterNumberEntered()));
                print("El número más pequeño es:"+ String.valueOf(smallestNumberEntered()));
                SumNumbers(Operation.SumAllNumbers);
                SumNumbers(Operation.SumNegativeNumbers);
                SumNumbers(Operation.SumPositiveNumbers);
            } else {
                listNumbers.add(addNumber);
            }
        }
    }
    private static Integer greaterNumberEntered(){
       Integer greaterNumber=null;
        for(int number:listNumbers){
            if(greaterNumber==null){
                greaterNumber=number;
            }
            if(greaterNumber<number){
                greaterNumber=number;
            }

        }
    return greaterNumber;
    }

    private static Integer smallestNumberEntered(){
        Integer smallestNumber=null;
        for(int number:listNumbers){
            if(smallestNumber==null || smallestNumber>number){
                smallestNumber=number;
            }
        }
        return smallestNumber;
    }

    public enum Operation{
        SumPositiveNumbers,
        SumNegativeNumbers,
        SumAllNumbers,
    }

    public static void SumNumbers(Operation operation){
        Integer totalSum=0;
        Integer numleng=0;

        for(int number:listNumbers){
            switch(operation) {
                case SumAllNumbers:
                    numleng +=1;
                    totalSum += number;
                    break;
                case SumPositiveNumbers:
                    numleng +=1;
                    totalSum += number > 0 ? number: 0;
                    break;
                case SumNegativeNumbers:
                    numleng +=1;
                    totalSum += number < 0 ? number: 0;
                    break;
            }
        }
        printResults(totalSum,numleng,operation);
    }

    public static void printResults(Integer total, Integer numLeng, Operation operation) {
        switch (operation) {
            case SumAllNumbers:
                print("La suma de todos los valores ingresados es:" + total);
                break;
            case SumPositiveNumbers:
                print("La suma de todos los números positivos ingresados es:" + total);
                break;
            case SumNegativeNumbers:
                print("La suma de todos los números negativos ingresados es:" + total);
                break;
        }
        print("El promedio es:" + String.valueOf(media(total, numLeng)));
    }
}