package coffee_machine

/*
Stage #2 : Calculate Resources required
Description

Now let's consider a case where you need a lot of coffee.
Maybe, for example, you’re hosting a party with a lot of guests.
The program should calculate how much water, coffee beans, and milk are necessary to make the specified amount of coffee.
One cup of coffee made on this coffee machine contains 200 ml of water, 50 ml of milk, and 15 g of coffee beans.
The user should input the amount of coffee he needs, in cups, for all the guests.

Of course, all this coffee is not needed right now, so at this stage, the coffee machine doesnt actually make any coffee.
The example below shows how your output might look.

------------------------------------------------------------------------------------------------------------------------
Sample Output:

Write how many cups of coffee you will need: 25
For 25 cups of coffee you will need:
5000 ml of water
1250 ml of milk
375 g of coffee beans

 */

fun main() {
    print("How many cups of coffee you will need: >")
    // !! indicates that cups cannot be null
    val cups = readLine()!!.toInt()
    println("For $cups cups of coffee you will need:")
    val water:Int = cups*200
    val milk:Int = cups*50
    val beans:Int = cups*15
    println("$water ml of water")
    println("$milk ml of milk")
    println("$beans g of coffee beans")
}
