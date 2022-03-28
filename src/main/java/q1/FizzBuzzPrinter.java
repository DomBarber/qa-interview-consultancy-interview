package q1;

public class FizzBuzzPrinter {

// TODO update this answer to use latest java features / less verbose

static int fizz = 3;
static int buzz = 5;
static int cap = 100;

static void run() {
    int i = 1;
    while (i <= cap) {
        System.out.println(fizzBuzzer(i));
        i++;
    }
}

static boolean isFizz(Float value) {
    return (value / fizz) % 1 == 0;
}
static boolean isBuzz(Float value) {
    return (value / buzz) % 1 == 0;
}

static String fizzBuzzer(Integer value) {
    String intString = "";

    if (isFizz(value.floatValue())) {
        intString = intString.concat("Fizz");
    }

    if(isBuzz(value.floatValue())) {
        intString = intString.concat("Buzz");
    }

    if (intString.isEmpty()) {
        intString = value.toString();
    }

    return intString;
}

public static void main(String[] args) {
    run();
}
}
//Result:
//
//        1
//        2
//        Fizz
//        4
//        Buzz
//        Fizz
//        7
//        8
//        Fizz
//        Buzz
//        11
//        Fizz
//        13
//        14
//        FizzBuzz
//        16
//        17
//        Fizz
//        19
//        Buzz
//        Fizz
//        22
//        23
//        Fizz
//        Buzz
//        26
//        Fizz
//        28
//        29
//        FizzBuzz
//        31
//        32
//        Fizz
//        34
//        Buzz
//        Fizz
//        37
//        38
//        Fizz
//        Buzz
//        41
//        Fizz
//        43
//        44
//        FizzBuzz
//        46
//        47
//        Fizz
//        49
//        Buzz
//        Fizz
//        52
//        53
//        Fizz
//        Buzz
//        56
//        Fizz
//        58
//        59
//        FizzBuzz
//        61
//        62
//        Fizz
//        64
//        Buzz
//        Fizz
//        67
//        68
//        Fizz
//        Buzz
//        71
//        Fizz
//        73
//        74
//        FizzBuzz
//        76
//        77
//        Fizz
//        79
//        Buzz
//        Fizz
//        82
//        83
//        Fizz
//        Buzz
//        86
//        Fizz
//        88
//        89
//        FizzBuzz
//        91
//        92
//        Fizz
//        94
//        Buzz
//        Fizz
//        97
//        98
//        Fizz
//        Buzz


