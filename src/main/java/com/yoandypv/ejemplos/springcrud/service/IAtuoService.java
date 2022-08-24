package com.yoandypv.ejemplos.springcrud.service;

import com.yoandypv.ejemplos.springcrud.entities.Auto;

import java.util.Optional;

public interface IAtuoService {
    //Guardar audto "to create"
     Auto crear(Auto auto);
     //Obtener auto "to read"
    Optional<Auto>obtenerPorId(Long id);
    //Actualizar auto "to update"
    Auto actualizar(Long id, double nuevoPrecio);
    //Eliminar auto "to delete"
    boolean borrar(long id);
}
