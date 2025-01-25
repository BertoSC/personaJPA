package org.example;

import jakarta.persistence.*;

@Entity
public class Direccion {
    @TableGenerator(name="Direccion_Gen",
            table="LONG_ID_GEN",
            pkColumnName="nomePK",
            valueColumnName="valorPK",
            pkColumnValue="DIRECCION_ID",
            initialValue=2000,
            allocationSize=50)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Direccion_Gen" )
    Long id;
    String calle;
    String ciudad;

    public Direccion() {
    }

    public Direccion(Long id, String calle, String ciudad) {
        this.id = id;
        this.calle = calle;
        this.ciudad = ciudad;
    }

    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
