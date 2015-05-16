package com.autoservice.storage.mapping;

import javax.persistence.Column;
import java.util.Map;


/**
 * DetailsData container
 */

/*
---- TABLE DECLARATION

CREATE TABLE availableAuto (
logo VARCHAR,
carBrand  VARCHAR,
modelsAuction  map<VARCHAR, VARCHAR>,
modelsCatalog  map<VARCHAR, VARCHAR>,
PRIMARY KEY(carBrand));

*/


public class AvailableAutoEntity {

    AvailableAutoKey key /*carBrand*/;


    // Not mapped, not used in comparing
    @Column
    String logo;

    @Column
    Map<String, String> modelsAuction;

    @Column
    Map<String, String> modelsCatalog;


    public AvailableAutoEntity() {
    }

    public AvailableAutoEntity(String logo, Map<String, String> modelsAuction, Map<String, String> modelsCatalog) {
        this.logo = logo;
        this.modelsAuction = modelsAuction;
        this.modelsCatalog = modelsCatalog;


    }


    public AvailableAutoEntity(AvailableAutoEntity availableAuto) {
        this.logo = availableAuto.logo;
        this.modelsAuction = availableAuto.modelsAuction;
        this.modelsCatalog = availableAuto.modelsCatalog;
    }


    public AvailableAutoKey getKey() {
        return key;
    }

    public void setKey(AvailableAutoKey key) {
        this.key = key;
    }

    // notes that public access and without throws CloneNotSupportedException, and with specific return type

    public AvailableAutoEntity clone() {
        return new AvailableAutoEntity(this);
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Map<String, String> getModelsAuction() {
        return modelsAuction;
    }

    public void setModelsAuction(Map<String, String> modelsAuction) {
        this.modelsAuction = modelsAuction;
    }

    public Map<String, String> getModelsCatalog() {
        return modelsCatalog;
    }

    public void setModelsCatalog(Map<String, String> modelsCatalog) {
        this.modelsCatalog = modelsCatalog;
    }


    /*@Override
    public int compareTo(LessonEntity o) {
        int firstCheck =
                Integer.parseInt(this.upper) - Integer.parseInt(o.upper);
        if (firstCheck != 0) {
            return firstCheck;
        } else {
            return Integer.parseInt(this.lower) - Integer.parseInt(o.lower);
        }
    }*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvailableAutoEntity that = (AvailableAutoEntity) o;

        if (!logo.equals(that.logo)) return false;
        if (!modelsAuction.equals(that.modelsAuction)) return false;
        if (!modelsCatalog.equals(that.modelsCatalog)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "AvailableAutoEntity{" +
                " logo='" + logo + '\'' +
                ", modelsAuction='" + modelsAuction + '\'' +
                ", modelsCatalog='" + modelsCatalog + '\'' +
                '}';
    }

}
