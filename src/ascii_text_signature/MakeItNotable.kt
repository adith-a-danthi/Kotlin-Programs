package ascii_text_signature
/*
Stage #3: Make it notable

Description

Let's change the font of the text. The new font will be larger. It will consist of multiple rows and columns of standard console symbols.

The new font is shown below:

____ ___  ____ ___  ____ ____ ____ _  _ _  _ _  _ _    _  _
|__| |__] |    |  \ |___ |___ | __ |__| |  | |_/  |    |\/|
|  | |__] |___ |__/ |___ |    |__] |  | | _| | \_ |___ |  |
_  _ ____ ___  ____ ____ ____ ___ _  _ _  _ _ _ _ _  _ _   _ ___
|\ | |  | |__] |  | |__/ [__   |  |  | |  | | | |  \/   \_/    /
| \| |__| |    |_\| |  \ ___]  |  |__|  \/  |_|_| _/\_   |    /__

This font consists of the symbols '_', '|', '/', '\', ']', '['. Note that there are no lowercase letters, everything is uppercase.

Notice that the width of the letters in this font varies. For example, the width of the letter T is 3 characters, and for the letter Y, it is 5. You can find the letter boundaries by determining spaces in the same positions in all three lines of the font.

Also, each tag should contain the status of the person wearing it. This could be "VIP", "Worker", "Speaker", "Administrator", "Participant", or something else. These statuses should appear on the tag, below the person's name. This information is not as important as the name, so it should be printed in a smaller font.

To be readable, every symbol in this font should be separated by a column of spaces.

You may have noticed that there is no space among these symbols. As shown in the example below, you should consider a space to be 4 symbols wide not including spaces between symbols, or 6 symbols wide including spaces between symbols.

Also, there should be exactly two spaces between the border and the beginning and end of the name (or status, if it is longer than the name).

In some cases, the width of the tag may have an even number of symbols while the status has an odd number of symbols (or vice versa). In these cases, you cannot generate a status that sits right in the middle, since it will always be offset by one character on the left or the right. In this case, your program should move the status to the left so there is one fewer space to the left of the status than to the right it.

Output examples
The examples are shown below:

Enter name and surname: Bill Gates
Enter person's status: VIP
***************************************************
*  ___  _ _    _         ____ ____ ___ ____ ____  *
*  |__] | |    |         | __ |__|  |  |___ [__   *
*  |__] | |___ |___      |__] |  |  |  |___ ___]  *
*                       VIP                       *
***************************************************

Enter name and surname: Tom Smith
Enter person's status: Worker
*********************************************
*  ___ ____ _  _      ____ _  _ _ ___ _  _  *
*   |  |  | |\/|      [__  |\/| |  |  |__|  *
*   |  |__| |  |      ___] |  | |  |  |  |  *
*                  Worker                   *
*********************************************

Enter name and surname: Mr Anonimous
Enter person's status: Participant
**************************************************************
*  _  _ ____      ____ _  _ ____ _  _ _ _  _ ____ _  _ ____  *
*  |\/| |__/      |__| |\ | |  | |\ | | |\/| |  | |  | [__   *
*  |  | |  \      |  | | \| |__| | \| | |  | |__| |__| ___]  *
*                        Participant                         *
**************************************************************

Enter name and surname: John S
Enter person's status: Worker-coworker-superdupercoworker
****************************************
*      _ ____ _  _ _  _      ____      *
*      | |  | |__| |\ |      [__       *
*     _| |__| |  | | \|      ___]      *
*  Worker-coworker-superdupercoworker  *
****************************************

 */
import java.util.*

var line: Array<String> = arrayOf("", "", "", "", "", "")
var starCount: Int = 0
var spaceL: Int = 0
var spaceR: Int = 0

fun main() {

    val scanner = Scanner(System.`in`)

    print("Enter name and surname: ")
    val name: String = scanner.nextLine().trim()

    print("Enter person's status: ")
    val status: String = scanner.nextLine().trim()

    getPattern(name, status)

    for (l in line) {
        println(l)
    }

}

enum class Letter(val arrayOf: Array<String>) {
    A(arrayOf("____", "|__|", "|  |")),
    B(arrayOf("___ ", "|__]", "|__]")),
    C(arrayOf("____", "|   ", "|___")),
    D(arrayOf("___ ", "|  \\", "|__/")),
    E(arrayOf("____", "|___", "|___")),
    F(arrayOf("____", "|___", "|   ")),
    G(arrayOf("____", "| __", "|__]")),
    H(arrayOf("_  _", "|__|", "|  |")),
    I(arrayOf("_", "|", "|")),
    J(arrayOf(" _", " |", "_|")),
    K(arrayOf("_  _", "|_/ ", "| \\_")),
    L(arrayOf("_   ", "|   ", "|___")),
    M(arrayOf("_  _", "|\\/|", "|  |")),
    N(arrayOf("_  _", "|\\ |", "| \\|")),
    O(arrayOf("____", "|  |", "|__|")),
    P(arrayOf("___ ", "|__]", "|   ")),
    Q(arrayOf("____", "|  |", "|_\\|")),
    R(arrayOf("____", "|__/", "|  \\")),
    S(arrayOf("____", "[__ ", "___]")),
    T(arrayOf("___", " | ", " | ")),
    U(arrayOf("_  _", "|  |", "|__|")),
    V(arrayOf("_  _", "|  |", " \\/ ")),
    W(arrayOf("_ _ _", "| | |", "|_|_|")),
    X(arrayOf("_  _", " \\/ ", "_/\\_")),
    Y(arrayOf("_   _", " \\_/ ", "  |  ")),
    Z(arrayOf("___ ", "  / ", " /__")),
    SPACE(arrayOf("    ", "    ", "    "))
}

fun getPattern(name: String, status: String) {
    for (char in name) {
        when (char.toUpperCase()) {
            'A' -> appendPattern(Letter.A)
            'B' -> appendPattern(Letter.B)
            'C' -> appendPattern(Letter.C)
            'D' -> appendPattern(Letter.D)
            'E' -> appendPattern(Letter.E)
            'F' -> appendPattern(Letter.F)
            'G' -> appendPattern(Letter.G)
            'H' -> appendPattern(Letter.H)
            'I' -> appendPattern(Letter.I)
            'J' -> appendPattern(Letter.J)
            'K' -> appendPattern(Letter.K)
            'L' -> appendPattern(Letter.L)
            'M' -> appendPattern(Letter.M)
            'N' -> appendPattern(Letter.N)
            'O' -> appendPattern(Letter.O)
            'P' -> appendPattern(Letter.P)
            'Q' -> appendPattern(Letter.Q)
            'R' -> appendPattern(Letter.R)
            'S' -> appendPattern(Letter.S)
            'T' -> appendPattern(Letter.T)
            'U' -> appendPattern(Letter.U)
            'V' -> appendPattern(Letter.V)
            'W' -> appendPattern(Letter.W)
            'X' -> appendPattern(Letter.X)
            'Y' -> appendPattern(Letter.Y)
            'Z' -> appendPattern(Letter.Z)
            ' ' -> appendPattern(Letter.SPACE)
        }
    }
    val patternLength = line[1].length - 1
    starCount = maxOf(patternLength, status.length) + 6
    line[0] = "*".repeat(starCount)
    line[5] = line[0]
    if (patternLength > status.length) {
        for (i in 1..3) {
            line[i] = "*  " + line[i] + " *"
        }
        calculateSpace(patternLength, status.length)
        line[4] = "* " + " ".repeat(spaceL) + status + " ".repeat(spaceR) + " *"
    } else {
        calculateSpace(status.length, patternLength)
        for (i in 1..3) {
            line[i] = "* " + " ".repeat(spaceL) + line[i] + " ".repeat(spaceR - 1) + " *"
        }
        line[4] = "*  $status  *"
    }
}

fun appendPattern(letter: Letter) {
    for (i in 1..3) {
        line[i] += letter.arrayOf[i - 1] + " "
    }
}


fun calculateSpace(larger: Int, smaller: Int) {
    val diff = larger - smaller
    if (diff % 2 == 0) {
        spaceL = diff / 2 + 1
        spaceR = spaceL
    } else {
        spaceL = (diff + 1) / 2
        spaceR = spaceL + 1
    }
}