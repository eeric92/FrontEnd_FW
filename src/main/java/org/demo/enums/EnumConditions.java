package org.demo.enums;

public enum EnumConditions {

    ELEMENT_TO_BE_CLICKABLE("elementToBeClickable"),
    VISIBILITY_OF("visibilityOf"),
    INVISIVILITY_OF("invisibilityOf");

    private String condition;

    EnumConditions(String condition) {
        this.condition = condition;
    }

}
