package com.autoservice.storage.mapping;

import com.netflix.astyanax.annotations.Component;

public class AvailableAutoKey {

    @Component(ordinal = 0)
    String carBrand;


    public AvailableAutoKey() {
    }

    public AvailableAutoKey(String carBrand) {

        this.carBrand = carBrand;
    }


    public AvailableAutoKey(AvailableAutoKey key) {
        this.carBrand = key.carBrand;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvailableAutoKey that = (AvailableAutoKey) o;

        if (!carBrand.equals(that.carBrand)) return false;

        return true;
    }

    // @Override
    // notes that public access and without throws CloneNotSupportedException, and with specific return type
    public AvailableAutoKey clone() {
        return new AvailableAutoKey(this);
    }

    @Override
    public String toString() {
        return "AvailableAutoKey{" +
                "carBrand='" + carBrand +
                '}';
    }
}
