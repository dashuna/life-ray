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

package portlet.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import portlet.service.model.Factura;

/**
 * The cache model class for representing Factura in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacturaCacheModel implements CacheModel<Factura>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FacturaCacheModel)) {
			return false;
		}

		FacturaCacheModel facturaCacheModel = (FacturaCacheModel)object;

		if (facturaId == facturaCacheModel.facturaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, facturaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", facturaId=");
		sb.append(facturaId);
		sb.append(", numero=");
		sb.append(numero);
		sb.append(", cliente=");
		sb.append(cliente);
		sb.append(", importe=");
		sb.append(importe);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Factura toEntityModel() {
		FacturaImpl facturaImpl = new FacturaImpl();

		if (uuid == null) {
			facturaImpl.setUuid("");
		}
		else {
			facturaImpl.setUuid(uuid);
		}

		facturaImpl.setFacturaId(facturaId);

		if (numero == null) {
			facturaImpl.setNumero("");
		}
		else {
			facturaImpl.setNumero(numero);
		}

		if (cliente == null) {
			facturaImpl.setCliente("");
		}
		else {
			facturaImpl.setCliente(cliente);
		}

		if (importe == null) {
			facturaImpl.setImporte("");
		}
		else {
			facturaImpl.setImporte(importe);
		}

		facturaImpl.resetOriginalValues();

		return facturaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		facturaId = objectInput.readLong();
		numero = objectInput.readUTF();
		cliente = objectInput.readUTF();
		importe = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(facturaId);

		if (numero == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(numero);
		}

		if (cliente == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cliente);
		}

		if (importe == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(importe);
		}
	}

	public String uuid;
	public long facturaId;
	public String numero;
	public String cliente;
	public String importe;

}