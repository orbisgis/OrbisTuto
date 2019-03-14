package org.orbisgis.tutorial.utils.solutions

import groovy.transform.BaseScript
import org.orbisgis.tutorial.utils.TutorialScript

@BaseScript TutorialScript tutorialScript

/**
 * Step 4 : Array
 */

step = 4

// Arrays are special variable type, it can store different values, even of different type.
// Values can be access thanks to an index starting from 0

array = [0, 1, 2, 3, 4, 'five', 6.0, 7e1, 'ei'+'ght', 9]

println array[5]
println array[7]
println array[9]



// You can also put an array as array value
inceptArray = ["hello", "how", "are", 'you', '?', ['deeper', 'pi', '3.14', ['Deeper', ['toot deep !'], 'and', 'so', on]]]
// Or in a more human readable way
inceptArray = [
        "hello",
        "how",
        "are",
        'you',
        '?',
        [
                'deeper',
                'pi',
                '3.14',
                [
                        'Deeper',
                        [
                                'toot deep !'
                        ],
                        'and',
                        'so',
                        'on'
                ]
        ]
]

//TODO : change the index for the array to pass the assertions
assert inceptArray[5][3][2] == 'and'
assert inceptArray[5][2] == '3.14'

// As you have seen with the array, the code visual aspect is important to be readable.
messageToCheckToEnsureThatTheUserInputIsNotTooLong = 'hi'
message = 'hi'


// Never write long line
if(messageToCheckToEnsureThatTheUserInputIsNotTooLong == "I'ts ok, the message isn't too long so you can go on") { validityOfTheUserInput = true} else { println "Your message is too long so please can you write a shorter one? It would be kind because we have a limitation on the number of character to write. " }




// Add new line
if(messageToCheckToEnsureThatTheUserInputIsNotTooLong == "I'ts ok, the message isn't too long so you can go on")
{ validityOfTheUserInput = true} else {validityOfTheUserInput = false; println "Your message is too long so please can you write a shorter one? It would be kind because we have a limitation on the number of character to write. " }




// Add new line after instruction
if(messageToCheckToEnsureThatTheUserInputIsNotTooLong == "I'ts ok, the message isn't too long so you can go on")
{ validityOfTheUserInput = true} else {validityOfTheUserInput = false
println "Your message is too long so please can you write a shorter one? It would be kind because we have a limitation on the number of character to write. " }




// Jump to a new line after '{' and before '}'
if(messageToCheckToEnsureThatTheUserInputIsNotTooLong == "I'ts ok, the message isn't too long so you can go on")
{
    validityOfTheUserInput = true
} else {
    validityOfTheUserInput = false
    println "Your message is too long so please can you write a shorter one? It would be kind because we have a limitation on the number of character to write. "
}




// Between '{' and '}' line tabulation should be incremented
if(messageToCheckToEnsureThatTheUserInputIsNotTooLong == "I'ts ok, the message isn't too long so you can go on")
{
    validityOfTheUserInput = true
} else {
    validityOfTheUserInput = false
    println "Your message is too long so please can you write a shorter one? It would be kind because we have a limitation on the number of character to write. "
}




// Variable name and the output messages should be short
if(message == "Input valid")
{
    inputValid = true
} else {
    inputValid = false
    println "Input too long"
}



next step