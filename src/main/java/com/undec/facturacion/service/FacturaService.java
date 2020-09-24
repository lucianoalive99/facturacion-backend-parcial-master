package com.undec.facturacion.service;

import com.undec.facturacion.dto.DetalleDTO;
import com.undec.facturacion.dto.FacturaDTO;
import com.undec.facturacion.model.Cliente;
import com.undec.facturacion.model.Detalle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.undec.facturacion.dto.Response;
import com.undec.facturacion.model.Factura;
import com.undec.facturacion.repository.*;


/**
 * @author etorrielli
 */
@Service
public class FacturaService {

    static final Logger LOGGER = LoggerFactory.getLogger(FacturaService.class);

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleRepository detalleRepository;

    public Response findAll() throws Exception {
        Response response = new Response();
        try {
            // todo: completar
            List<Detalle> detalleList = detalleRepository.findAll();
            List<DetalleDTO> detalleDTOList = new DetalleDTO().getDetalleDTOList(detalleList);
            response.setData(detalleDTOList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response findOneById(String id) throws Exception {
        int iid = Integer.parseInt(id);
        Response response = new Response();
        try {
            // todo: completar
            Detalle detalle = detalleRepository.findById(iid).get();
            DetalleDTO detalleDTO = new DetalleDTO().getDetalleDTO(detalle);
            response.setData(detalleDTO);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response save(FacturaDTO facturaDTO) throws Exception {
        Response response = new Response();
        try {
            // todo: completar
            Cliente cliente = clienteRepository.findById(facturaDTO.getId()).get();
            List<Detalle> detalleList = detalleRepository.findAll();
            Factura factura = new FacturaDTO().getFactura(facturaDTO,cliente, detalleList);
            factura = facturaRepository.save(factura);
            response.setData(factura.getId());

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    private Factura facturaDTOToEntity(FacturaDTO facturaDTO) throws Exception {
        Factura factura = new Factura();
        // todo: completar
        return factura;
    }

    private Detalle detalleDTOToEntity(Factura factura, DetalleDTO detalleDTO) throws Exception {
        Detalle detalle = new Detalle();
        // todo: completar
        return detalle;
    }

}