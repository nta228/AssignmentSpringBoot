package com.example.assignmentspringboot.entity.myEnum;

public enum StreetStatus {
    USING(1), UNDER_CONSTRUCTION(0),UNDER_REPAIR(-1), UNDEFINED(-2);
    private int value;

    StreetStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static StreetStatus of(int value){
        for (StreetStatus streetStatus: StreetStatus.values()
        ) {
            if (streetStatus.getValue() == value) {
                return streetStatus;
            }
        }
        return UNDEFINED;
    }
}