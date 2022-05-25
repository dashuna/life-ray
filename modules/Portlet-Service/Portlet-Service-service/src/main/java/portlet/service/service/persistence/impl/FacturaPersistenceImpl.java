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

package portlet.service.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import portlet.service.exception.NoSuchFacturaException;
import portlet.service.model.Factura;
import portlet.service.model.FacturaTable;
import portlet.service.model.impl.FacturaImpl;
import portlet.service.model.impl.FacturaModelImpl;
import portlet.service.service.persistence.FacturaPersistence;
import portlet.service.service.persistence.FacturaUtil;
import portlet.service.service.persistence.impl.constants.miEspacioPersistenceConstants;

/**
 * The persistence implementation for the factura service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FacturaPersistence.class, BasePersistence.class})
public class FacturaPersistenceImpl
	extends BasePersistenceImpl<Factura> implements FacturaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FacturaUtil</code> to access the factura persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FacturaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the facturas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching facturas
	 */
	@Override
	public List<Factura> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facturas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacturaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of facturas
	 * @param end the upper bound of the range of facturas (not inclusive)
	 * @return the range of matching facturas
	 */
	@Override
	public List<Factura> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the facturas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacturaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of facturas
	 * @param end the upper bound of the range of facturas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching facturas
	 */
	@Override
	public List<Factura> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Factura> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the facturas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacturaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of facturas
	 * @param end the upper bound of the range of facturas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching facturas
	 */
	@Override
	public List<Factura> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Factura> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Factura> list = null;

		if (useFinderCache) {
			list = (List<Factura>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Factura factura : list) {
					if (!uuid.equals(factura.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FACTURA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FacturaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Factura>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first factura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching factura
	 * @throws NoSuchFacturaException if a matching factura could not be found
	 */
	@Override
	public Factura findByUuid_First(
			String uuid, OrderByComparator<Factura> orderByComparator)
		throws NoSuchFacturaException {

		Factura factura = fetchByUuid_First(uuid, orderByComparator);

		if (factura != null) {
			return factura;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacturaException(sb.toString());
	}

	/**
	 * Returns the first factura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching factura, or <code>null</code> if a matching factura could not be found
	 */
	@Override
	public Factura fetchByUuid_First(
		String uuid, OrderByComparator<Factura> orderByComparator) {

		List<Factura> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last factura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching factura
	 * @throws NoSuchFacturaException if a matching factura could not be found
	 */
	@Override
	public Factura findByUuid_Last(
			String uuid, OrderByComparator<Factura> orderByComparator)
		throws NoSuchFacturaException {

		Factura factura = fetchByUuid_Last(uuid, orderByComparator);

		if (factura != null) {
			return factura;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacturaException(sb.toString());
	}

	/**
	 * Returns the last factura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching factura, or <code>null</code> if a matching factura could not be found
	 */
	@Override
	public Factura fetchByUuid_Last(
		String uuid, OrderByComparator<Factura> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Factura> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the facturas before and after the current factura in the ordered set where uuid = &#63;.
	 *
	 * @param facturaId the primary key of the current factura
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next factura
	 * @throws NoSuchFacturaException if a factura with the primary key could not be found
	 */
	@Override
	public Factura[] findByUuid_PrevAndNext(
			long facturaId, String uuid,
			OrderByComparator<Factura> orderByComparator)
		throws NoSuchFacturaException {

		uuid = Objects.toString(uuid, "");

		Factura factura = findByPrimaryKey(facturaId);

		Session session = null;

		try {
			session = openSession();

			Factura[] array = new FacturaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, factura, uuid, orderByComparator, true);

			array[1] = factura;

			array[2] = getByUuid_PrevAndNext(
				session, factura, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Factura getByUuid_PrevAndNext(
		Session session, Factura factura, String uuid,
		OrderByComparator<Factura> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FACTURA_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FacturaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(factura)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Factura> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the facturas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Factura factura :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(factura);
		}
	}

	/**
	 * Returns the number of facturas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching facturas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACTURA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "factura.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(factura.uuid IS NULL OR factura.uuid = '')";

	public FacturaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Factura.class);

		setModelImplClass(FacturaImpl.class);
		setModelPKClass(long.class);

		setTable(FacturaTable.INSTANCE);
	}

	/**
	 * Caches the factura in the entity cache if it is enabled.
	 *
	 * @param factura the factura
	 */
	@Override
	public void cacheResult(Factura factura) {
		entityCache.putResult(
			FacturaImpl.class, factura.getPrimaryKey(), factura);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the facturas in the entity cache if it is enabled.
	 *
	 * @param facturas the facturas
	 */
	@Override
	public void cacheResult(List<Factura> facturas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (facturas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Factura factura : facturas) {
			if (entityCache.getResult(
					FacturaImpl.class, factura.getPrimaryKey()) == null) {

				cacheResult(factura);
			}
		}
	}

	/**
	 * Clears the cache for all facturas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FacturaImpl.class);

		finderCache.clearCache(FacturaImpl.class);
	}

	/**
	 * Clears the cache for the factura.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Factura factura) {
		entityCache.removeResult(FacturaImpl.class, factura);
	}

	@Override
	public void clearCache(List<Factura> facturas) {
		for (Factura factura : facturas) {
			entityCache.removeResult(FacturaImpl.class, factura);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FacturaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FacturaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new factura with the primary key. Does not add the factura to the database.
	 *
	 * @param facturaId the primary key for the new factura
	 * @return the new factura
	 */
	@Override
	public Factura create(long facturaId) {
		Factura factura = new FacturaImpl();

		factura.setNew(true);
		factura.setPrimaryKey(facturaId);

		String uuid = PortalUUIDUtil.generate();

		factura.setUuid(uuid);

		return factura;
	}

	/**
	 * Removes the factura with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facturaId the primary key of the factura
	 * @return the factura that was removed
	 * @throws NoSuchFacturaException if a factura with the primary key could not be found
	 */
	@Override
	public Factura remove(long facturaId) throws NoSuchFacturaException {
		return remove((Serializable)facturaId);
	}

	/**
	 * Removes the factura with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the factura
	 * @return the factura that was removed
	 * @throws NoSuchFacturaException if a factura with the primary key could not be found
	 */
	@Override
	public Factura remove(Serializable primaryKey)
		throws NoSuchFacturaException {

		Session session = null;

		try {
			session = openSession();

			Factura factura = (Factura)session.get(
				FacturaImpl.class, primaryKey);

			if (factura == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacturaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(factura);
		}
		catch (NoSuchFacturaException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Factura removeImpl(Factura factura) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factura)) {
				factura = (Factura)session.get(
					FacturaImpl.class, factura.getPrimaryKeyObj());
			}

			if (factura != null) {
				session.delete(factura);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (factura != null) {
			clearCache(factura);
		}

		return factura;
	}

	@Override
	public Factura updateImpl(Factura factura) {
		boolean isNew = factura.isNew();

		if (!(factura instanceof FacturaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(factura.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(factura);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in factura proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Factura implementation " +
					factura.getClass());
		}

		FacturaModelImpl facturaModelImpl = (FacturaModelImpl)factura;

		if (Validator.isNull(factura.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			factura.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(factura);
			}
			else {
				factura = (Factura)session.merge(factura);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(FacturaImpl.class, facturaModelImpl, false, true);

		if (isNew) {
			factura.setNew(false);
		}

		factura.resetOriginalValues();

		return factura;
	}

	/**
	 * Returns the factura with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the factura
	 * @return the factura
	 * @throws NoSuchFacturaException if a factura with the primary key could not be found
	 */
	@Override
	public Factura findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacturaException {

		Factura factura = fetchByPrimaryKey(primaryKey);

		if (factura == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacturaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return factura;
	}

	/**
	 * Returns the factura with the primary key or throws a <code>NoSuchFacturaException</code> if it could not be found.
	 *
	 * @param facturaId the primary key of the factura
	 * @return the factura
	 * @throws NoSuchFacturaException if a factura with the primary key could not be found
	 */
	@Override
	public Factura findByPrimaryKey(long facturaId)
		throws NoSuchFacturaException {

		return findByPrimaryKey((Serializable)facturaId);
	}

	/**
	 * Returns the factura with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facturaId the primary key of the factura
	 * @return the factura, or <code>null</code> if a factura with the primary key could not be found
	 */
	@Override
	public Factura fetchByPrimaryKey(long facturaId) {
		return fetchByPrimaryKey((Serializable)facturaId);
	}

	/**
	 * Returns all the facturas.
	 *
	 * @return the facturas
	 */
	@Override
	public List<Factura> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the facturas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacturaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facturas
	 * @param end the upper bound of the range of facturas (not inclusive)
	 * @return the range of facturas
	 */
	@Override
	public List<Factura> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the facturas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacturaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facturas
	 * @param end the upper bound of the range of facturas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of facturas
	 */
	@Override
	public List<Factura> findAll(
		int start, int end, OrderByComparator<Factura> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the facturas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacturaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of facturas
	 * @param end the upper bound of the range of facturas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of facturas
	 */
	@Override
	public List<Factura> findAll(
		int start, int end, OrderByComparator<Factura> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Factura> list = null;

		if (useFinderCache) {
			list = (List<Factura>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FACTURA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FACTURA;

				sql = sql.concat(FacturaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Factura>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the facturas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Factura factura : findAll()) {
			remove(factura);
		}
	}

	/**
	 * Returns the number of facturas.
	 *
	 * @return the number of facturas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FACTURA);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "facturaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FACTURA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FacturaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the factura persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_setFacturaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFacturaUtilPersistence(null);

		entityCache.removeCache(FacturaImpl.class.getName());
	}

	private void _setFacturaUtilPersistence(
		FacturaPersistence facturaPersistence) {

		try {
			Field field = FacturaUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, facturaPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = miEspacioPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = miEspacioPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = miEspacioPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FACTURA =
		"SELECT factura FROM Factura factura";

	private static final String _SQL_SELECT_FACTURA_WHERE =
		"SELECT factura FROM Factura factura WHERE ";

	private static final String _SQL_COUNT_FACTURA =
		"SELECT COUNT(factura) FROM Factura factura";

	private static final String _SQL_COUNT_FACTURA_WHERE =
		"SELECT COUNT(factura) FROM Factura factura WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "factura.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Factura exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Factura exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FacturaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private FacturaModelArgumentsResolver _facturaModelArgumentsResolver;

}