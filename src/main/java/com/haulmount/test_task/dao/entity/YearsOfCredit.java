package com.haulmount.test_task.dao.entity;

public enum YearsOfCredit {

    FIVE("5"), TEN("10"), FIFTEEN("15"), TWENTY("20"), THIRTY("30");
    private String numberOfYears;

    YearsOfCredit(String numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public String getNumberOfYears() {
        return numberOfYears;
    }
}
