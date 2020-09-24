package com.undec.facturacion.controller;

import com.undec.facturacion.dto.FacturaDTO;
import com.undec.facturacion.dto.Response;
import com.undec.facturacion.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping(name = "/guardar")
    public ResponseEntity<Response> save(@RequestBody FacturaDTO facturaDTO) throws Exception{
        Response response = facturaService.save(facturaDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
