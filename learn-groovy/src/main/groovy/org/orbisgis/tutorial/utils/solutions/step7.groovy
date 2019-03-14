//Localisation of the script
package org.orbisgis.tutorial.utils.solutions

//Libraries to use
import groovy.transform.BaseScript
import org.orbisgis.tutorial.utils.TutorialScript

//Annotation
@BaseScript TutorialScript tutorialScript

/**
 * Step 7 : Script and classes
 */

step = 7

// String is a particular type, its a Class
// A class contains variable not accessible (attributes) and function accessible from the outside (methods)

// Class declaration
class Point{

    //Attributes
    private double x
    private double y
    private double z

    //Special method : constructor
    Point(double x, double y){
        this.x = x
        this.y = y
    }

    //Special method : constructor
    Point(double x, double y, double z){
        this(x, y)
        this.z = z
    }

    //Get method
    double getX(){
        return x
    }

    //Get method
    double getY(){
        return y
    }

    //Set method
    void setZ(double z){
        this.z = z
    }

    //Get method
    double getZ(){
        return z
    }

    //Method
    void turn(){
        double t = x
        x = y
        y = z
        z = t
    }

    String toString(){
        return "$x;$y;$z"
    }
}

// A script is a file with a list of instructions to execute

point = new Point(5.2, 6.3)
point.setZ(4.2)
point.turn()
println point
assert point.z == 5.2

//TODO : Write a class country with a name and a translation of hello message, a method sayHello and a method checkCountry



class Country{

    private String country
    private String hello

    Country(country, hello){
        this.country = country
        this.hello = hello
    }

    void sayHello(){
        println hello
    }

    boolean checkCountry(c){
        return country == c
    }
}

countryList = [new Country("France", "Bonjour"),
               new Country("Allemagne", "Hallo"),
               new Country("Espagne", "Hola"),
               new Country("Cambodge", "ជំរាបសួរ")]

void sayHello (country){
    println country
    for(c in countryList){
        if(c.checkCountry(country)){
            c.sayHello()
        }
    }
}

sayHello generateCountry()



next step