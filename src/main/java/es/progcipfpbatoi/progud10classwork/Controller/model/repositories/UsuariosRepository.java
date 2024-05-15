package es.progcipfpbatoi.progud10classwork.Controller.model.repositories;

import es.progcipfpbatoi.progud10classwork.Controller.model.entities.Usuario;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuariosRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuariosRepository() {
        init();
    }

    public void add(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> findAll() {
        return usuarios;
    }

    public Usuario findByDni(Long dni) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean delete(Long dni) {
        Usuario usuario = findByDni(dni);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }

    public Usuario get(String dni) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean delete(String dni) {
        Usuario usuario = get(dni);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }

    private void init() {
        try {
            Usuario usuario1 = new Usuario("Juan", "Pérez", "12345678A", "juan@example.com", "12345", "666666666", LocalDate.of(1990, 1, 1), "password1", "password1");
            Usuario usuario2 = new Usuario("María", "López", "87654321B", "maria@example.com", "54321", "777777777", LocalDate.of(1995, 5, 5), "password2", "password2");
            Usuario usuario3 = new Usuario("Pedro", "González", "98765432C", "pedro@example.com", "67890", "888888888", LocalDate.of(1985, 10, 10), "password3", "password3");
            Usuario usuario4 = new Usuario("Ana", "Martínez", "23456789D", "ana@example.com", "98765", "999999999", LocalDate.of(1980, 12, 25), "password4", "password4");

            usuarios.add(usuario1);
            usuarios.add(usuario2);
            usuarios.add(usuario3);
            usuarios.add(usuario4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario findByNombreAndApellidos(String nombre, String apellidos) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getApellidos().equals(apellidos)) {
                return usuario;
            }
        }
        return null;
    }
}