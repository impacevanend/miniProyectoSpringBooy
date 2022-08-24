package com.yoandypv.ejemplos.springcrud.controller;

import com.yoandypv.ejemplos.springcrud.entities.Auto;
import com.yoandypv.ejemplos.springcrud.service.IAtuoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AutoController {

    /**
     * DIFERENTES CÓDIGOS DE ESTADO
     *Created: código de estado 201 (el objeto fue creado).
     * Ok: código de estado 200 (la operación fue satisfactoría).
     * 204: fue satisfactoría pero no se devuelve nada.
     * 400: códigos de error.
     * 500: errores internos del servidor.
     */

    private IAtuoService iAtuoService;

    public AutoController(IAtuoService iAtuoService) {
        this.iAtuoService = iAtuoService;
    }


    @PostMapping("/autos")
    public ResponseEntity<Auto>crearAuto(@RequestBody Auto auto){
        return new ResponseEntity(this.iAtuoService.crear(auto), HttpStatus.CREATED);
        //return ResponseEntity.ok(this.iAtuoService.crear(auto));
    }

    @GetMapping("/autos/{id}")
    public ResponseEntity<Auto>obternerAuto(@PathVariable("id") Long id){
        Optional<Auto> optionalAuto = this.iAtuoService.obtenerPorId(id);
        if(optionalAuto.isPresent())
            return new ResponseEntity(optionalAuto.get(),HttpStatus.OK);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/autos/{id}/nuevoprecio/{precio}")
    public ResponseEntity<Auto>actualizarAuto(@PathVariable("id") Long id, @PathVariable("precio") double precio){
        Auto autoActualizado = this.iAtuoService.actualizar(id, precio);
        if(autoActualizado != null){
            return new ResponseEntity(autoActualizado, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/autos/{id}")
    public ResponseEntity<Void>eliminarAuto(@PathVariable("id") Long id){
        this.iAtuoService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
