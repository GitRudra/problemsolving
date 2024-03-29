package org.home.design.cricinfo.entity;

import java.util.Objects;

public class Country {

    private String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return Objects.equals(getName(), country.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
