package cz.misina;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncomeTaxCalculatorTest {

    private IncomeTaxCalculator calc;

    private void checkIncomeTax(double expected, double income) {
        assertEquals(expected, calc.getTaxFor(income), 0.01);
    }

    @Before
    public void setUp() {
        calc = new IncomeTaxCalculator();
    }

    @Test
    public void testZeroIncome() {
        checkIncomeTax(0.0,0);
    }

    @Test
    public void testMinimalIncome() {
        checkIncomeTax(2000, 10000);
    }

    @Test
    public void testAvgSalary() {
        checkIncomeTax(6500, 30000);
    }

    @Test
    public void testFirstBorderSalary() {
        checkIncomeTax(9000, 40000);
    }

    @Test
    public void testBorderSalary() {
        checkIncomeTax(15000, 60000);
    }

    @Test
    public void testGoodSalary() {
        checkIncomeTax(18500, 70000);
    }

    @Test
    public void textSuperSalary() {
        checkIncomeTax(29000, 100000);
    }

    @Test
    public void textSuperSuperSalary() {
        checkIncomeTax(49000, 150000);
    }

    @Test
    public void testNonRoundedSalary() {
        checkIncomeTax(4864, 23456);
    }
}
