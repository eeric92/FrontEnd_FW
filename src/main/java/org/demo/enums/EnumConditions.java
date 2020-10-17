package org.demo.enums;

public enum EnumConditions {

    PRESENCE_OF_ELEMENT_LOCATED("presenceOfElementLocated"),
    TEXT_TO_BE_PRESENT_IN_ELEMENT("textToBePresentInElement"),
    ELEMENT_TO_BE_CLICKABLE("elementToBeClickable"),
    VISIBILITY_OF("visibilityOf"),
    FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT("frameToBeAvailableAndSwitchToIt"),
    PRESENCE_OF_ALL_ELEMENTS_LOCATED_BY("presenceOfAllElementsLocatedBy"),
    INVISIVILITY_OF("invisibilityOf"),
    ELEMENT_TO_BE_SELECTED("elementToBeSelected");

    private String condition;

    EnumConditions(String condition) {
        this.condition = condition;
    }

}
