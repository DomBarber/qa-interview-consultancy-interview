package taxcalc;

class TaxCalc {

    int percent;

    TaxCalc(int percent) {
        this.percent = percent;
    }

    @SafeVarargs
    final Pair<Integer, String> netAmount(Pair<Integer, String>... pairs) {

        String currency = pairs[0].currency;
        int totalAmount = 0;

        for (Pair<Integer, String> pair : pairs) {
            if (!pair.currency.equals(currency)) {
                throw new ApplicationException("Currency type does not match");
            }
            totalAmount = totalAmount + pair.amount;
            System.out.println("Total Amount = " + totalAmount);
        }

        double taxAmount = totalAmount * (percent / 100d);
        Pair<Integer, String> tax = new Pair<>((int) taxAmount, currency);

        return new Pair<>(totalAmount - tax.amount, currency);
    }

    static class Pair<A, B> {
        final A amount;
        final B currency;

        Pair(A amount, B currency) {
            this.amount = amount;
            this.currency = currency;
        }
    }
}

// In order for the calculator to stay relevant, I would be looking to support additional currency pairs as needed.
// This appears to be the original intention by design due to the Pairs used with <Int, String>, allowing for the currency type to be specified.