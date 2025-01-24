package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Access(AccessType.FIELD)
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersona;
    @Transient
    private String nombre;
    @Transient
    private String apellidos;

    @Basic
    private int edad;

    @Transient
    private LocalDate fechaNacimiento;
    @Convert(converter = ConvertidorSexo.class)
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    @Lob
    private byte[] foto;

    public Persona(){}

    public Persona(long idPersona, String nombre, String apellidos, LocalDate fechaNacimiento, Sexo sexo, EstadoCivil estadoCivil, byte[] foto) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.foto = foto;
    }

    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento, Sexo sexo, EstadoCivil estadoCivil, byte[] foto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.foto = foto;
    }

    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento, EstadoCivil estadoCivil, Sexo sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
    }

    public Persona (String nom, String apellidos){
        this.nombre=nom;
        this.apellidos=apellidos;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "nombre_completo")
    public String getNombreCompleto(){
        String [] apellidosNew = apellidos.split(" ");
        String primApe = convertirMayus(apellidosNew[0]);
        String segApe = convertirMayus(apellidosNew[1]);
        String nom = convertirMayus(nombre);
        String nombreCompl =primApe+","+segApe+","+nom;
        return nombreCompl;
    }

    public void setNombreCompleto(String nombreCompleto) {
        // Setter vacío, necesario para Hibernate
    }

    public String convertirMayus(String palabra){
        String primMayus= palabra.replaceFirst(String.valueOf(palabra.charAt(0)), String.valueOf(palabra.charAt(0)).toUpperCase());
        return primMayus;
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @PrePersist
    public void obtenerEdad(){
        if (fechaNacimiento!=null) {
            int ed = (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
            this.edad = ed;
        } else {
            throw new IllegalStateException();
        }
    }

    @PostLoad
    public void obtenerFecha(){
        if (edad>0){
            this.fechaNacimiento=LocalDate.now().minusYears(edad);
        }
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }




}
