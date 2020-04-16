package ASCII_Text_Signature
/*
Stage #1, #2: Primitive art

The left and right borders are marked with the symbol '|', the top border is marked with  '_', and the bottom border is marked with '¯'.
The '¯' is a macron and not '-'.
Sample output

Enter text:
Hyper Skill

Stage #1: Boxed Text
 _____________
| Hyper Skill |
 ¯¯¯¯¯¯¯¯¯¯¯¯¯

Stage #2: Starred Text

****************
* Hyper Skill *
****************

 */

fun main() {
    println("Enter text : ")
    val myText: String = readLine()!!
    val nameLength = myText.trim().length

    println()
    println("Stage #1: Boxed Text\n")
    println(" ${"_".repeat(nameLength + 2)}")
    println("| $myText |")
    println(" ${"¯".repeat(nameLength + 2)} ")

    println()
    println("Stage #2: Starred Text\n")
    println("*".repeat(nameLength + 4))
    println("* $myText *")
    println("*".repeat(nameLength + 4))
}