package se.lexicon.streams_and_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import se.lexicon.streams_and_lambda.utility.NameService;
import se.lexicon.streams_and_lambda.utility.Person;
import se.lexicon.streams_and_lambda.utility.data_access.CSVReader;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
    public static void main( String[] args ){
    	
    	 //Getting the names from file
        List<String> femaleFirstNames = CSVReader.getFemaleFirstNames();
        List<String> maleFirstNames = CSVReader.getMaleFirstNames();
        List<String> lastNames = CSVReader.getLastNames();

        //Instantiating a NameService object
        NameService ns = new NameService(maleFirstNames,femaleFirstNames,lastNames);

        List<Person> persons = new ArrayList<>();
        //Creating 500 random persons and adding them to a list
        for(int i=0; i<500; i++){
            persons.add(ns.getNewRandomPerson());
        }

        Lab theLab = new Lab(persons);
       
        //Run your exercises here
        
        boolean run = true;

        while(run) {
        System.out.println("Which exercise do you run\nchoose between 1 <=> 11\n");
        System.out.println("1 == print out the first names\n"
        		+ "2 == Remove the words that have odd lengths\n"
        		+ "3 == Replace every word in the list with its upper case\n"
        		+ "4 == Convert every key-value pair of the map\n"
        		+ "5 == Create a new thread that prints\n"
        		+ "6 == By using stream create a new list\n"
        		+ "7 == Modify exercise 6\n"
        		+ "8 == Turn list persons into a stream\n"
        		+ "9 == Create a new list from this.persons\n"
        		+ "10 == list from persons that should only contain those with lastname");
        int op = sc.nextInt();
                
    	  switch(op) {
          case 1:
          	theLab.exercise1();
          	break;
          case 2:
          	theLab.exercise2();
          	break;
          case 3:
          	theLab.exercise3();
          	break;
          case 4:
          	theLab.exercise4();
          	break;
          case 5:
          	theLab.exercise5();
          	break;
          case 6:
          	theLab.exercise6();
          	break;
          case 7:
          	theLab.exercise7();
          	break;
          case 8:
          	theLab.exercise8();
          	break;
          case 9:
          	theLab.exercise9();
          	break;
          case 10:
          	theLab.exercise10();
          	break;
          case 11:
          	theLab.exercise11();
          	break;
          default: break;          
          }
    	  System.out.println("\nDo you want run again (y/n)?");
    	  String runAgain = sc.next().toLowerCase();
			if (runAgain.equals("y")) {
								
			} else {
				System.out.println("Program is terminated");
				run = false;
			}         	  
      }                        
    }
}
