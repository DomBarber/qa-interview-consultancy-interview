package q2;

public class FibonacciPrinter {

static int targetFib = 35;

// Generic fibonacci printer, with 'targetFib' provided in order stop at.
static void run() {
    int n1 = 1;
    int n2 = 0;
    for (int i = 1; i <= targetFib; i++) {
        int n3 = n1 + n2;
        System.out.println(i + " : " + n3);
        n1 = n2;
        n2 = n3;
    }
}

// As the question specifically asked to print only the 35th fibonacci number.
static void runOnlyPrintTarget() {
    int n1 = 1;
    int n2 = 0;
    for (int i = 1; i <= targetFib; i++) {
        int n3 = n1 + n2;
        n1 = n2;
        n2 = n3;
        if (i == 35) {
            System.out.println(i + " : " + n3);
        }
    }
}

public static void main(String[] args) {
    run();
    runOnlyPrintTarget();
}
}

//Result:
//
// run()
//        1 : 1
//        2 : 1
//        3 : 2
//        4 : 3
//        5 : 5
//        6 : 8
//        7 : 13
//        8 : 21
//        9 : 34
//        10 : 55
//        11 : 89
//        12 : 144
//        13 : 233
//        14 : 377
//        15 : 610
//        16 : 987
//        17 : 1597
//        18 : 2584
//        19 : 4181
//        20 : 6765
//        21 : 10946
//        22 : 17711
//        23 : 28657
//        24 : 46368
//        25 : 75025
//        26 : 121393
//        27 : 196418
//        28 : 317811
//        29 : 514229
//        30 : 832040
//        31 : 1346269
//        32 : 2178309
//        33 : 3524578
//        34 : 5702887
//        35 : 9227465

// runOnlyPrintTarget()
//        35 : 9227465
