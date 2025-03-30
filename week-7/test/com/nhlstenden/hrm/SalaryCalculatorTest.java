package com.nhlstenden.hrm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class SalaryCalculatorTest {

        private Employee employeeWithGoodPerformance;
        private Employee employeeWithNoGoodPerformance;
        private Employee employeeWithMultipleGoodPerformances;
        private SalaryCalculator calculatorGoodPerformance;
        private SalaryCalculator calculatorNoGoodPerformance;
        private SalaryCalculator calculatorMultipleGoodPerformances;

        @BeforeEach
        public void setUp() {
                HashMap<Integer, Performance> oneGoodPerf = new HashMap<>();
                oneGoodPerf.put(2020, Performance.Good);
                employeeWithGoodPerformance = new Employee("John", 101,
                                LocalDate.of(1990, 1, 1),
                                LocalDate.of(2015, 1, 1),
                                oneGoodPerf, true, true);

                HashMap<Integer, Performance> noGoodPerf = new HashMap<>();
                noGoodPerf.put(2020, Performance.Neutral);
                employeeWithNoGoodPerformance = new Employee("Jane", 102,
                                LocalDate.of(1985, 1, 1),
                                LocalDate.of(2010, 1, 1),
                                noGoodPerf, false, true);

                HashMap<Integer, Performance> multipleGoodPerf = new HashMap<>();
                multipleGoodPerf.put(2019, Performance.Good);
                multipleGoodPerf.put(2020, Performance.Good);
                multipleGoodPerf.put(2021, Performance.Good);
                employeeWithMultipleGoodPerformances = new Employee("Bob", 103,
                                LocalDate.of(1980, 1, 1),
                                LocalDate.of(2005, 1, 1),
                                multipleGoodPerf, true, false);

                calculatorGoodPerformance = new SalaryCalculator(employeeWithGoodPerformance);
                calculatorNoGoodPerformance = new SalaryCalculator(employeeWithNoGoodPerformance);
                calculatorMultipleGoodPerformances = new SalaryCalculator(employeeWithMultipleGoodPerformances);
        }

        @Test
        public void testGetGrossSalary() {
                BigDecimal expectedBase = new BigDecimal(1500);

                assertEquals(expectedBase.setScale(2, RoundingMode.HALF_UP),
                                calculatorNoGoodPerformance.getGrossSalary());

                BigDecimal expectedOneGood = expectedBase.multiply(new BigDecimal("1.023")).setScale(2,
                                RoundingMode.HALF_UP);
                assertEquals(expectedOneGood, calculatorGoodPerformance.getGrossSalary());

                BigDecimal expectedMultipleGood = expectedBase
                                .multiply(new BigDecimal("1.023"))
                                .multiply(new BigDecimal("1.023"))
                                .multiply(new BigDecimal("1.023"))
                                .setScale(2, RoundingMode.HALF_UP);
                assertEquals(expectedMultipleGood, calculatorMultipleGoodPerformances.getGrossSalary());
        }

        @Test
        public void testGetNetSalary() {
                BigDecimal netWithTaxCreditAndInsurance = calculatorGoodPerformance.getNetSalary();
                BigDecimal netWithoutTaxCreditWithInsurance = calculatorNoGoodPerformance.getNetSalary();
                BigDecimal netWithTaxCreditWithoutInsurance = calculatorMultipleGoodPerformances.getNetSalary();

                BigDecimal expectedNet1 = calculatorGoodPerformance.getGrossSalary()
                                .subtract(calculatorGoodPerformance.getGrossSalary().multiply(new BigDecimal("0.1")))
                                .subtract(calculatorGoodPerformance.getGrossSalary().multiply(new BigDecimal("0.01")))
                                .setScale(2, RoundingMode.HALF_UP);
                assertEquals(expectedNet1, netWithTaxCreditAndInsurance);

                BigDecimal expectedNet2 = calculatorNoGoodPerformance.getGrossSalary()
                                .subtract(calculatorNoGoodPerformance.getGrossSalary().multiply(new BigDecimal("0.15")))
                                .subtract(calculatorNoGoodPerformance.getGrossSalary().multiply(new BigDecimal("0.01")))
                                .setScale(2, RoundingMode.HALF_UP);
                assertEquals(expectedNet2, netWithoutTaxCreditWithInsurance);

                BigDecimal expectedNet3 = calculatorMultipleGoodPerformances.getGrossSalary()
                                .subtract(calculatorMultipleGoodPerformances.getGrossSalary()
                                                .multiply(new BigDecimal("0.1")))
                                .setScale(2, RoundingMode.HALF_UP);
                assertEquals(expectedNet3, netWithTaxCreditWithoutInsurance);
        }

        @Test
        public void testGetBonus() {
                BigDecimal expectedBonus1 = calculatorGoodPerformance.getGrossSalary()
                                .multiply(new BigDecimal("0.08"))
                                .setScale(2, RoundingMode.HALF_UP);
                assertEquals(expectedBonus1, calculatorGoodPerformance.getBonus());

                BigDecimal expectedBonus2 = calculatorNoGoodPerformance.getGrossSalary()
                                .multiply(new BigDecimal("0.08"))
                                .setScale(2, RoundingMode.HALF_UP);
                assertEquals(expectedBonus2, calculatorNoGoodPerformance.getBonus());
        }

        @Test
        public void testSetEmployee() {
                SalaryCalculator calculator = new SalaryCalculator(employeeWithGoodPerformance);

                calculator.setEmployee(employeeWithNoGoodPerformance);

                assertEquals(employeeWithNoGoodPerformance, calculator.getEmployee());
                BigDecimal expectedNewGross = new BigDecimal(1500).setScale(2, RoundingMode.HALF_UP);
                assertEquals(expectedNewGross, calculator.getGrossSalary());
        }
}