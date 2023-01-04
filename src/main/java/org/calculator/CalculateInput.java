package org.calculator;

public class CalculateInput {

    private String operator = null;
    private Integer firstCalculateNumber = null;
    private Integer secondCalculateNumber = null;

    public boolean hasOperator(){
        return operator != null;
    }

    public boolean hasFirstCalculateNumber(){
        return firstCalculateNumber != null;
    }

    public boolean hasSecondCalculateNumber(){
        return secondCalculateNumber != null;
    }

    public boolean readyToCalculate(){
        return firstCalculateNumber != null && secondCalculateNumber != null && operator != null;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getSecondCalculateNumber() {
        return secondCalculateNumber;
    }

    public void setSecondCalculateNumber(Integer secondCalculateNumber) {
        this.secondCalculateNumber = secondCalculateNumber;
    }

    public Integer getFirstCalculateNumber() {
        return firstCalculateNumber;
    }
    public void setFirstCalculateNumber(Integer firstCalculateNumber) {
        this.firstCalculateNumber = firstCalculateNumber;
    }
}