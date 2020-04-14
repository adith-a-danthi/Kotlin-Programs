package coffee_machine

/*
Stage #5: Creating main loop

Description

But just one action isn’t interesting. Let's improve the program so it can do multiple actions, one after another.
The program should repeatedly ask what the user wants to do.
If the user types "buy", "fill" or "take", then just do what the program did in the previous step.
However, if the user wants to switch off the coffee machine, he should type "exit".
Then the program should terminate.
Also, when the user types "remaining", the program should output all the resources that the coffee machine has.

Also, do not forget that you can be out of resources for making coffee.
If the coffee machine doesn’t have enough resources to make coffee, the program should output a message that says it can't make a cup of coffee.

And the last improvement to the program at this step—if the user types "buy" to buy a cup of coffee and then changes his mind,
he should be able to type "back" to return into the main cycle.

Your coffee machine should have the the same initial resources as in the example (400 ml of water, 540 ml of milk, 120 g of coffee beans, 9 disposable cups, $550 in cash.

Output example

Write action (buy, fill, take, remaining, exit): > remaining

The coffee machine has:
400 of water
540 of milk
120 of coffee beans
9 of disposable cups
$550 of money

Write action (buy, fill, take, remaining, exit): > buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: > 2
I have enough resources, making you a coffee!

Write action (buy, fill, take, remaining, exit): > remaining

The coffee machine has:
50 of water
465 of milk
100 of coffee beans
8 of disposable cups
$557 of money

Write action (buy, fill, take, remaining, exit): > take
I gave you $557

Write action (buy, fill, take, remaining, exit): > exit

 */


import java.util.*

var water = 400
var milk = 540
var beans = 120
var cups = 9
var money = 550

const val ESPRESSO = "1"
const val LATTE = "2"
const val CAPPUCCINO = "3"
const val BACK = "back"

const val MSG = "I have enough resources, making you a coffee!"

const val espressoWater = 250
const val espressoBeans = 16
const val espressoCost = 4
const val latteWater = 350
const val latteMilk = 75
const val latteBeans = 20
const val latteCost = 7
const val cappuccinoWater = 200
const val cappuccinoMilk = 100
const val cappuccinoBeans = 12
const val cappuccinoCost = 6

fun main() {
    val scanner = Scanner(System.`in`)
    var exit = false

    do {
        println()

        print("Write action (buy, fill, take, remaining, exit): ")
        val type = scanner.nextLine()
        println()
        when (type) {
            "buy" -> buy(scanner)
            "fill" -> fill(scanner)
            "take" -> take()
            "remaining" -> printValues()
            "exit" -> exit = true
        }

    } while (!exit)

}

fun printValues() {
    println("The coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$beans of coffee beans")
    println("$cups of disposable cups")
    println("$money of money")
}

fun enoughResources(requestedVariety: String): Boolean {
    var reqWater = 0
    var reqMilk = 0
    var reqBeans = 0

    when (requestedVariety) {
        ESPRESSO -> {
            reqWater = espressoWater
            reqMilk = 0
            reqBeans = espressoBeans
        }
        LATTE -> {
            reqWater = latteWater
            reqMilk = latteMilk
            reqBeans = latteBeans
        }
        CAPPUCCINO -> {
            reqWater = cappuccinoWater
            reqMilk = cappuccinoMilk
            reqBeans = cappuccinoBeans
        }
    }

    val message = when {
        cups < 1 -> "Sorry, not enough cups!"
        water < reqWater -> "Sorry, not enough water!"
        milk < reqMilk -> "Sorry, not enough milk!"
        beans < reqBeans -> "Sorry, not enough beans!"
        else -> ""
    }

    return if (message == "") true
    else {
        print(message)
        false
    }

}

fun buy(scanner: Scanner) {

    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    val variety = scanner.nextLine().trim()

    if (enoughResources(variety)) println(MSG)
    else return

    if (variety == ESPRESSO) {
        water -= espressoWater
        beans -= espressoBeans
        money += espressoCost
    }
    if (variety == LATTE) {
        water -= latteWater
        milk -= latteMilk
        beans -= latteBeans
        money += latteCost
    }
    if (variety == CAPPUCCINO) {
        water -= cappuccinoWater
        milk -= cappuccinoMilk
        beans -= cappuccinoBeans
        money += cappuccinoCost
    }
    if (variety == BACK) return
    cups--
}

fun fill(scanner: Scanner) {
    print("Write how many ml of water do you want to add: ")
    val addWater = scanner.nextInt()

    print("Write how many ml of milk do you want to add: ")
    val addMilk = scanner.nextInt()

    print("Write how many grams of coffee beans do you want to add: ")
    val addBeans = scanner.nextInt()

    print("Write how many disposable cups of coffee do you want to add: ")
    val addCups = scanner.nextInt()

    water += addWater
    milk += addMilk
    beans += addBeans
    cups += addCups
}

fun take() {
    println("I gave you \$$money")
    money = 0
}