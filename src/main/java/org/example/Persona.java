package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersona;
    @Transient
    private String nombre;
    @Transient
    private String apellidos;
    private LocalDate fechaNacimiento;
    @Enumerated(EnumType.STRING)
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
