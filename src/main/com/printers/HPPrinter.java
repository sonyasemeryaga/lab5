package com.printers;

public class HPPrinter {
    private double inkLevel;
    private int paperCount;

    public HPPrinter(double inkLevel, int paperCount) {
        this.inkLevel = inkLevel;
        this.paperCount = paperCount;
    }

    public void printHP() {
        if (inkLevel > 0 && paperCount > 0) {
            inkLevel -= 1;
            paperCount -= 1;
        }
    }

    public void saveInkModeHP() {
        if (inkLevel > 0 && paperCount > 0) {
            inkLevel -= 0.5;
            paperCount -= 1;
        }
    }

    public void performMaintenanceHP() {
        inkLevel += 5;
        paperCount += 5;
    }

    @Override
    public String toString() {
        return String.format("Ink Level: %.1f; Paper Count: %d", inkLevel, paperCount);
    }
}
