package com.apirest.app.pdi.Controller;

import com.apirest.app.pdi.Model.Genero;
import com.apirest.app.pdi.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;
    @GetMapping
    public String holaMundo(){
        return "Hola Mundo";
    }

    @GetMapping(value= "/generos")
    public List<Genero> getGenero(){
        return todoRepository.findAll();
    }

    @PostMapping(value="/savegenero")
    public String saveGenero(@RequestBody Genero genero){
        todoRepository.save(genero);
        return "Se guardo tu Genero";
    }

    @PutMapping(value="/update/{id}")
    public String updateGenero(@PathVariable long id, @RequestBody Genero genero){
        Genero updateGenero = todoRepository.findById(id).get();
        updateGenero.setNombre(genero.getNombre());
        updateGenero.setDescripcion(genero.getDescripcion());
        todoRepository.save(updateGenero);
        return "Se actualizo tu Genero";
    }

    @DeleteMapping(value="delete/{id}")
    public String deleteGenero(@PathVariable long id){
        Genero deleteGenero = todoRepository.findById(id).get();
        todoRepository.delete(deleteGenero);
        return "Se elimino tu Genero";
    }
}
