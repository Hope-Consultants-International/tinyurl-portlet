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

package org.hopeconsultants.tinyurl.service.persistence.impl;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException;
import org.hopeconsultants.tinyurl.model.TinyURL;
import org.hopeconsultants.tinyurl.model.impl.TinyURLImpl;
import org.hopeconsultants.tinyurl.model.impl.TinyURLModelImpl;
import org.hopeconsultants.tinyurl.service.persistence.TinyURLPersistence;

import aQute.bnd.annotation.ProviderType;

/**
 * The persistence implementation for the tiny url service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hope Consultants International
 * @see TinyURLPersistence
 * @see org.hopeconsultants.tinyurl.service.persistence.TinyURLUtil
 * @generated
 */
@ProviderType
public class TinyURLPersistenceImpl extends BasePersistenceImpl<TinyURL>
	implements TinyURLPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TinyURLUtil} to access the tiny url persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TinyURLImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLModelImpl.FINDER_CACHE_ENABLED, TinyURLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLModelImpl.FINDER_CACHE_ENABLED, TinyURLImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_C_P = new FinderPath(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLModelImpl.FINDER_CACHE_ENABLED, TinyURLImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			TinyURLModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			TinyURLModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_P = new FinderPath(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_P",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the tiny url where classNameId = &#63; and classPK = &#63; or throws a {@link NoSuchTinyURLException} if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching tiny url
	 * @throws NoSuchTinyURLException if a matching tiny url could not be found
	 */
	@Override
	public TinyURL findByC_P(long classNameId, long classPK)
		throws NoSuchTinyURLException {
		TinyURL tinyURL = fetchByC_P(classNameId, classPK);

		if (tinyURL == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTinyURLException(msg.toString());
		}

		return tinyURL;
	}

	/**
	 * Returns the tiny url where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	 */
	@Override
	public TinyURL fetchByC_P(long classNameId, long classPK) {
		return fetchByC_P(classNameId, classPK, true);
	}

	/**
	 * Returns the tiny url where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TinyURL fetchByC_P(long classNameId, long classPK,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { classNameId, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_C_P,
					finderArgs, this);
		}

		if (result instanceof TinyURL) {
			TinyURL tinyURL = (TinyURL)result;

			if ((classNameId != tinyURL.getClassNameId()) ||
					(classPK != tinyURL.getClassPK())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TINYURL_WHERE);

			query.append(_FINDER_COLUMN_C_P_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_P_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				List<TinyURL> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_C_P, finderArgs,
						list);
				}
				else {
					TinyURL tinyURL = list.get(0);

					result = tinyURL;

					cacheResult(tinyURL);

					if ((tinyURL.getClassNameId() != classNameId) ||
							(tinyURL.getClassPK() != classPK)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_C_P,
							finderArgs, tinyURL);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_C_P, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TinyURL)result;
		}
	}

	/**
	 * Removes the tiny url where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the tiny url that was removed
	 */
	@Override
	public TinyURL removeByC_P(long classNameId, long classPK)
		throws NoSuchTinyURLException {
		TinyURL tinyURL = findByC_P(classNameId, classPK);

		return remove(tinyURL);
	}

	/**
	 * Returns the number of tiny urls where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the number of matching tiny urls
	 */
	@Override
	public int countByC_P(long classNameId, long classPK) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_P;

		Object[] finderArgs = new Object[] { classNameId, classPK };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TINYURL_WHERE);

			query.append(_FINDER_COLUMN_C_P_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_P_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_P_CLASSNAMEID_2 = "tinyURL.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_P_CLASSPK_2 = "tinyURL.classPK = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLModelImpl.FINDER_CACHE_ENABLED, TinyURLImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBycode",
			new String[] { String.class.getName() },
			TinyURLModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycode",
			new String[] { String.class.getName() });

	/**
	 * Returns the tiny url where code = &#63; or throws a {@link NoSuchTinyURLException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching tiny url
	 * @throws NoSuchTinyURLException if a matching tiny url could not be found
	 */
	@Override
	public TinyURL findBycode(String code) throws NoSuchTinyURLException {
		TinyURL tinyURL = fetchBycode(code);

		if (tinyURL == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTinyURLException(msg.toString());
		}

		return tinyURL;
	}

	/**
	 * Returns the tiny url where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	 */
	@Override
	public TinyURL fetchBycode(String code) {
		return fetchBycode(code, true);
	}

	/**
	 * Returns the tiny url where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TinyURL fetchBycode(String code, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof TinyURL) {
			TinyURL tinyURL = (TinyURL)result;

			if (!Objects.equals(code, tinyURL.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TINYURL_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				List<TinyURL> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					TinyURL tinyURL = list.get(0);

					result = tinyURL;

					cacheResult(tinyURL);

					if ((tinyURL.getCode() == null) ||
							!tinyURL.getCode().equals(code)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, tinyURL);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_CODE, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TinyURL)result;
		}
	}

	/**
	 * Removes the tiny url where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the tiny url that was removed
	 */
	@Override
	public TinyURL removeBycode(String code) throws NoSuchTinyURLException {
		TinyURL tinyURL = findBycode(code);

		return remove(tinyURL);
	}

	/**
	 * Returns the number of tiny urls where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching tiny urls
	 */
	@Override
	public int countBycode(String code) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TINYURL_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "tinyURL.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "tinyURL.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(tinyURL.code IS NULL OR tinyURL.code = '')";

	public TinyURLPersistenceImpl() {
		setModelClass(TinyURL.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<>();

			dbColumnNames.put("code", "code_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the tiny url in the entity cache if it is enabled.
	 *
	 * @param tinyURL the tiny url
	 */
	@Override
	public void cacheResult(TinyURL tinyURL) {
		entityCache.putResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLImpl.class, tinyURL.getPrimaryKey(), tinyURL);

		finderCache.putResult(FINDER_PATH_FETCH_BY_C_P,
			new Object[] { tinyURL.getClassNameId(), tinyURL.getClassPK() },
			tinyURL);

		finderCache.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { tinyURL.getCode() }, tinyURL);

		tinyURL.resetOriginalValues();
	}

	/**
	 * Caches the tiny urls in the entity cache if it is enabled.
	 *
	 * @param tinyURLs the tiny urls
	 */
	@Override
	public void cacheResult(List<TinyURL> tinyURLs) {
		for (TinyURL tinyURL : tinyURLs) {
			if (entityCache.getResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
						TinyURLImpl.class, tinyURL.getPrimaryKey()) == null) {
				cacheResult(tinyURL);
			}
			else {
				tinyURL.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tiny urls.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TinyURLImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tiny url.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TinyURL tinyURL) {
		entityCache.removeResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLImpl.class, tinyURL.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TinyURLModelImpl)tinyURL, true);
	}

	@Override
	public void clearCache(List<TinyURL> tinyURLs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TinyURL tinyURL : tinyURLs) {
			entityCache.removeResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
				TinyURLImpl.class, tinyURL.getPrimaryKey());

			clearUniqueFindersCache((TinyURLModelImpl)tinyURL, true);
		}
	}

	protected void cacheUniqueFindersCache(TinyURLModelImpl tinyURLModelImpl) {
		Object[] args = new Object[] {
				tinyURLModelImpl.getClassNameId(), tinyURLModelImpl.getClassPK()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_C_P, args, Long.valueOf(1),
			false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_C_P, args, tinyURLModelImpl,
			false);

		args = new Object[] { tinyURLModelImpl.getCode() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_CODE, args, Long.valueOf(1),
			false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_CODE, args,
			tinyURLModelImpl, false);
	}

	protected void clearUniqueFindersCache(TinyURLModelImpl tinyURLModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					tinyURLModelImpl.getClassNameId(),
					tinyURLModelImpl.getClassPK()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_P, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_P, args);
		}

		if ((tinyURLModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_P.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					tinyURLModelImpl.getOriginalClassNameId(),
					tinyURLModelImpl.getOriginalClassPK()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_P, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_P, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { tinyURLModelImpl.getCode() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}

		if ((tinyURLModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { tinyURLModelImpl.getOriginalCode() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new tiny url with the primary key. Does not add the tiny url to the database.
	 *
	 * @param tinyURLId the primary key for the new tiny url
	 * @return the new tiny url
	 */
	@Override
	public TinyURL create(long tinyURLId) {
		TinyURL tinyURL = new TinyURLImpl();

		tinyURL.setNew(true);
		tinyURL.setPrimaryKey(tinyURLId);

		tinyURL.setCompanyId(companyProvider.getCompanyId());

		return tinyURL;
	}

	/**
	 * Removes the tiny url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tinyURLId the primary key of the tiny url
	 * @return the tiny url that was removed
	 * @throws NoSuchTinyURLException if a tiny url with the primary key could not be found
	 */
	@Override
	public TinyURL remove(long tinyURLId) throws NoSuchTinyURLException {
		return remove((Serializable)tinyURLId);
	}

	/**
	 * Removes the tiny url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tiny url
	 * @return the tiny url that was removed
	 * @throws NoSuchTinyURLException if a tiny url with the primary key could not be found
	 */
	@Override
	public TinyURL remove(Serializable primaryKey)
		throws NoSuchTinyURLException {
		Session session = null;

		try {
			session = openSession();

			TinyURL tinyURL = (TinyURL)session.get(TinyURLImpl.class, primaryKey);

			if (tinyURL == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTinyURLException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tinyURL);
		}
		catch (NoSuchTinyURLException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TinyURL removeImpl(TinyURL tinyURL) {
		tinyURL = toUnwrappedModel(tinyURL);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tinyURL)) {
				tinyURL = (TinyURL)session.get(TinyURLImpl.class,
						tinyURL.getPrimaryKeyObj());
			}

			if (tinyURL != null) {
				session.delete(tinyURL);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tinyURL != null) {
			clearCache(tinyURL);
		}

		return tinyURL;
	}

	@Override
	public TinyURL updateImpl(TinyURL tinyURL) {
		tinyURL = toUnwrappedModel(tinyURL);

		boolean isNew = tinyURL.isNew();

		TinyURLModelImpl tinyURLModelImpl = (TinyURLModelImpl)tinyURL;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (tinyURL.getCreateDate() == null)) {
			if (serviceContext == null) {
				tinyURL.setCreateDate(now);
			}
			else {
				tinyURL.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!tinyURLModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				tinyURL.setModifiedDate(now);
			}
			else {
				tinyURL.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (tinyURL.isNew()) {
				session.save(tinyURL);

				tinyURL.setNew(false);
			}
			else {
				tinyURL = (TinyURL)session.merge(tinyURL);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TinyURLModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLImpl.class, tinyURL.getPrimaryKey(), tinyURL, false);

		clearUniqueFindersCache(tinyURLModelImpl, false);
		cacheUniqueFindersCache(tinyURLModelImpl);

		tinyURL.resetOriginalValues();

		return tinyURL;
	}

	protected TinyURL toUnwrappedModel(TinyURL tinyURL) {
		if (tinyURL instanceof TinyURLImpl) {
			return tinyURL;
		}

		TinyURLImpl tinyURLImpl = new TinyURLImpl();

		tinyURLImpl.setNew(tinyURL.isNew());
		tinyURLImpl.setPrimaryKey(tinyURL.getPrimaryKey());

		tinyURLImpl.setTinyURLId(tinyURL.getTinyURLId());
		tinyURLImpl.setGroupId(tinyURL.getGroupId());
		tinyURLImpl.setCompanyId(tinyURL.getCompanyId());
		tinyURLImpl.setUserId(tinyURL.getUserId());
		tinyURLImpl.setUserName(tinyURL.getUserName());
		tinyURLImpl.setCreateDate(tinyURL.getCreateDate());
		tinyURLImpl.setModifiedDate(tinyURL.getModifiedDate());
		tinyURLImpl.setClassNameId(tinyURL.getClassNameId());
		tinyURLImpl.setClassPK(tinyURL.getClassPK());
		tinyURLImpl.setCode(tinyURL.getCode());
		tinyURLImpl.setVisible(tinyURL.isVisible());

		return tinyURLImpl;
	}

	/**
	 * Returns the tiny url with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tiny url
	 * @return the tiny url
	 * @throws NoSuchTinyURLException if a tiny url with the primary key could not be found
	 */
	@Override
	public TinyURL findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTinyURLException {
		TinyURL tinyURL = fetchByPrimaryKey(primaryKey);

		if (tinyURL == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTinyURLException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tinyURL;
	}

	/**
	 * Returns the tiny url with the primary key or throws a {@link NoSuchTinyURLException} if it could not be found.
	 *
	 * @param tinyURLId the primary key of the tiny url
	 * @return the tiny url
	 * @throws NoSuchTinyURLException if a tiny url with the primary key could not be found
	 */
	@Override
	public TinyURL findByPrimaryKey(long tinyURLId)
		throws NoSuchTinyURLException {
		return findByPrimaryKey((Serializable)tinyURLId);
	}

	/**
	 * Returns the tiny url with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tiny url
	 * @return the tiny url, or <code>null</code> if a tiny url with the primary key could not be found
	 */
	@Override
	public TinyURL fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
				TinyURLImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TinyURL tinyURL = (TinyURL)serializable;

		if (tinyURL == null) {
			Session session = null;

			try {
				session = openSession();

				tinyURL = (TinyURL)session.get(TinyURLImpl.class, primaryKey);

				if (tinyURL != null) {
					cacheResult(tinyURL);
				}
				else {
					entityCache.putResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
						TinyURLImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
					TinyURLImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tinyURL;
	}

	/**
	 * Returns the tiny url with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tinyURLId the primary key of the tiny url
	 * @return the tiny url, or <code>null</code> if a tiny url with the primary key could not be found
	 */
	@Override
	public TinyURL fetchByPrimaryKey(long tinyURLId) {
		return fetchByPrimaryKey((Serializable)tinyURLId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Serializable, TinyURL> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TinyURL> map = new HashMap<>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TinyURL tinyURL = fetchByPrimaryKey(primaryKey);

			if (tinyURL != null) {
				map.put(primaryKey, tinyURL);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
					TinyURLImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TinyURL)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TINYURL_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TinyURL tinyURL : (List<TinyURL>)q.list()) {
				map.put(tinyURL.getPrimaryKeyObj(), tinyURL);

				cacheResult(tinyURL);

				uncachedPrimaryKeys.remove(tinyURL.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
					TinyURLImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the tiny urls.
	 *
	 * @return the tiny urls
	 */
	@Override
	public List<TinyURL> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tiny urls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tiny urls
	 * @param end the upper bound of the range of tiny urls (not inclusive)
	 * @return the range of tiny urls
	 */
	@Override
	public List<TinyURL> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tiny urls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tiny urls
	 * @param end the upper bound of the range of tiny urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tiny urls
	 */
	@Override
	public List<TinyURL> findAll(int start, int end,
		OrderByComparator<TinyURL> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tiny urls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tiny urls
	 * @param end the upper bound of the range of tiny urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tiny urls
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TinyURL> findAll(int start, int end,
		OrderByComparator<TinyURL> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TinyURL> list = null;

		if (retrieveFromCache) {
			list = (List<TinyURL>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TINYURL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TINYURL;

				if (pagination) {
					sql = sql.concat(TinyURLModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TinyURL>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TinyURL>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tiny urls from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TinyURL tinyURL : findAll()) {
			remove(tinyURL);
		}
	}

	/**
	 * Returns the number of tiny urls.
	 *
	 * @return the number of tiny urls
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TINYURL);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
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
	protected Map<String, Integer> getTableColumnsMap() {
		return TinyURLModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tiny url persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TinyURLImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TINYURL = "SELECT tinyURL FROM TinyURL tinyURL";
	private static final String _SQL_SELECT_TINYURL_WHERE_PKS_IN = "SELECT tinyURL FROM TinyURL tinyURL WHERE tinyURLId IN (";
	private static final String _SQL_SELECT_TINYURL_WHERE = "SELECT tinyURL FROM TinyURL tinyURL WHERE ";
	private static final String _SQL_COUNT_TINYURL = "SELECT COUNT(tinyURL) FROM TinyURL tinyURL";
	private static final String _SQL_COUNT_TINYURL_WHERE = "SELECT COUNT(tinyURL) FROM TinyURL tinyURL WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tinyURL.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TinyURL exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TinyURL exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TinyURLPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code"
			});
}