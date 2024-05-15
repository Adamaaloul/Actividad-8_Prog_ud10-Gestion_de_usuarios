package es.progcipfpbatoi.progud10classwork.Controller;

import es.progcipfpbatoi.progud10classwork.Controller.model.entities.Usuario;
import es.progcipfpbatoi.progud10classwork.Controller.model.repositories.UsuariosRepository;
import es.progcipfpbatoi.progud10classwork.exceptions.NotFoundException;
import es.progcipfpbatoi.progud10classwork.validator.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class UsuarioController {
	@Autowired
    private UsuariosRepository usuariosRepository;
    
    @GetMapping("/usuario-add")
    public String usuarioFormActionView() {
        return "form_usuarios_view";
    }
    
    @PostMapping(value = "/usuario-add")
    public String postAddAction(@RequestParam Map<String, String> params,
    	RedirectAttributes redirectAttributes) {
        	String nombre = params.get("nombre");
            String apellidos = params.get("apellidos");
            String dni = params.get("dni");
            String correoElectronico = params.get("correoElectronico");
            String telefonoMovil = params.get("telefono");
            String fecha = params.get("birthday");
            LocalDate fechaNacimiento = null;
            if (fecha != null) {
            	 fechaNacimiento = LocalDate.parse(fecha);
            } else {
            	redirectAttributes.addFlashAttribute("error", "La fecha de nacimiento es requerida");
            	return "redirect:/usuario-add";
            }
            String codPostalStr = params.get("codPostal");
            int codigoPostal = Integer.parseInt(codPostalStr);
            String password = params.get("password");
            String repetirPassword = params.get("passwordRepeat");
            
        HashMap<String, String> errors = new HashMap<>();

        if (!Validator.isValidText(nombre)) {
            errors.put("nombre", "El nombre debe tener al menos 5 caracteres y comenzar con mayúscula");
        }

        if (!Validator.isValidText(apellidos)) {
            errors.put("apellidos", "Los apellidos deben tener al menos 5 caracteres y comenzar con mayúscula");
        }

        if (!Validator.isValidDNI(dni)) {
            errors.put("dni", "El DNI no es válido");
        }

        if (!Validator.isValidPostalCode(codPostalStr)) {
            errors.put("codigoPostal", "El código postal no es válido");
        }

        if (!Validator.isValidPhoneNumber(telefonoMovil)) {
            errors.put("telefonoMovil", "El número de teléfono móvil no es válido");
        }

        if (!Validator.isValidEmail(correoElectronico)) {
            errors.put("correoElectronico", "El correo electrónico no es válido");
        }

        if (!Validator.isValidPassword(password)) {
            errors.put("password", "La contraseña no cumple con los requisitos");
        }

        if (password == null || repetirPassword == null) {
            errors.put("password", "La contraseña y la repetición de la contraseña no pueden ser nulas");
        } else {
            if (!password.equals(repetirPassword)) {
                errors.put("repetirPassword", "Las contraseñas no coinciden");
            }
        }
        
        if(errors.size() > 0){
        	redirectAttributes.addFlashAttribute("errors", errors);
        	return "redirect:/usuario-add";
        }
        
        Usuario usuario = new Usuario(nombre,apellidos, dni, correoElectronico, codPostalStr, telefonoMovil, fechaNacimiento, password, repetirPassword);
        usuariosRepository.add(usuario);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/detalle_usuario")
    public String detalleUsuario(@RequestParam("nombre") String nombre, 
                                  @RequestParam("apellidos") String apellidos, 
                                  Model model) {
        Usuario usuario = usuariosRepository.findByNombreAndApellidos(nombre, apellidos);

        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "detalle_usuario_view";
        } else {
            return "redirect:/error";
        }
    }

    @GetMapping(value = "/usuario-del")
    public String deleteAction(@RequestParam HashMap<String, String>params, Model model) throws NotFoundException {
        try {
        	String dni = params.get("dni");
        	Usuario usuario = usuariosRepository.get(dni);
        }catch (Exception e) {
			String mensaje = e.getMessage();
		}
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios")
    public String userList(Model model, @RequestParam HashMap<String, String> params) {
        String usuario = params.get("usuario");
        List<Usuario> usuarios;
        if (usuario != null && !usuario.isEmpty()) {
            usuarios = usuariosRepository.findAll();
            model.addAttribute("usuario", usuario);
        } else {
            usuarios = usuariosRepository.findAll();
        }
        model.addAttribute("usuarios", usuarios);
        return "listado_usuarios_view";
    }
}
