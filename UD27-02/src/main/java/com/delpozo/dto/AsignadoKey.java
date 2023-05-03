package com.delpozo.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class AsignadoKey implements Serializable {

    @Column(name = "dni")
    private String dniCientifico;

    @Column(name = "id_proyecto")
    private String idProyecto;

    public AsignadoKey() {
    }

    public AsignadoKey(String dniCientifico, String idProyecto) {
        this.dniCientifico = dniCientifico;
        this.idProyecto = idProyecto;
    }

    public String getDniCientifico() {
        return dniCientifico;
    }

    public void setDniCientifico(String dniCientifico) {
        this.dniCientifico = dniCientifico;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignadoKey that = (AsignadoKey) o;
        return Objects.equals(dniCientifico, that.dniCientifico) && Objects.equals(idProyecto, that.idProyecto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dniCientifico, idProyecto);
    }
}

