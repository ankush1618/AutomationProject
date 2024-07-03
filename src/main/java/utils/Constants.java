package main.java.utils;

//All the variables are public static and Final by default

public interface Constants {
    String URL="https://www.amazon.in/";
    //run parameterized build on Jenkins
    //to parameterize in jenkins plugin=Build with Parameter
    //In jenkins in General Tab
    //Select This build is parameterized
    //Click Add parameter dropDown
    //Choose Choice parameter
    //Add name and choices(Values) in Choice Parameter section
    //Go to build section in Goals and options parameterize there as below
    // mvn test -Durl[name provided in the code]=${jenkinsUrl[Name provided for Jenkins Choice]}
    //Apply and Save
    //Build Now
    //String URL=System.getProperty("url");
}
