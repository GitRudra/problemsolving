package org.home.design.cricinfo.enums;

public enum MatchResults {
    LIVE("Live"),
    FINISHED("Finished"),
    DRAWN("Drawn"),
    CANCELED("Canceled");

    String value;

    MatchResults(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
