package org.orbisgis.tutorial.utils.solutions

import groovy.transform.BaseScript
import org.orbisgis.tutorial.utils.TutorialScript

@BaseScript TutorialScript tutorialScript

/**
 * Step 5 : Loop
 */

step = 5

// To execute more than one time a code, loop can be use
// There is two kind of loop : 'for' and 'while'

// The 'for' loop have two syntax, the indexed one and the for in one

// The indexed for syntax is : for ( initialization; condition; action ) {}

message = ''
for(int i = 7; i < 15; i++){
    message += 'La la la. '
}
println message



// The for in syntax iterate of a list or an array of values

for(i in 14..19) {
    println i
}

for(i in [5, 'six', 7e1]) {
    println i
}

for(i in 'abcdef') {
    println i
}


// The while loop is executed until a condition is true

i = 0
while (i < 10 ) {
    println i
    i++
}




//TODO : Do you remember your hello generator from step 3, now update it to execute it until all the
//TODO : case are executed


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


next step