package org.orbisgis.tutorial.utils.exercises

import groovy.transform.BaseScript
import org.orbisgis.tutorial.utils.TutorialScript

@BaseScript TutorialScript tutorialScript

/**
 * Step 6 : Function
 */

step = 6

// Do you remember when you call 'println' 'stop()' or 'next step'?
// These are functions.

stop()

// Methods are declared this way :
// returnType functionName (Parameter1, parameter2, ...) { function content and return }
// A function can only return one variable (but you can return array).

multiAndPrint(12, 4, "The result is : ")

stop()

// The variable declared with the def keyword are accessible only in the current function

str = "not accessible"
def str2 = "not accessible"
str3 = "ho!!"

void setVar(){
    str = "accessible"
    str2 = "accessible"
    def str3 = "hey!!"
}
setVar()

assert str == ""
assert str2 == ""
assert str3 == ""

stop()

//TODO : create a function 'sayHello' with one string parameter in the following code
/*
validationArray = [false, false, false, false]
while(!validationArray[0] ||
        !validationArray[1] ||
        !validationArray[2] ||
        !validationArray[3]) {
    country = generateCountry()
    answer = "..."
    switch (country) {
        case "France":
            answer = "Bonjour"
            validationArray[0] = true
            break
        case "Allemagne":
            answer = "Hallo"
            validationArray[1] = true
            break
        case "Espagne":
            answer = "Hola"
            validationArray[2] = true
            break
        case "Cambodge":
            answer = "ជំរាបសួរ"
            validationArray[3] = true
            break
        default:
            assert false
    }
    assert check(answer)
}
*/


// Uncomment next line to go to the next step
// next step
// Or uncomment the next line to get the solution
// solve step