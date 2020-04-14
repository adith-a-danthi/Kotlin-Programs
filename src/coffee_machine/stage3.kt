package coffee_machine

import java.lang.Integer.min
import java.util.*

/*
Stage #3: Check if there are enough resources

Description

A real coffee machine never has an infinite supply of water, milk, or coffee beans.
And if you input a really big number, it’s almost certain that a real coffee machine wouldn't have
the supplies needed to make all that coffee.

In this stage, you need to improve the previous program.
Now you need to input amounts of water, milk, and coffee beans that your coffee machine has at the moment.

If the coffee machine has enough supplies to make the specified amount of coffee,
the program should print "Yes, I can make that amount of coffee".
If the coffee machine can make more than that, the program should output
"Yes, I can make that amount of coffee (and even N more than that)",
where N is the number of additional cups of coffee that the coffee machine can make.
If the amount of resources is not enough to make the specified amount of coffee,
the program should output "No, I can make only N cups of coffee".

Like in the previous stage, the coffee machine needs 200 ml of water, 50 ml of milk, and 15 g of coffee beans
to make one cup of coffee.

Output example
The program should firstly request for a water, then milk, then beans, then amount of cups.
Write how many ml of water the coffee machine has: 300
Write how many ml of milk the coffee machine has: 65
Write how many grams of coffee beans the coffee machine has: 100
Write how many cups of coffee you will need: 1
Yes, I can make that amount of coffee
---
Water, Milk, Beans, Cups
---
500, 250, 200, 10
No, I can make only 2 cups of coffee
---
1550, 299, 300, 3
Yes, I can make that amount of coffee (and even 2 more than that)
---
0, 0, 0, 1
No, I can make only 0 cups of coffee
---
0, 0, 0, 0
Yes, I can make that amount of coffee
---
200, 50, 15, 0
Yes, I can make that amount of coffee (and even 1 more than that)
 */

fun main() {
    val sc = Scanner(System.`in`)

    print("Write how many ml of water the coffee machine has: ")
    val mWater = sc.nextInt()

    print("Write how many ml of milk the coffee machine has: ")
    val mMilk = sc.nextInt()

    print("Write how many grams of coffee beans the coffee machine has: ")
    val mBeans = sc.nextInt()

    print("Write how many cups of coffee you will need: ")
    val cups: Int = sc.nextInt()

    if (mWater > cups*200 && mMilk > cups*50 && mBeans > cups*15){
        var max = min(mWater/(cups*200), mMilk/(cups*50))
        max = min(max,mBeans/(cups*15))
        if (max == cups){
            print("Yes, I can make that amount of coffee")
        } else {
            println("Yes, I can make that amount of coffee (and even ${max-cups} more than that)")
        }
    } else {
        var max: Int = min(mWater/200, mMilk/50)
        max = min(max,mBeans/15)
        print("No, I can make only $max cups of coffee")
    }

}