package org.orbisgis.tutorial.utils.solutions

import groovy.transform.BaseScript
import org.orbisgis.tutorial.utils.TutorialScript

@BaseScript TutorialScript tutorialScript

/**
 * Step 6 : Function
 */

step = 6

// Do you remember when you call 'println' 'stop()' or 'next step'?
// These are functions.

noParameterFunction()

oneParameterFunction('hello')
oneParameterFunction 'hello'

multipleParameterFunction('hello', 5)
multipleParameterFunction 'hello', 5

//stop()

// Methods are declared this way :
// returnType functionName (Parameter1, parameter2, ...) { function content and return }
// A function can only return one variable (but you can return array).

int multiply(a, b){return a*b}
println multiply(45, 3)

void multiAndPrint(a, b, message) {
    def c = a*b
    println message + c
}
multiAndPrint(12, 4, "The result is : ")

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

assert str == "accessible"
assert str2 == "not accessible"
assert str3 == "ho!!"

//TODO : create a function 'sayHello' with one string parameter in the following code

void sayHello (country){
    def answer = "..."
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
        default:
            assert false
    }
    assert check(answer)
}

sayHello generateCountry()


next step