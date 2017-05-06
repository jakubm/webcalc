package cz.misina;

public class IncomeTaxCalculator {

    class IncomeTaxBracket {
        private double min;
        private double max;
        private double taxPercentage;
        private double fixedAmount;

        public double tax(double amount) {
            return (amount - min) * taxPercentage + fixedAmount;
        }

        public boolean within(double amount) {
            return (amount >= min && amount < max);
        }

        public IncomeTaxBracket(double min, double max, double taxPercentage, double fixedAmount) {
            this.min = min;
            this.max = max;
            this.taxPercentage = taxPercentage;
            this.fixedAmount = fixedAmount;
        }
    }

    private IncomeTaxBracket[] brackets = {
      new IncomeTaxBracket(0, 20000, 0.2, 0),
      new IncomeTaxBracket(20000, 40000, 0.25, 4000),
      new IncomeTaxBracket(40000, 60000, 0.30, 9000),
      new IncomeTaxBracket(60000, 100000, 0.35, 15000),
      new IncomeTaxBracket(100000, 999999999, 0.4, 29000),
    };

    public double getTaxFor(double income) {
        for (IncomeTaxBracket bracket: brackets)
            if (bracket.within(income))
                return bracket.tax(income);
        return 0;
    }
}
