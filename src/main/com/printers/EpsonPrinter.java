package com.printers;

public class EpsonPrinter {
    private double inkLevel;
    private int paperCount;

    public EpsonPrinter(double inkLevel, int paperCount) {
        this.inkLevel = inkLevel;
        this.paperCount = paperCount;
    }

    public void printEpson() {
        if (isReady()) {
            System.out.println("Epson printer is printing...");
            inkLevel -= 1;
            paperCount -= 1;
        }
    }

    public void saveInkModeEpson() {
        if (isReady()) {
            System.out.println("Epson printer is printing in saving ink mode...");
            inkLevel -= 0.5;
            paperCount -= 1;
        }
    }

    public void performMaintenanceEpson() {
        System.out.println("Epson printer is performing maintenance...");
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
