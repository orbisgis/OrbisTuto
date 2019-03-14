package org.orbisgis.tutorial.utils.solutions

import groovy.transform.BaseScript
import org.orbisgis.tutorial.utils.TutorialScript

@BaseScript TutorialScript tutorialScript

/**
 * Step 3 : Conditions
 */

step = 3

// It allow you to execute different instruction according to the result of an evaluation
// The key words are 'if', and 'else'
// The evaluation is done with two variable and an operator : var1 operator var2
// The operator are :
// == -> equals
// != -> different
// >  -> superior
// >= -> superior or equals
// <  -> inferior
// <= -> inferior or equals

temperature = -5

if(temperature < 5) {
    println "Brrrr, so cold"
}
else if(temperature < 15) {
    println "A bit cold"
}
else if(temperature <= 19) {
    println "Good"
}
else if(temperature == 20) {
    println "Perfect"
}
else if(temperature <= 25) {
    println "Also good"
}
else if(temperature > 25) {
    println "Too hot"
}

if(temperature < -30){
    println "are you sure of the temperature ?"
}
if(temperature > 50){
    println "are you sure of the temperature ?"
}

// You can also use logical operators
// && -> and
// || -> or
// !  -> not

temperature = -99999

if(temperature < -30 || temperature > 50){
    println "Are you sure of the temperature ?"
}

// Remember the boolean type ? Evaluation are boolean, so you store result of evaluation or use boolean in condition

temperatureChanged = temperature != -99999

if(temperatureChanged){
    println "You have changed the temperature"
}
else{
    println "You haven't changed the temperature"
}

// Little tip, the keyword 'assert' is use to check an evaluation and stop the script if the evaluation is false.

assert true

//TODO : Complete the following code which generate a country name between 'France', 'Allemagne', 'Espagne',
//TODO : 'Cambodge', and you should store in the variable answer the good salutation : 'Bonjour', 'Hallo', 'Hola', 'ជំរាបសួរ'


country = generateCountry()
answer = "..."

//Your code
if(country == "France"){
    answer = "Bonjour"
}
else if(country == "Allemagne"){
    answer = "Hallo"
}
else if(country == "Espagne"){
    answer = "Hola"
}
else if(country == "Cambodge"){
    answer = "ជំរាបសួរ"
}
//

assert check(answer)


// Chaining the if can be long and to avoid that you can use the switch
// Switch can be done in decimal, integral, String and character
// Inside the switch each cases are declared and ends with break
// the default case is used when the other declared cases can't be applied

status = 0

switch (status) {
    case 0:
        println "We are safe"
        break
    case 1:
        println "Warning"
        break
    case 2:
        println "Danger, please run away now"
        break
    case 3:
        println "I'm a teapot"
        break
    default:
        println "Unknown status"
        break
}

//TODO : Same exercise, but with a switch
//TODO : Complete the following code which generate a country name between 'France', 'Allemagne', 'Espagne',
//TODO : 'Cambodge', and you should store in the variable answer the good salutation : 'Bonjour', 'Hallo', 'Hola', 'ជំរាបសួរ'


country = generateCountry()
answer = "..."

//Your code
switch (country) {
    case "France":
        answer = "Bonjour"
        break
    case "Allemagne":
        answer = "Hallo"
        break
    case "Espagne":
        answer = "Hola"
        break
    case "Cambodge":
        answer = "ជំរាបសួរ"
        break
    default :
        assert false
}
//

assert check(answer)


next step