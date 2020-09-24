package com.undec.facturacion.dto;

import com.undec.facturacion.model.Cliente;
import com.undec.facturacion.model.Detalle;
import com.undec.facturacion.model.Factura;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class FacturaDTO {
	
	private Integer id;
	private Integer clienteId;
	private int folio;
    private String descripcion;
    private String observacion;
    private List<DetalleDTO> detalles;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public List<DetalleDTO> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleDTO> detalles) {
		this.detalles = detalles;
	}


	public Factura getFactura(FacturaDTO facturaDTO, Cliente cliente, List<Detalle> detalle) {
		Factura factura = new Factura();

		factura.setId(facturaDTO.getId());
		factura.setClienteByClienteId(cliente);
		factura.setDetallesById(detalle);
		factura.setDescripcion(facturaDTO.getDescripcion());
		factura.setFolio(facturaDTO.getFolio());
		factura.setObservacion(facturaDTO.getObservacion());

		return factura;

	}
}
