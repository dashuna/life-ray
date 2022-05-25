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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;miEspacio_Factura&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Factura
 * @generated
 */
public class FacturaTable extends BaseTable<FacturaTable> {

	public static final FacturaTable INSTANCE = new FacturaTable();

	public final Column<FacturaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FacturaTable, Long> facturaId = createColumn(
		"facturaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FacturaTable, String> numero = createColumn(
		"numero", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FacturaTable, String> cliente = createColumn(
		"cliente", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FacturaTable, String> importe = createColumn(
		"importe", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FacturaTable() {
		super("miEspacio_Factura", FacturaTable::new);
	}

}