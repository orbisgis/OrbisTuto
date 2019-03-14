package org.orbisgis.tutorial.utils.exercises

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

temperature =

stop()

// You can also use logical operators
// && -> and
// || -> or
// !  -> not

temperature = -99999

stop()

// Remember the boolean type ? Evaluation are boolean, so you store result of evaluation or use boolean in condition

stop()

// Little tip, the keyword 'assert' is use to check an evaluation and stop the script if the evaluation is false.

assert false

//TODO : Complete the following code which generate a country name between 'France', 'Allemagne', 'Espagne',
//TODO : 'Cambodge', and you should store in the variable answer the good salutation : 'Bonjour', 'Hallo', 'Hola', 'ជំរាបសួរ'

/*
country = generateCountry()
answer = "..."

//Your code
if ....
//

assert check(answer)
*/

// Chaining the if can be long and to avoid that you can use the switch
// Switch can be done in decimal, integral, String and character
// Inside the switch each cases are declared and ends with break
// the default case is used when the other declared cases can't be applied

//TODO : Same exercise, but with a switch
//TODO : Complete the following code which generate a country name between 'France', 'Allemagne', 'Espagne',
//TODO : 'Cambodge', and you should store in the variable answer the good salutation : 'Bonjour', 'Hallo', 'Hola', 'ជំរាបសួរ'

/*
country = generateCountry()
answer = "..."

//Your code
switch ....
//

assert check(answer)
*/


// Uncomment next line to go to the next step
// next step
// Or uncomment the next line to get the solution
// solve step