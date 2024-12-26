package com.printers;

public class HPPrinter {
    private double inkLevel;
    private int paperCount;

    public HPPrinter(double inkLevel, int paperCount) {
        this.inkLevel = inkLevel;
        this.paperCount = paperCount;
    }

    public void printHP() {
        if (isReady()) {
            System.out.println("HP printer is printing...");
            inkLevel -= 1;
            paperCount -= 1;
        }
    }

    public void saveInkModeHP() {
        if (isReady()) {
            System.out.println("HP printer is printing in saving ink mode...");
            inkLevel -= 0.5;
            paperCount -= 1;
        }
    }

    public void performMaintenanceHP() {
        System.out.println("Performing maintenance...");
        inkLevel += 5;
        paperCount += 5;
    }

    public boolean isReady() {
        if (inkLevel <= 0 || paperCount <= 0) {
            System.out.println("Printer is not ready. Please check the resources.");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Ink Level: %.1f; Paper Count: %d", inkLevel, paperCount);
    }
}