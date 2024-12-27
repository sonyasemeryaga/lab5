package com.printers;

public class CanonPrinter {
    private double inkLevel;
    private int paperCount;

    public CanonPrinter(double inkLevel, int paperCount) {
        this.inkLevel = inkLevel;
        this.paperCount = paperCount;
    }

    public void printCanon() {
        if (isReady()) {
            System.out.println("Canon printer is printing...");
            inkLevel -= 1;
            paperCount -= 1;
        }
    }

    public void saveInkModeCanon() {
        if (isReady()) {
            System.out.println("Canon printer is printing in saving ink mode...");
            inkLevel -= 0.5;
            paperCount -= 1;
        }
    }

    public void performMaintenanceCanon() {
        System.out.println("Canon printer is performing maintenance...");
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
