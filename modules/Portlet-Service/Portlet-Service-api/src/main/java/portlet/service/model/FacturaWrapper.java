/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package portlet.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Factura}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Factura
 * @generated
 */
public class FacturaWrapper
	extends BaseModelWrapper<Factura>
	implements Factura, ModelWrapper<Factura> {

	public FacturaWrapper(Factura factura) {
		super(factura);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("facturaId", getFacturaId());
		attributes.put("numero", getNumero());
		attributes.put("cliente", getCliente());
		attributes.put("importe", getImporte());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long facturaId = (Long)attributes.get("facturaId");

		if (facturaId != null) {
			setFacturaId(facturaId);
		}

		String numero = (String)attributes.get("numero");

		if (numero != null) {
			setNumero(numero);
		}

		String cliente = (String)attributes.get("cliente");

		if (cliente != null) {
			setCliente(cliente);
		}

		String importe = (String)attributes.get("importe");

		if (importe != null) {
			setImporte(importe);
		}
	}

	@Override
	public Factura cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the cliente of this factura.
	 *
	 * @return the cliente of this factura
	 */
	@Override
	public String getCliente() {
		return model.getCliente();
	}

	/**
	 * Returns the factura ID of this factura.
	 *
	 * @return the factura ID of this factura
	 */
	@Override
	public long getFacturaId() {
		return model.getFacturaId();
	}

	/**
	 * Returns the importe of this factura.
	 *
	 * @return the importe of this factura
	 */
	@Override
	public String getImporte() {
		return model.getImporte();
	}

	/**
	 * Returns the numero of this factura.
	 *
	 * @return the numero of this factura
	 */
	@Override
	public String getNumero() {
		return model.getNumero();
	}

	/**
	 * Returns the primary key of this factura.
	 *
	 * @return the primary key of this factura
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this factura.
	 *
	 * @return the uuid of this factura
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cliente of this factura.
	 *
	 * @param cliente the cliente of this factura
	 */
	@Override
	public void setCliente(String cliente) {
		model.setCliente(cliente);
	}

	/**
	 * Sets the factura ID of this factura.
	 *
	 * @param facturaId the factura ID of this factura
	 */
	@Override
	public void setFacturaId(long facturaId) {
		model.setFacturaId(facturaId);
	}

	/**
	 * Sets the importe of this factura.
	 *
	 * @param importe the importe of this factura
	 */
	@Override
	public void setImporte(String importe) {
		model.setImporte(importe);
	}

	/**
	 * Sets the numero of this factura.
	 *
	 * @param numero the numero of this factura
	 */
	@Override
	public void setNumero(String numero) {
		model.setNumero(numero);
	}

	/**
	 * Sets the primary key of this factura.
	 *
	 * @param primaryKey the primary key of this factura
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this factura.
	 *
	 * @param uuid the uuid of this factura
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected FacturaWrapper wrap(Factura factura) {
		return new FacturaWrapper(factura);
	}

}