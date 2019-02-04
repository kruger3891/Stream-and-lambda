package se.lexicon.streams_and_lambda;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.lexicon.streams_and_lambda.utility.Gender;
import se.lexicon.streams_and_lambda.utility.Person;

/**
 * All exercises should be completed using Lambda expressions and the new
 * methods added to JDK 8 where appropriate. There is no need to use an
 * explicit loop in any of the code.
 *
 */
public class Lab {
    private List<Person> persons;

    public Lab(List<Person> persons) {
        this.persons = persons;
    }

    /**
     * Exercise1
     * Create print out the first names of each person in the list
     */
    public void exercise1() {
        System.out.println("\nRunning exercise 1:\n");

        System.out.println("<<Persons first names:>>\n");
        persons.stream()   
        .map(Person::getFirstName)
        .forEach(System.out::println);
        
        /* Your code here */

    }

    /**
     * Exercise2
     * Remove the words that have odd lengths from the local list using removeIf()
     * Удалите слова, которые имеют нечетные длины из локального списка, используя removeIf
     * Print out the remainder // Распечатайте остаток
     */
    public void exercise2() {
        System.out.println("\nRunning exercise 2:\n");
        List<String> list = new ArrayList<>(Arrays.asList(
        		"alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));               
        
        list.removeIf(s->(s.length()%2) !=0);
//        System.out.println(list);
      
        list.forEach(System.out::print);
        
//        System.out.println("<<Before sort:>>\n");
//        list.stream()
//        .forEach(System.out :: println);
//        
//        System.out.println("\n<<After sort:>>\n");
//        list.stream().filter(s->s.length()%2 !=0)
//        .forEach(System.out :: println);
        
        /* Your code here */

    }

    /**
     * Exercise 3
     * Replace every word in the list with its upper case equivalent using replaceAll()
     * Замените каждое слово в списке его эквивалентом в верхнем регистре, используя replaceAll
     * Print out the remainder
     * Распечатайте остаток
     */
    public void exercise3() {
        System.out.println("\nRunning exercise 3:\n");
        List<String> list = new ArrayList<>(Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

        list.replaceAll(String::toUpperCase);
        
//        System.out.println("<<Before sort:>>\n");                
//		System.out.println(list);
//        
//        System.out.println("\n<<After sort:>>\n");       
//        list.replaceAll((s1)->s1.toUpperCase());
//		System.out.println(list);

        /* Your code here */

    }

    /**
     * Exercise 4
     * Convert every key-value pair of the map into a string and append them all
     * into a single string
     * Hint: Maps forEach takes a BiConsumer...
     */
    public void exercise4() {
        System.out.println("\nRunning exercise 4:\n");
        Map<String, Integer> map = new HashMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);

        StringBuilder sb = new StringBuilder();
        
        map.forEach((key, value) -> sb.append("\n"+key+ " : "+value));
        System.out.println(sb);
        
//        for (Entry<String, Integer> entry : map.entrySet())
//        	System.out.println(entry.getKey() + ":" + entry.getValue());

        
        
        /* Your code here */


    }

    /**
     * Exercise 5
     * Create a new thread that prints the numbers from the local list
     * Создайте новый поток, который печатает номера из локального списка
     */
    public void exercise5() {
        System.out.println("\nRunning exercise 5:\n");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
//        System.out.println("<<Before>>");
//        for (Integer user : list) {
//            System.out.println(user);
//        }
     
        ExecutorService service = Executors.newSingleThreadExecutor();
        
        service.execute(()->list.forEach(System.out::println));
        
//        service.execute(()-> {
//        	list.forEach(System.out::println);
//        });
        
        
//        System.out.println();
//        System.out.println("\n<<After>>");
//        list.stream()
//        .filter(i -> i % 2 == 0)
//        .forEach(System.out::print);
        
        /* Your code here */


    }

    /**
     * Exercise 6
     * By using stream create a new list with all the strings from the original list converted to
     * lower case and print them out.
     * Используя stream, создайте новый список со всеми строками из исходного списка, 
     * преобразованными в нижний регистр, и распечатайте их.
     * Hint: Use .collect as a terminal operation(closing and ending)
     */
    public void exercise6() {
        System.out.println("\nRunning exercise 6:\n");
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        
        List<String> newList = list.stream()
        		.map(String::toLowerCase)
        		.collect(Collectors.toList());
        System.out.println(newList);
        
//        System.out.println("<<Before sort:>>\n");       
//		System.out.println(list);
////        stream
//        System.out.println("\n<<After sort:>>\n");
//        list.replaceAll((s1)->s1.toLowerCase());        
//		System.out.println(list);
        
        /* Your code here */

    }

    /**
     * Exercise 7
     * Modify exercise 6 so that the new list only contains strings that have an odd length
     * Измените упражнение 6 так, чтобы новый список содержал только строки нечетной длины
     */
    public void exercise7() {
        System.out.println("\nRunning exercise 7:\n");
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG" ,"sdqwezxcasj","asdwezxcas");
       
        
        List<String> newList = list.stream()
        		.filter(s->s.length()%2 !=0)
        		.map(String::toLowerCase)
        		.collect(Collectors.toList());
        System.out.println(newList);
        


        /* Your code here */

    }

    /**
     * Exercise 8
     * Turn list persons into a stream and print all elements whose lastName starts with 'A'
     * Use a forEach as a terminal operation
     */
    public void exercise8() {
        System.out.println("\nRunning exercise 8:\n");

        
//        persons.stream()   
//        .filter(p-> p.getLastName().charAt(0)=='A')
//        .forEach(System.out::println);
        
        System.out.println("<<Persons whose last Name starts with 'A'>>\n");
      persons.stream()   
      .filter(p-> p.getLastName().contains("A"))
      .forEach(System.out::println);
        
        /* Your code here */

    }

    /**
     * Exercise 9
     * Create a new list from this.persons that should be sorted by lastName
     * Создайте новый список из this.persons, который должен быть отсортирован по фамилии
     */
    public void exercise9(){
        System.out.println("\nRunning exercise 9:\n");
        
        
        List<Person> sorted =persons.stream()
        		.sorted((p1,p2)-> p1.getLastName().compareToIgnoreCase(p2.getLastName()))
        		.collect(Collectors.toList());
        sorted.forEach(System.out::println);
        
//        System.out.println("<<Sorted by last Name:>>\n");
//        Comparator<Person> lastName= (p1,p2) -> p1.getLastName()
//        		.compareToIgnoreCase(p2.getLastName());
//        persons.stream()
//        		.sorted(lastName)
//        		.collect(Collectors.toList())
//        .forEach(System.out::println); 
        
        
        /* Your code here */


    }

    /**
     * Exercise 10
     * Create a new list from persons that should only contain those with lastname "Ali".
     * then change the first name of all inside the stream to Muhammad
     */
    public void exercise10(){
        System.out.println("\nRunning exercise 10:\n");
        
//        List<Person>newperson=persons.stream()
//        		.filter(p-> p.getLastName().equals("Ali"))
//        		.peek(ali -> ali.setFirstName("Muhhamad"))
//        		.collect(Collectors.toList());
//        newperson.forEach(System.out::println);
        
        List<Person>newperson=persons.stream()
        		.filter(p-> p.getLastName().equals("Ali"))
        		.map(original -> new Person("Muhhamad", original.getLastName(), original.getGender()))
        		.collect(Collectors.toList());
        newperson.forEach(System.out::println);
        
//        List<Person>newperson=persons.stream()           		
//                .filter(p-> p.getLastName().contains("Ali"))
//                .collect(Collectors.toList());
//                System.out.println(newperson);
//
//                newperson.stream()
//                .forEach(p->p.setFirstName("Muhhamad"));
//                System.out.println(newperson);
        
        		
        		
        /* Your code here */

    }

    /**
     * Exercise 11
     * Count how many persons is of female gender in this.persons.
     * Present the result
     */
    public void exercise11(){
        System.out.println("\nRunning exercise 11:\n");

        
        System.out.println(
        		persons.stream().filter(p->p.getGender().equals(Gender.FEMALE)).count()
        		);
        
//       long female= persons.stream()
//    		    .filter(p->p.getGender()
//    			.equals(Gender.FEMALE)).count();
//       System.out.println("Persons of female"+female);
        /* Your code here */


    }

}