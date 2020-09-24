package com.undec.facturacion.dto;

import com.undec.facturacion.model.Detalle;

import java.util.ArrayList;
import java.util.List;

public class DetalleDTO {
	
	private Integer id;
	private Integer productoId;
	private int cantidad;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public List<DetalleDTO> getDetalleDTOList(List<Detalle> detalleList) {
		List<DetalleDTO> detalleDTOList = new ArrayList<>();
		for (Detalle detalle: detalleList) {
			DetalleDTO detalleDTO = new DetalleDTO();

			detalleDTO.setId(detalle.getId());
			detalleDTO.setProductoId(detalle.getProductoByProductoId().getId());
			detalleDTO.setCantidad(detalle.getCantidad());
			detalleDTOList.add(detalleDTO);
		}
		return detalleDTOList;
	}

	public DetalleDTO getDetalleDTO(Detalle detalle) {
			DetalleDTO detalleDTO = new DetalleDTO();

			detalleDTO.setId(detalle.getId());
			detalleDTO.setProductoId(detalle.getProductoByProductoId().getId());
			detalleDTO.setCantidad(detalle.getCantidad());

		return detalleDTO;
	}
}
