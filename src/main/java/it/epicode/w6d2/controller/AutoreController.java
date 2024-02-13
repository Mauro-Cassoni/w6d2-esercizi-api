package it.epicode.w6d2.controller;

import it.epicode.w6d2.model.Autore;
import it.epicode.w6d2.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @GetMapping("")
    public List<Autore> getAll(){
        return autoreService.cercaTuttiAutori();
    }

    @GetMapping("/{id}")
    public Autore getAutoreById(@PathVariable int id){
        return autoreService.cercaAutorePerId(id);
    }

    @PostMapping("")
    public void saveAutore(@RequestBody Autore autore){
        autoreService.salvaAutore(autore);
    }

    @PutMapping("/{id}")
    public void modifyAutore(@PathVariable int id, @RequestBody Autore autore){
        autoreService.aggiornaAutore(id,autore);
    }

    @DeleteMapping("/{id}")
    public void deleteAutore(@PathVariable int id){
        autoreService.eliminaAutore(id);
    }
}
