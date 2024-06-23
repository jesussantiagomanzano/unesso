package com.example.unesso.controller;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatGrupo;
import com.example.unesso.model.CatSemestre;
import com.example.unesso.model.Usuario;
import com.example.unesso.services.AlumnoService;
import com.example.unesso.services.CatCarreraService;
import com.example.unesso.services.CatGrupoService;
import com.example.unesso.services.CatSemestreService;
import com.example.unesso.services.UsuarioService;
import com.example.unesso.services.db.AlumnoServiceJPA;
import com.example.unesso.services.db.CatGrupoServiceJPA;
import com.example.unesso.services.db.CatSemestreServiceJPA;
import com.example.unesso.services.db.UsuarioServiceJPA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CatCarreraService catCarreraService;

    @Autowired
    private CatSemestreService semestreService;

    @Autowired
    private CatGrupoService grupoService;


    @GetMapping("/menuAdministrador")
    public String menuAdministrador() {
        return "/menuAdministrador";
    }

    @GetMapping("/estudiosSocieconomicos")
    public String todasLasSolicitudes(){
        return "/todasSolicitudes";
    }
    @GetMapping("/solicitudesRevisadas")
    public String solicitudesRevisadas(){
        return "/solicitudesRevisadas";
    }
    @GetMapping("/alumnos")
    public String alumnos(Model model){
        model.addAttribute("listaAlumnos", alumnoService.alumnos());
        return "/administrarAlumno";
    }

    @GetMapping("/fechas")
    public String fechas(){
        return "/administrarFecha";
    }

    @GetMapping("/agregarAlumno")
    public String agregarAlumno(Model model){        
        model.addAttribute("carreras", catCarreraService.listaCarreras());
        model.addAttribute("semestres", semestreService.findAll());
        model.addAttribute("alumno", new Alumno());
        return "formAgregarAlumno";
    }

    @PostMapping("/guardarAlumno")
    public String guardarAlumno(Alumno alumno) {
        String usuarioCorreo = alumno.getUsuario().getCorreo();
        Usuario usuario = usuarioService.findByCorreo(usuarioCorreo);
        if (usuario != null) {
            //alumno.setCatGrupo(grupoService.findByName(alumno.getCatGrupo().getNombreGrupo()));
            alumno.setUsuario(usuario);
            alumnoService.saveAlumno(alumno);
            return "redirect:/administrador/alumnos"; // Redirige a la lista de alumnos después de guardar
        }else{
            return "error"; // Redirige a la lista de alumnos después de guardar
        }

    }

    @GetMapping("/eliminar/{idAlumno}")
    public String eliminarAlumno(@PathVariable Integer idAlumno){
        alumnoService.eliminarAlumno( idAlumno);
        return "redirect:/administrador/alumnos";
    }

    @GetMapping("/editar/{idAlumno}")
    public String editarAlumno(@PathVariable Integer idAlumno, Model model){
        Alumno alumno = alumnoService.findById( idAlumno);
        
        model.addAttribute("carreras", catCarreraService.listaCarreras());
        model.addAttribute("semestres", semestreService.findAll());
        model.addAttribute("alumno", alumno);
        return "/formAgregarAlumno";
    }

    @PostMapping("/paso1")
    public String editarPaso1(Alumno alumno, Model model){

        alumnoService.guardarPaso1(alumno);
        model.addAttribute("alumno", alumnoService.findById(alumno.getIdAlumno()) );

        return "editar-paso2";
    }


    @GetMapping("/getGroup/{idCarrera}/{idSemestre}")
    @ResponseBody
    public CatGrupo getGroup(@PathVariable Integer idCarrera, @PathVariable Integer idSemestre){
        return grupoService.findByIdCarreraIdSemestre(idCarrera, idSemestre);

    }
   

}
