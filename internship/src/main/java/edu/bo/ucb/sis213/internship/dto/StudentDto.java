package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Student;

public class StudentDto {
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private String departamento;
    private boolean validacionUCB;
    private String sede;
    private String carrera;
    private String anioIngreso;
    private String correoElectronico;
    private String contrasena;
    private String confirmarContrasena;
    //Constructor
    public StudentDto() {
    }

    public StudentDto(String nombres, String primerApellido, String segundoApellido, String tipoDocumento, String numeroDocumento, String departamento, boolean validacionUCB, String sede, String carrera, String anioIngreso, String correoElectronico, String contrasena, String confirmarContrasena) {
        this.nombres = nombres;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroDocumento = numeroDocumento;
        this.departamento = departamento;
        this.validacionUCB = validacionUCB;
        this.sede = sede;
        this.carrera = carrera;
        this.anioIngreso = anioIngreso;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.confirmarContrasena = confirmarContrasena;
    }

    public StudentDto(Student student) {
        this.nombres = student.getPersonIdPerson().getNames();
        this.primerApellido = student.getPersonIdPerson().getFirstLastName();
        this.segundoApellido = "";
        this.tipoDocumento = "CI";
        this.numeroDocumento = "";
        this.departamento = "";
        this.validacionUCB = student.getGraduate();
        this.sede = "";
        this.carrera = student.getCareerIdCarrer().getCareerName();
        this.anioIngreso = "";
        this.correoElectronico = "";
        this.contrasena = "";
        this.confirmarContrasena = "";
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isValidacionUCB() {
        return validacionUCB;
    }

    public void setValidacionUCB(boolean validacionUCB) {
        this.validacionUCB = validacionUCB;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(String anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmarContrasena() {
        return confirmarContrasena;
    }

    public void setConfirmarContrasena(String confirmarContrasena) {
        this.confirmarContrasena = confirmarContrasena;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "nombres='" + nombres + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", departamento='" + departamento + '\'' +
                ", validacionUCB=" + validacionUCB +
                ", sede='" + sede + '\'' +
                ", carrera='" + carrera + '\'' +
                ", anioIngreso='" + anioIngreso + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", confirmarContrasena='" + confirmarContrasena + '\'' +
                '}';
    }
}

