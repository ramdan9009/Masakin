package com.ramdan.masakin.entity;

/**
 * Created by ramdan on 27/12/17.
 */

public class Kitchen {
    String kitchenName;
    String kitcheOwner;
    String foto;
    String description;

    public Kitchen(String kitchenName, String kitcheOwner, String description) {
        this.kitchenName = kitchenName;
        this.kitcheOwner = kitcheOwner;
        this.description = description;
    }

    public Kitchen(String kitchenName, String kitcheOwner, String foto, String description) {
        this.kitchenName = kitchenName;
        this.kitcheOwner = kitcheOwner;
        this.foto = foto;
        this.description = description;
    }

    public String getKitchenName() {
        return kitchenName;
    }

    public void setKitchenName(String kitchenName) {
        this.kitchenName = kitchenName;
    }

    public String getKitcheOwner() {
        return kitcheOwner;
    }

    public void setKitcheOwner(String kitcheOwner) {
        this.kitcheOwner = kitcheOwner;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
