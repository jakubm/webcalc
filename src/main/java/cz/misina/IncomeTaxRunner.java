package cz.misina;

public class IncomeTaxRunner {
    public static void main(String[] args) {
        IncomeTaxCalculator calculator = new IncomeTaxCalculator();
        for (int i = 0; i < 501000; i += 5000) {
            System.out.println(i + "\t" + calculator.getTaxFor(i) + "\t" + calculator.getTaxFor(i)/i * 100);
        }
    }
}
