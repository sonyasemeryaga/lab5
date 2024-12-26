package com.printers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HPPrinterTest {
    @Test
    public void testHPPrinterPrint() {
        HPPrinter printer = new HPPrinter(10, 10);
        printer.printHP();
        String expected = "Ink Level: 9,0, Paper Count: 9";
        assertEquals(expected, printer.toString());
    }
}
