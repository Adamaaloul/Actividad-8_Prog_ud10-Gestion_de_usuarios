package es.progcipfpbatoi.progud10classwork.Controller.model.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String dni;
    private String correoElectronico;
    private String codigoPostal;
    private String telefonoMovil;
    private LocalDate fechaNacimiento;
    private String password;
    private String repetirPassword;
    
    public Usuario(String dni) {
        this.dni = dni;
    }
    
    public Usuario(String nombre, String apellidos, String dni, String correoElectronico, String codigoPostal, String telefonoMovil, LocalDate fechaNacimiento, String password, String repetirPassword) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correoElectronico = correoElectronico;
        this.codigoPostal = codigoPostal;
        this.telefonoMovil = telefonoMovil;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.repetirPassword = repetirPassword;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String idUsuario) {
        this.dni = idUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


	public String getRepetirPassword() {
		return repetirPassword;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
}
