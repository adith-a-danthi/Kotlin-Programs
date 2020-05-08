/*
# Game Of Increments

Input
Line 1 - test cases
Line 2 - n, q separated by spaces
Line 3 - query[]

Output
arr[]

Two arrays query[] of size q and arr[] of size n. Array arr[] has all elements initialized to 0.
For each query[i] if it is a valid index then arr[query[i]] is incremented by 1 else all the elements of arr[] is assigned to the max value in the array.

Sample Input:
1
5 5
1 12 0 1 2

Sample Output:
2 2 2 1 1

 */
fun main() {
    var testCases = readLine()!!.toInt()

    while (testCases >= 0) {
        val (a, b) = readLine()!!.split(' ')
        val n: Int = a.trim().toInt()
        val q: Int = b.trim().toInt()
        val arr = IntArray(n) { 0 }
        val query = readLine()!!.trim().split(" ")
        for (ele in query) {
            val item = ele.trim().toInt()
            if (item < n) {
                arr[item] += 1
            } else {
                val maxVal = arr.max()!!
                for (j in 0 until n) {
                    arr[j] = maxVal
                }
            }
        }
        testCases -= 1
        for (ele in arr) {
            print("$ele ")
        }
    }
}

