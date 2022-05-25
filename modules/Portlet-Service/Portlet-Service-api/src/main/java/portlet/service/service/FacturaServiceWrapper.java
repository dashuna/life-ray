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

package portlet.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FacturaService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacturaService
 * @generated
 */
public class FacturaServiceWrapper
	implements FacturaService, ServiceWrapper<FacturaService> {

	public FacturaServiceWrapper() {
		this(null);
	}

	public FacturaServiceWrapper(FacturaService facturaService) {
		_facturaService = facturaService;
	}

	@Override
	public void getFacturasByTerm() {
		_facturaService.getFacturasByTerm();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facturaService.getOSGiServiceIdentifier();
	}

	@Override
	public FacturaService getWrappedService() {
		return _facturaService;
	}

	@Override
	public void setWrappedService(FacturaService facturaService) {
		_facturaService = facturaService;
	}

	private FacturaService _facturaService;

}