package com.context;

import com.states.NonWorkingState;
import com.states.PrinterState;

public class PrinterContext {
    private PrinterState currentState;
    private double inkLevel;
    private int paperCount;

    public PrinterContext(double inkLevel, int paperCount) {
        this.inkLevel = inkLevel;
        this.paperCount = paperCount;
        this.currentState = new NonWorkingState();
    }

    public void setState(PrinterState state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handle(this);
    }

    public boolean hasEnoughResources() {
        if (inkLevel <= 0 || paperCount <= 0) {
            System.out.println("Printer is not ready. Please check the resources.");
            return false;
        }
        return true;
    }

    public void useResources(double ink, int paper) {
        if (paper > paperCount || ink > inkLevel) {
            System.out.println("Cannot use more resources than available.");
            System.out.println("Please try again with different parameters or replenish the resources.");
        } else {
            paperCount -= paper;
            inkLevel -= ink;
        }
    }

    public void replenishResources(double ink, int paper) {
        paperCount += paper;
        inkLevel += ink;
    }

    @Override
    public String toString() {
        return String.format("Ink Level: %.1f; Paper Count: %d", inkLevel, paperCount);
    }
}
