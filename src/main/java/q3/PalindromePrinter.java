package q3;

public class PalindromePrinter {

    static int cap = 1000;

    static void run() {
        int i = 1;
        while (i <= cap) {
            if (i >= 10) {
                if (isPalindrome(i)) {
                    System.out.println((i));
                }
            }
            i++;
        }
    }

    static boolean isPalindrome(Integer value) {
        String intString = value.toString();
        String intStringReverse = new StringBuilder(intString).reverse().toString();
        return (Integer.parseInt(intString) == Integer.parseInt(intStringReverse));
    }

    public static void main(String[] args) {
        run();
    }
}

//Result:
//
//        11
//        22
//        33
//        44
//        55
//        66
//        77
//        88
//        99
//        101
//        111
//        121
//        131
//        141
//        151
//        161
//        171
//        181
//        191
//        202
//        212
//        222
//        232
//        242
//        252
//        262
//        272
//        282
//        292
//        303
//        313
//        323
//        333
//        343
//        353
//        363
//        373
//        383
//        393
//        404
//        414
//        424
//        434
//        444
//        454
//        464
//        474
//        484
//        494
//        505
//        515
//        525
//        535
//        545
//        555
//        565
//        575
//        585
//        595
//        606
//        616
//        626
//        636
//        646
//        656
//        666
//        676
//        686
//        696
//        707
//        717
//        727
//        737
//        747
//        757
//        767
//        777
//        787
//        797
//        808
//        818
//        828
//        838
//        848
//        858
//        868
//        878
//        888
//        898
//        909
//        919
//        929
//        939
//        949
//        959
//        969
//        979
//        989
//        999
