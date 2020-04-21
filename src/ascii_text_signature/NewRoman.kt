package ascii_text_signature

/*
Stage #4: ASCII New Roman

Output examples
The examples are shown below:

Enter name and surname: Ian One
Enter person's status: VIP
888888888888888888888888888888888888888888888888888888888888888888888888888888888
88  ooooo                                   .oooooo.                           88
88  `888'                                  d8P'  `Y8b                          88
88   888   .oooo.   ooo. .oo.             888      888 ooo. .oo.    .ooooo.    88
88   888  `P  )88b  `888P"Y88b            888      888 `888P"Y88b  d88' `88b   88
88   888   .oP"888   888   888            888      888  888   888  888ooo888   88
88   888  d8(  888   888   888            `88b    d88'  888   888  888    .o   88
88  o888o `Y888""8o o888o o888o            `Y8bood8P'  o888o o888o `Y8bod8P'   88
88                                                                             88
88                                                                             88
88                                                                             88
88                                _  _ _ ___                                   88
88                                |  | | |__]                                  88
88                                 \/  | |                                     88
888888888888888888888888888888888888888888888888888888888888888888888888888888888
Enter name and surname: A b
Enter person's status: long participant
88888888888888888888888888888888888888888888888888888888888888888888888888888888
88                         .o.                  .o8                           88
88                        .888.                "888                           88
88                       .8"888.                888oooo.                      88
88                      .8' `888.               d88' `88b                     88
88                     .88ooo8888.              888   888                     88
88                    .8'     `888.             888   888                     88
88                   o88o     o8888o            `Y8bod8P'                     88
88                                                                            88
88                                                                            88
88                                                                            88
88  _    ____ _  _ ____      ___  ____ ____ ___ _ ____ _ ___  ____ _  _ ___   88
88  |    |  | |\ | | __      |__] |__| |__/  |  | |    | |__] |__| |\ |  |    88
88  |___ |__| | \| |__]      |    |  | |  \  |  | |___ | |    |  | | \|  |    88
88888888888888888888888888888888888888888888888888888888888888888888888888888888

 */

import java.util.*

var lines: Array<String> = arrayOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
var border: Int = 0
var spaceLeft: Int = 0
var spaceRight: Int = 0

enum class FontStatus(val arrayOf: Array<String>) {
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

enum class FontName(val arrayOf: Array<String>) {
    a(
        arrayOf(
            "          ",
            "          ",
            " .oooo.   ",
            "`P  )88b  ",
            " .oP\"888  ",
            "d8(  888  ",
            "`Y888\"\"8o ",
            "          ",
            "          ",
            "          "
        )
    ),
    b(
        arrayOf(
            " .o8       ",
            "\"888       ",
            " 888oooo.  ",
            " d88' `88b ",
            " 888   888 ",
            " 888   888 ",
            " `Y8bod8P' ",
            "           ",
            "           ",
            "           "
        )
    ),
    c(
        arrayOf(
            "          ",
            "          ",
            " .ooooo.  ",
            "d88' `\"Y8 ",
            "888       ",
            "888   .o8 ",
            "`Y8bod8P' ",
            "          ",
            "          ",
            "          "
        )
    ),
    d(
        arrayOf(
            "      .o8  ",
            "     \"888  ",
            " .oooo888  ",
            "d88' `888  ",
            "888   888  ",
            "888   888  ",
            "`Y8bod88P\" ",
            "           ",
            "           ",
            "           "
        )
    ),
    e(
        arrayOf(
            "          ",
            "          ",
            " .ooooo.  ",
            "d88' `88b ",
            "888ooo888 ",
            "888    .o ",
            "`Y8bod8P' ",
            "          ",
            "          ",
            "          "
        )
    ),
    f(
        arrayOf(
            " .o88o. ",
            " 888 `\" ",
            "o888oo  ",
            " 888    ",
            " 888    ",
            " 888    ",
            "o888o   ",
            "        ",
            "        ",
            "        "
        )
    ),
    g(
        arrayOf(
            "           ",
            "           ",
            " .oooooooo ",
            "888' `88b  ",
            "888   888  ",
            "`88bod8P'  ",
            "`8oooooo.  ",
            "d\"     YD  ",
            "\"Y88888P'  ",
            "           efgh"
        )
    ),
    h(
        arrayOf(
            "oooo        ",
            "`888        ",
            " 888 .oo.   ",
            " 888P\"Y88b  ",
            " 888   888  ",
            " 888   888  ",
            "o888o o888o ",
            "            ",
            "            ",
            "            "
        )
    ),
    i(arrayOf(" o8o  ", " `\"'  ", "oooo  ", "`888  ", " 888  ", " 888  ", "o888o ", "      ", "      ", "      ")),
    j(
        arrayOf(
            "    o8o ",
            "    `\"' ",
            "   oooo ",
            "   `888 ",
            "    888 ",
            "    888 ",
            "    888 ",
            "    888 ",
            ".o. 88P ",
            "`Y888P  "
        )
    ),
    k(
        arrayOf(
            "oooo        ",
            "`888        ",
            " 888  oooo  ",
            " 888 .8P'   ",
            " 888888.    ",
            " 888 `88b.  ",
            "o888o o888o ",
            "            ",
            "            ",
            "            "
        )
    ),
    l(arrayOf("oooo  ", "`888  ", " 888  ", " 888  ", " 888  ", " 888  ", "o888o ", "      ", "      ", "      ")),
    m(
        arrayOf(
            "                  ",
            "                  ",
            "ooo. .oo.  .oo.   ",
            "`888P\"Y88bP\"Y88b  ",
            " 888   888   888  ",
            " 888   888   888  ",
            "o888o o888o o888o ",
            "                  ",
            "                  ",
            "                  "
        )
    ),
    n(
        arrayOf(
            "            ",
            "            ",
            "ooo. .oo.   ",
            "`888P\"Y88b  ",
            " 888   888  ",
            " 888   888  ",
            "o888o o888o ",
            "            ",
            "            ",
            "            "
        )
    ),
    o(
        arrayOf(
            "          ",
            "          ",
            " .ooooo.  ",
            "d88' `88b ",
            "888   888 ",
            "888   888 ",
            "`Y8bod8P' ",
            "          ",
            "          ",
            "          "
        )
    ),
    p(
        arrayOf(
            "           ",
            "           ",
            "oo.ooooo.  ",
            " 888' `88b ",
            " 888   888 ",
            " 888   888 ",
            " 888bod8P' ",
            " 888       ",
            "o888o      ",
            "           "
        )
    ),
    q(
        arrayOf(
            "           ",
            "           ",
            " .ooooo oo ",
            "d88' `888  ",
            "888   888  ",
            "888   888  ",
            "`V8bod888  ",
            "      888. ",
            "      8P'  ",
            "      \"    "
        )
    ),
    r(
        arrayOf(
            "         ",
            "         ",
            "oooo d8b ",
            "`888\"\"8P ",
            " 888     ",
            " 888     ",
            "d888b    ",
            "         ",
            "         ",
            "         "
        )
    ),
    s(
        arrayOf(
            "         ",
            "         ",
            " .oooo.o ",
            "d88(  \"8 ",
            "`\"Y88b.  ",
            "o.  )88b ",
            "8\"\"888P' ",
            "         ",
            "         ",
            "         "
        )
    ),
    t(
        arrayOf(
            "    .   ",
            "  .o8   ",
            ".o888oo ",
            "  888   ",
            "  888   ",
            "  888 . ",
            "  \"888\" ",
            "        ",
            "        ",
            "        "
        )
    ),
    u(
        arrayOf(
            "            ",
            "            ",
            "oooo  oooo  ",
            "`888  `888  ",
            " 888   888  ",
            " 888   888  ",
            " `V88V\"V8P' ",
            "            ",
            "            ",
            "            "
        )
    ),
    v(
        arrayOf(
            "            ",
            "            ",
            "oooo    ooo ",
            " `88.  .8'  ",
            "  `88..8'   ",
            "   `888'    ",
            "    `8'     ",
            "            ",
            "            ",
            "            "
        )
    ),
    w(
        arrayOf(
            "                 ",
            "                 ",
            "oooo oooo    ooo ",
            " `88. `88.  .8'  ",
            "  `88..]88..8'   ",
            "   `888'`888'    ",
            "    `8'  `8'     ",
            "                 ",
            "                 ",
            "                 "
        )
    ),
    x(
        arrayOf(
            "            ",
            "            ",
            "oooo    ooo ",
            " `88b..8P'  ",
            "   Y888'    ",
            " .o8\"'88b   ",
            "o88'   888o ",
            "            ",
            "            ",
            "            "
        )
    ),
    y(
        arrayOf(
            "            ",
            "            ",
            "oooo    ooo ",
            " `88.  .8'  ",
            "  `88..8'   ",
            "   `888'    ",
            "    .8'     ",
            ".o..P'      ",
            "`Y8P'       ",
            "            "
        )
    ),
    z(
        arrayOf(
            "           ",
            "           ",
            "  oooooooo ",
            " d'\"\"7d8P  ",
            "   .d8P'   ",
            " .d8P'  .P ",
            "d8888888P  ",
            "           ",
            "           ",
            "           "
        )
    ),
    A(
        arrayOf(
            "      .o.       ",
            "     .888.      ",
            "    .8\"888.     ",
            "   .8' `888.    ",
            "  .88ooo8888.   ",
            " .8'     `888.  ",
            "o88o     o8888o ",
            "                ",
            "                ",
            "                "
        )
    ),
    B(
        arrayOf(
            "oooooooooo.  ",
            "`888'   `Y8b ",
            " 888     888 ",
            " 888oooo888' ",
            " 888    `88b ",
            " 888    .88P ",
            "o888bood8P'  ",
            "             ",
            "             ",
            "             "
        )
    ),
    C(
        arrayOf(
            "  .oooooo.   ",
            " d8P'  `Y8b  ",
            "888          ",
            "888          ",
            "888          ",
            "`88b    ooo  ",
            " `Y8bood8P'  ",
            "             ",
            "             ",
            "             "
        )
    ),
    D(
        arrayOf(
            "oooooooooo.   ",
            "`888'   `Y8b  ",
            " 888      888 ",
            " 888      888 ",
            " 888      888 ",
            " 888     d88' ",
            "o888bood8P'   ",
            "              ",
            "              ",
            "              "
        )
    ),
    E(
        arrayOf(
            "oooooooooooo ",
            "`888'     `8 ",
            " 888         ",
            " 888oooo8    ",
            " 888    \"    ",
            " 888       o ",
            "o888ooooood8 ",
            "             ",
            "             ",
            "             "
        )
    ),
    F(
        arrayOf(
            "oooooooooooo ",
            "`888'     `8 ",
            " 888         ",
            " 888oooo8    ",
            " 888    \"    ",
            " 888         ",
            "o888o        ",
            "             ",
            "             ",
            "             "
        )
    ),
    G(
        arrayOf(
            "  .oooooo.    ",
            " d8P'  `Y8b   ",
            "888           ",
            "888           ",
            "888     ooooo ",
            "`88.    .88'  ",
            " `Y8bood8P'   ",
            "              ",
            "              ",
            "              "
        )
    ),
    H(
        arrayOf(
            "ooooo   ooooo ",
            "`888'   `888' ",
            " 888     888  ",
            " 888ooooo888  ",
            " 888     888  ",
            " 888     888  ",
            "o888o   o888o ",
            "              ",
            "              ",
            "              "
        )
    ),
    I(arrayOf("ooooo ", "`888' ", " 888  ", " 888  ", " 888  ", " 888  ", "o888o ", "      ", "      ", "      ")),
    J(
        arrayOf(
            "   oooo ",
            "   `888 ",
            "    888 ",
            "    888 ",
            "    888 ",
            "    888 ",
            ".o. 88P ",
            "`Y888P  ",
            "        ",
            "        "
        )
    ),
    K(
        arrayOf(
            "oooo    oooo ",
            "`888   .8P'  ",
            " 888  d8'    ",
            " 88888[      ",
            " 888`88b.    ",
            " 888  `88b.  ",
            "o888o  o888o ",
            "             ",
            "             ",
            "             "
        )
    ),
    L(
        arrayOf(
            "ooooo        ",
            "`888'        ",
            " 888         ",
            " 888         ",
            " 888         ",
            " 888       o ",
            "o888ooooood8 ",
            "             ",
            "             ",
            "             "
        )
    ),
    M(
        arrayOf(
            "ooo        ooooo ",
            "`88.       .888' ",
            " 888b     d'888  ",
            " 8 Y88. .P  888  ",
            " 8  `888'   888  ",
            " 8    Y     888  ",
            "o8o        o888o ",
            "                 ",
            "                 ",
            "                 "
        )
    ),
    N(
        arrayOf(
            "ooooo      ooo ",
            "`888b.     `8' ",
            " 8 `88b.    8  ",
            " 8   `88b.  8  ",
            " 8     `88b.8  ",
            " 8       `888  ",
            "o8o        `8  ",
            "               ",
            "               ",
            "               "
        )
    ),
    O(
        arrayOf(
            "  .oooooo.   ",
            " d8P'  `Y8b  ",
            "888      888 ",
            "888      888 ",
            "888      888 ",
            "`88b    d88' ",
            " `Y8bood8P'  ",
            "             ",
            "             ",
            "             "
        )
    ),
    P(
        arrayOf(
            "ooooooooo.   ",
            "`888   `Y88. ",
            " 888   .d88' ",
            " 888ooo88P'  ",
            " 888         ",
            " 888         ",
            "o888o        ",
            "             ",
            "             ",
            "             "
        )
    ),
    Q(
        arrayOf(
            "  .oooooo.      ",
            " d8P'  `Y8b     ",
            "888      888    ",
            "888      888    ",
            "888      888    ",
            "`88b    d88b    ",
            " `Y8bood8P'Ybd' ",
            "                ",
            "                ",
            "                "
        )
    ),
    R(
        arrayOf(
            "ooooooooo.   ",
            "`888   `Y88. ",
            " 888   .d88' ",
            " 888ooo88P'  ",
            " 888`88b.    ",
            " 888  `88b.  ",
            "o888o  o888o ",
            "             ",
            "             ",
            "             "
        )
    ),
    S(
        arrayOf(
            " .oooooo..o ",
            "d8P'    `Y8 ",
            "Y88bo.      ",
            " `\"Y8888o.  ",
            "     `\"Y88b ",
            "oo     .d8P ",
            "8\"\"88888P'  ",
            "            ",
            "            ",
            "            "
        )
    ),
    T(
        arrayOf(
            "ooooooooooooo ",
            "8'   888   `8 ",
            "     888      ",
            "     888      ",
            "     888      ",
            "     888      ",
            "    o888o     ",
            "              ",
            "              ",
            "              "
        )
    ),
    U(
        arrayOf(
            "ooooo     ooo ",
            "`888'     `8' ",
            " 888       8  ",
            " 888       8  ",
            " 888       8  ",
            " `88.    .8'  ",
            "   `YbodP'    ",
            "              ",
            "              ",
            "              "
        )
    ),
    V(
        arrayOf(
            "oooooo     oooo ",
            " `888.     .8'  ",
            "  `888.   .8'   ",
            "   `888. .8'    ",
            "    `888.8'     ",
            "     `888'      ",
            "      `8'       ",
            "                ",
            "                ",
            "                "
        )
    ),
    W(
        arrayOf(
            "oooooo   oooooo     oooo ",
            " `888.    `888.     .8'  ",
            "  `888.   .8888.   .8'   ",
            "   `888  .8'`888. .8'    ",
            "    `888.8'  `888.8'     ",
            "     `888'    `888'      ",
            "      `8'      `8'       ",
            "                         ",
            "                         ",
            "                         "
        )
    ),
    X(
        arrayOf(
            "ooooooo  ooooo ",
            " `8888    d8'  ",
            "   Y888..8P    ",
            "    `8888'     ",
            "   .8PY888.    ",
            "  d8'  `888b   ",
            "o888o  o88888o ",
            "               ",
            "               ",
            "               "
        )
    ),
    Y(
        arrayOf(
            "oooooo   oooo ",
            " `888.   .8'  ",
            "  `888. .8'   ",
            "   `888.8'    ",
            "    `888'     ",
            "     888      ",
            "    o888o     ",
            "              ",
            "              ",
            "              "
        )
    ),
    Z(
        arrayOf(
            " oooooooooooo ",
            "d'\"\"\"\"\"\"d888' ",
            "      .888P   ",
            "     d888'    ",
            "   .888P      ",
            "  d888'    .P ",
            ".8888888888P  ",
            "              ",
            "              ",
            "              "
        )
    ),
    SPACE(
        arrayOf(
            "          ",
            "          ",
            "          ",
            "          ",
            "          ",
            "          ",
            "          ",
            "          ",
            "          ",
            "          "
        )
    )
}

fun main() {

    val scanner = Scanner(System.`in`)

    print("Enter name and surname:")
    val name: String = scanner.nextLine().trim()

    print("Enter person's status:")
    val status: String = scanner.nextLine().trim()

    getPatterns(name, status)

    for (l in lines) {
        println(l)
    }

}

fun getPatterns(name: String, status: String) {
    for (char in status) {
        when (char.toUpperCase()) {
            'A' -> appendPattern(FontStatus.A)
            'B' -> appendPattern(FontStatus.B)
            'C' -> appendPattern(FontStatus.C)
            'D' -> appendPattern(FontStatus.D)
            'E' -> appendPattern(FontStatus.E)
            'F' -> appendPattern(FontStatus.F)
            'G' -> appendPattern(FontStatus.G)
            'H' -> appendPattern(FontStatus.H)
            'I' -> appendPattern(FontStatus.I)
            'J' -> appendPattern(FontStatus.J)
            'K' -> appendPattern(FontStatus.K)
            'L' -> appendPattern(FontStatus.L)
            'M' -> appendPattern(FontStatus.M)
            'N' -> appendPattern(FontStatus.N)
            'O' -> appendPattern(FontStatus.O)
            'P' -> appendPattern(FontStatus.P)
            'Q' -> appendPattern(FontStatus.Q)
            'R' -> appendPattern(FontStatus.R)
            'S' -> appendPattern(FontStatus.S)
            'T' -> appendPattern(FontStatus.T)
            'U' -> appendPattern(FontStatus.U)
            'V' -> appendPattern(FontStatus.V)
            'W' -> appendPattern(FontStatus.W)
            'X' -> appendPattern(FontStatus.X)
            'Y' -> appendPattern(FontStatus.Y)
            'Z' -> appendPattern(FontStatus.Z)
            ' ' -> appendPattern(FontStatus.SPACE)
        }
    }

    for (char in name) {
        when (char) {
            'A' -> appendNamePattern(FontName.A)
            'B' -> appendNamePattern(FontName.B)
            'C' -> appendNamePattern(FontName.C)
            'D' -> appendNamePattern(FontName.D)
            'E' -> appendNamePattern(FontName.E)
            'F' -> appendNamePattern(FontName.F)
            'G' -> appendNamePattern(FontName.G)
            'H' -> appendNamePattern(FontName.H)
            'I' -> appendNamePattern(FontName.I)
            'J' -> appendNamePattern(FontName.J)
            'K' -> appendNamePattern(FontName.K)
            'L' -> appendNamePattern(FontName.L)
            'M' -> appendNamePattern(FontName.M)
            'N' -> appendNamePattern(FontName.N)
            'O' -> appendNamePattern(FontName.O)
            'P' -> appendNamePattern(FontName.P)
            'Q' -> appendNamePattern(FontName.Q)
            'R' -> appendNamePattern(FontName.R)
            'S' -> appendNamePattern(FontName.S)
            'T' -> appendNamePattern(FontName.T)
            'U' -> appendNamePattern(FontName.U)
            'V' -> appendNamePattern(FontName.V)
            'W' -> appendNamePattern(FontName.W)
            'X' -> appendNamePattern(FontName.X)
            'Y' -> appendNamePattern(FontName.Y)
            'Z' -> appendNamePattern(FontName.Z)
            ' ' -> appendNamePattern(FontName.SPACE)
            'a' -> appendNamePattern(FontName.a)
            'b' -> appendNamePattern(FontName.b)
            'c' -> appendNamePattern(FontName.c)
            'd' -> appendNamePattern(FontName.d)
            'e' -> appendNamePattern(FontName.e)
            'f' -> appendNamePattern(FontName.f)
            'g' -> appendNamePattern(FontName.g)
            'h' -> appendNamePattern(FontName.h)
            'i' -> appendNamePattern(FontName.i)
            'j' -> appendNamePattern(FontName.j)
            'k' -> appendNamePattern(FontName.k)
            'l' -> appendNamePattern(FontName.l)
            'm' -> appendNamePattern(FontName.m)
            'n' -> appendNamePattern(FontName.n)
            'o' -> appendNamePattern(FontName.o)
            'p' -> appendNamePattern(FontName.p)
            'q' -> appendNamePattern(FontName.q)
            'r' -> appendNamePattern(FontName.r)
            's' -> appendNamePattern(FontName.s)
            't' -> appendNamePattern(FontName.t)
            'u' -> appendNamePattern(FontName.u)
            'v' -> appendNamePattern(FontName.v)
            'w' -> appendNamePattern(FontName.w)
            'x' -> appendNamePattern(FontName.x)
            'y' -> appendNamePattern(FontName.y)
            'z' -> appendNamePattern(FontName.z)
        }
    }

    val nameLength = lines[1].length - 1
    val statusLength = lines[11].length - 1
    border = maxOf(nameLength, statusLength) + 8
    lines[0] = "8".repeat(border)
    lines[14] = lines[0]

    if (nameLength > statusLength) {
        for (i in 1..10) {
            lines[i] = "88  " + lines[i] + " 88"
        }
        calSpace(nameLength, statusLength)
        for (i in 11..13) {
            lines[i] = "88 " + " ".repeat(spaceLeft) + lines[i] + " ".repeat(spaceRight) + " 88"
        }
    } else {
        calSpace(statusLength, nameLength)
        for (i in 1..10) {
            lines[i] = "88 " + " ".repeat(spaceLeft) + lines[i] + " ".repeat(spaceRight) + " 88"
        }
        for (i in 11..13) {
            lines[i] = "88  " + lines[i] + " 88"
        }
    }
}

fun appendPattern(letter: FontStatus) {
    for (i in 11..13) {
        lines[i] += letter.arrayOf[i - 11] + " "
    }
}

fun appendNamePattern(letter: FontName) {
    for (i in 1..10) {
        lines[i] += letter.arrayOf[i - 1]
    }
}

fun calSpace(larger: Int, smaller: Int) {
    val diff = larger - smaller
    if (diff % 2 == 0) {
        spaceLeft = diff / 2
        spaceRight = spaceLeft + 1
    } else {
        spaceLeft = (diff + 1) / 2
        spaceRight = spaceLeft
    }
}