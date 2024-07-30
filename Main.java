import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class Main {

    public static void main(String args[])
    {
      List<Student> students = Arrays.asList(
    new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
    new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
    new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
    new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
    new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
    new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
    new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
    new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
    new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
    new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));


   // ------------ 1- Find list of students whose first name starts with alphabet A--------
  //  students.stream().filter(stu -> stu.getFirstName().startsWith("A")).forEach(System.out::println);

  // -------------2 -Group The Student By Department Names----------------
//students.stream().sorted((o1,o2) -> o1.getDepartmantName().compareTo(o2.getDepartmantName())).forEach(System.out::println);
  //  --------------------------- or --------------------
   // Map<String, List<Student>> mapData = students.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
//System.out.println("Students grouped by the department names : "+mapData);

//---------------------- 3- Find the total count of student using stream -------------
    //    System.out.println(students.stream().count());

// ---------------------- 4- Find the max age of student --------------
     //   System.out.println(students.stream().max((o1,o2)-> o1.getAge()-o2.getAge()).map(n -> n.getAge()).get());

//------------------------5- Find all departments names
// Set<String> set =new HashSet<>(students.stream().map(n->n.getDepartmantName()).collect(Collectors.toList()));
// for (String string : set) {
//     System.out.println(string);
    
// }
//-----------------------   or ----------------------
//students.stream().map(st -> st.getDepartmantName()).distinct().forEach(System.out::println);


// --------------------  6- Find the count of student in each department------------------
//Map<String,Long> map =students.stream().collect(Collectors.groupingBy(Student::getCity,Collectors.counting()));
//map.forEach((key,value) -> System.out.println("the number of students from " + key.toString() + " is " + value ));

// ----------- 7- Find the list of students whose age is less than 30---------

//students.stream().filter(n -> n.getAge()<30).map(n -> n.getFirstName()+ " "+ n.getLastName()).forEach(System.out::println);

//----------  8- Find the list of students whose rank is in between 50 and 100 ----------

//students.stream().filter(n -> n.getRank()>=50 && n.getRank()<=100).map(n -> n.getFirstName() +" "+n.getLastName()).forEach(System.out::println);
  
// -------------- 9- Find the average age of male and female students----------------

//Map<String ,Double> map =students.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge)));
// System.out.println(map);
//map.forEach((key,value) -> System.out.println(key +" : "+ value ));

// --------------  10- Find the department who is having maximum number of students---------------

// System.out.println(students.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()))
//                                     .entrySet().stream().max((o1,o2)-> o1.getValue().compareTo(o2.getValue())).get());


// ------------------11- Find the Students who stays in Karnataka and sort them by their names----------

// students.stream().filter(n -> n.getCity()=="Karnataka")
//                  .sorted((o1,o2)->o1.getFirstName().compareToIgnoreCase(o2.getFirstName()))
//                  .map(n -> n.getFirstName() +" " + n.getLastName())
//                  .forEach(System.out::println);;

// ---------------- 12- Find the average rank in all departments ----------

// students.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.averagingInt(Student::getRank)))
//                  .forEach((key,value) -> System.out.println(key + " : " + value));

// ---------------- 13- Find the highest rank in each department -------

//  Map<String, Optional<Student>> map =students.stream()
//                                 .collect(Collectors.groupingBy(Student::getDepartmantName
//                                 ,Collectors.maxBy((o1,o2)->o2.getRank() - o1.getRank())));

//     Set<Map.Entry<String,Optional<Student>>> entrySet = map.entrySet();

//     for(Map.Entry<String,Optional<Student>> entry :entrySet)
//     {
//             System.out.println(entry.getKey() + ":" +entry.getValue().get().getFirstName() + "  "+ entry.getValue().get().getLastName() );
//     }
    

// -------   Find the list of students and sort them by their rank

// students.stream().sorted((o1,o2)-> o1.getRank()-o2.getRank()).map(n -> n.getFirstName() +" " + n.getLastName() + " -> " +n.getRank() ).forEach(System.out::println);
   
//-----------  15- Find the student who has second rank  ----------


Optional<String> name =students.stream().sorted((o1,o2) ->o1.getRank()-o2.getRank()).skip(1).findFirst().map(n -> n.getFirstName() + ":" + n.getRank());

        System.out.println(name.get());
    }

}
