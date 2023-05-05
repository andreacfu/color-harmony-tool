package com.klutzynome.model;

public class Input {
    private String inputColor; // matches html
    private String complimentaryCalculation; // "selected" or ""
    private String monochromeCalculation; // "selected" or ""

    private String colorblindOpt; // "p", "d", "t" or ""

    public String getColorblindOpt() {
        return colorblindOpt;
    }

    public void setColorblindOpt(String colorblindOpt) {
        this.colorblindOpt = colorblindOpt;
    }

    private ColorCalculator calculator;

    public Input () {
        calculator = new ColorCalculator();
        complimentaryCalculation = "";
        monochromeCalculation = "";
        inputColor = "";
        colorblindOpt = "";

    }

    @Override
    public String toString() {
        return "Input Color: " + inputColor + " Complimentary: " + complimentaryCalculation + " Monochrome: " + monochromeCalculation;
    }
    public boolean isValidColor() {
        return (this.inputColor.length() == 6) && (this.inputColor.matches("-?[0-9a-fA-F]+"));
    }
    public String handleComplimentSelection() {
        return calculator.calculateCompliment(inputColor);
    }
    public String[] handleMonochromeResult() {
        return calculator.calculateMonochrome(inputColor);
    }

    public String getInputColor() {
        return inputColor;
    }
    // returns true if a calculation is selected
    public boolean getComplimentarySelection() {
        return this.complimentaryCalculation.equals("selected");
    }
    public boolean getMonochromeSelection() {
        return this.monochromeCalculation.equals("selected");
    }
    public void setInputColor(String inputColor) {
        this.inputColor = inputColor;
    }

    public void setComplimentaryCalculation(String complimentaryCalculation) {
        this.complimentaryCalculation = complimentaryCalculation;
    }

    public String getMonochromeCalculation() {
        return monochromeCalculation;
    }

    public void setMonochromeCalculation(String monochromeCalculation) {
        this.monochromeCalculation = monochromeCalculation;
    }

    public String getComplimentaryCalculation() {
        return complimentaryCalculation;
    }

    public Object hasColorblindOpt() {
        return colorblindOpt.equals("p") || colorblindOpt.equals("d") || colorblindOpt.equals("t");
    }
}