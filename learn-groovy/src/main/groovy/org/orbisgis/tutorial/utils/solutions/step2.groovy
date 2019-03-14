package org.orbisgis.tutorial.utils.solutions

import groovy.transform.BaseScript
import org.orbisgis.tutorial.utils.TutorialScript

@BaseScript TutorialScript tutorialScript

/**********************
 * Step 2 : Variables *
 **********************/


/** Names **/

// A variable is a named memory area containing data and it is declared with their type name (such as String,
// int, double ...) or with the the 'def' keyword

def var1
double var2
int var3
String var4


// Each line are an instruction. You can finish an instruction by a ';' or with a linebreak.

int var5; String var6

int var7
String var8

// The name can start with a letter ('a'-'z'+'A'-'Z') or a '_'.
// By convention, a variable name should be respect the camelCase.

def goodVariableName
def _alsoGoodName
def Badname
def VerYbAdNamEandalsoNOtrEAdaBLE

/** Numbers **/

// The integrals one
byte  b = 1     // -128 <-> +127
char  c = 2     // 0 <-> 256
short s = 3     // -32 000 <-> +32 000
int   i = 4     // -2 000 000 000 <-> +2 000 000 000
long  l = 5     // -10 000 000 000 000 000 000 <-> +10 000 000 000 000 000 000
varIntegral1 = 58
def varIntegral2 = 58

BigInteger bi =  6

// The decimal one
float  f = 1.234
double d = 2.345
varDecimal1 = 58.41265
def varDecimal2 = 58.41265

BigDecimal bd1 =  3.456
BigDecimal bd2 =  3e4
BigDecimal bd3 =  3E4
BigDecimal bd4 =  3e-2
BigDecimal bd5 =  3E+2

// Boolean
boolean bool1 = true
bool2 = false
def bool3 = true

//TODO : Declare an integral variable named 'step' with the value 2

int step = 2
assert step == 2

/** String **/

// Character
char c1 = 'A'
char c2 = 'ù'
c3 = '@'
def c4 = '|'

// Strings are declared between " or '
String str1 = "blablabla"
str2 = "blobloblo"
str3 = 'bliblibli'
def str4 = 'blublublu'

/** Printing **/

//You can display data to the terminal with the print/println command

print bd1
print bd5
print l
println c1

//stop()

//TODO : Try to display in the terminal the sentence 'Hello world !' with the println command

message = 'Hello world !'
println message
assert message == 'Hello world !'


/** Operators **/

//The variable can be manipulated with operators :
// '-'  -> less
// '+'  -> plus
// '*'  -> multiply
// '**' -> exponent
// '/'  -> division
// '%'  -> modulo
// After an operation, the type of the result is the same as the bigger type of the operands

println 5 - 42            // -> -37
println 5 + 42            // -> 47
println 3 * 3 * 3 * 3     // -> 81
println 3 ** 4            // -> 81
println 6 / 4             // -> 1.5
println 6 % 4             // -> 2

println "tata" - "ata"    // -> "t"
println "tat" + "a"       // -> "tat"

//You can also do an assignation in the same time of an operation

text = "Just a li"
text += 'ttle text too long'
text -= ' too long'
println text
assert text == "Just a little text"

number = 9
number *= number
number /= 81
number += 49
number -= 8
println number
assert number == 42

//Comment to continue
stop()

//TODO : Now, complete the following example to make it return 'PI = 3.14'

start = 'PI = '
number = 314
factor = 100
str = start + number / factor
println str
assert str == 'PI = 3.14'


next step