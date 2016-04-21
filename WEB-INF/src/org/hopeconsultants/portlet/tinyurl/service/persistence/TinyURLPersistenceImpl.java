/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package org.hopeconsultants.portlet.tinyurl.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException;
import org.hopeconsultants.portlet.tinyurl.model.TinyURL;
import org.hopeconsultants.portlet.tinyurl.model.impl.TinyURLImpl;
import org.hopeconsultants.portlet.tinyurl.model.impl.TinyURLModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the tiny u r l service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hope Consultants International
 * @see TinyURLPersistence
 * @see TinyURLUtil
 * @generated
 */
public class TinyURLPersistenceImpl extends BasePersistenceImpl<TinyURL>
	implements TinyURLPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TinyURLUtil} to access the tiny u r l persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
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
	 * Returns the tiny u r l where classNameId = &#63; and classPK = &#63; or throws a {@link org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException} if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching tiny u r l
	 * @throws org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException if a matching tiny u r l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL findByC_P(long classNameId, long classPK)
		throws NoSuchTinyURLException, SystemException {
		TinyURL tinyURL = fetchByC_P(classNameId, classPK);

		if (tinyURL == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTinyURLException(msg.toString());
		}

		return tinyURL;
	}

	/**
	 * Returns the tiny u r l where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL fetchByC_P(long classNameId, long classPK)
		throws SystemException {
		return fetchByC_P(classNameId, classPK, true);
	}

	/**
	 * Returns the tiny u r l where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL fetchByC_P(long classNameId, long classPK,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { classNameId, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_P,
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
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_P,
						finderArgs, list);
				}
				else {
					TinyURL tinyURL = list.get(0);

					result = tinyURL;

					cacheResult(tinyURL);

					if ((tinyURL.getClassNameId() != classNameId) ||
							(tinyURL.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_P,
							finderArgs, tinyURL);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_P,
					finderArgs);

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
	 * Removes the tiny u r l where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the tiny u r l that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL removeByC_P(long classNameId, long classPK)
		throws NoSuchTinyURLException, SystemException {
		TinyURL tinyURL = findByC_P(classNameId, classPK);

		return remove(tinyURL);
	}

	/**
	 * Returns the number of tiny u r ls where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the number of matching tiny u r ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_P(long classNameId, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_P;

		Object[] finderArgs = new Object[] { classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

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

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

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
	 * Returns the tiny u r l where code = &#63; or throws a {@link org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching tiny u r l
	 * @throws org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException if a matching tiny u r l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL findBycode(String code)
		throws NoSuchTinyURLException, SystemException {
		TinyURL tinyURL = fetchBycode(code);

		if (tinyURL == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTinyURLException(msg.toString());
		}

		return tinyURL;
	}

	/**
	 * Returns the tiny u r l where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL fetchBycode(String code) throws SystemException {
		return fetchBycode(code, true);
	}

	/**
	 * Returns the tiny u r l where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL fetchBycode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof TinyURL) {
			TinyURL tinyURL = (TinyURL)result;

			if (!Validator.equals(code, tinyURL.getCode())) {
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
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					TinyURL tinyURL = list.get(0);

					result = tinyURL;

					cacheResult(tinyURL);

					if ((tinyURL.getCode() == null) ||
							!tinyURL.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, tinyURL);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs);

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
	 * Removes the tiny u r l where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the tiny u r l that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL removeBycode(String code)
		throws NoSuchTinyURLException, SystemException {
		TinyURL tinyURL = findBycode(code);

		return remove(tinyURL);
	}

	/**
	 * Returns the number of tiny u r ls where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching tiny u r ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

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

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

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
	}

	/**
	 * Caches the tiny u r l in the entity cache if it is enabled.
	 *
	 * @param tinyURL the tiny u r l
	 */
	@Override
	public void cacheResult(TinyURL tinyURL) {
		EntityCacheUtil.putResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLImpl.class, tinyURL.getPrimaryKey(), tinyURL);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_P,
			new Object[] { tinyURL.getClassNameId(), tinyURL.getClassPK() },
			tinyURL);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { tinyURL.getCode() }, tinyURL);

		tinyURL.resetOriginalValues();
	}

	/**
	 * Caches the tiny u r ls in the entity cache if it is enabled.
	 *
	 * @param tinyURLs the tiny u r ls
	 */
	@Override
	public void cacheResult(List<TinyURL> tinyURLs) {
		for (TinyURL tinyURL : tinyURLs) {
			if (EntityCacheUtil.getResult(
						TinyURLModelImpl.ENTITY_CACHE_ENABLED,
						TinyURLImpl.class, tinyURL.getPrimaryKey()) == null) {
				cacheResult(tinyURL);
			}
			else {
				tinyURL.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tiny u r ls.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TinyURLImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TinyURLImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tiny u r l.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TinyURL tinyURL) {
		EntityCacheUtil.removeResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLImpl.class, tinyURL.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(tinyURL);
	}

	@Override
	public void clearCache(List<TinyURL> tinyURLs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TinyURL tinyURL : tinyURLs) {
			EntityCacheUtil.removeResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
				TinyURLImpl.class, tinyURL.getPrimaryKey());

			clearUniqueFindersCache(tinyURL);
		}
	}

	protected void cacheUniqueFindersCache(TinyURL tinyURL) {
		if (tinyURL.isNew()) {
			Object[] args = new Object[] {
					tinyURL.getClassNameId(), tinyURL.getClassPK()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_P, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_P, args, tinyURL);

			args = new Object[] { tinyURL.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args, tinyURL);
		}
		else {
			TinyURLModelImpl tinyURLModelImpl = (TinyURLModelImpl)tinyURL;

			if ((tinyURLModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tinyURL.getClassNameId(), tinyURL.getClassPK()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_P, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_P, args,
					tinyURL);
			}

			if ((tinyURLModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { tinyURL.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					tinyURL);
			}
		}
	}

	protected void clearUniqueFindersCache(TinyURL tinyURL) {
		TinyURLModelImpl tinyURLModelImpl = (TinyURLModelImpl)tinyURL;

		Object[] args = new Object[] {
				tinyURL.getClassNameId(), tinyURL.getClassPK()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_P, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_P, args);

		if ((tinyURLModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_P.getColumnBitmask()) != 0) {
			args = new Object[] {
					tinyURLModelImpl.getOriginalClassNameId(),
					tinyURLModelImpl.getOriginalClassPK()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_P, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_P, args);
		}

		args = new Object[] { tinyURL.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((tinyURLModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { tinyURLModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new tiny u r l with the primary key. Does not add the tiny u r l to the database.
	 *
	 * @param tinyURLId the primary key for the new tiny u r l
	 * @return the new tiny u r l
	 */
	@Override
	public TinyURL create(long tinyURLId) {
		TinyURL tinyURL = new TinyURLImpl();

		tinyURL.setNew(true);
		tinyURL.setPrimaryKey(tinyURLId);

		return tinyURL;
	}

	/**
	 * Removes the tiny u r l with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tinyURLId the primary key of the tiny u r l
	 * @return the tiny u r l that was removed
	 * @throws org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException if a tiny u r l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL remove(long tinyURLId)
		throws NoSuchTinyURLException, SystemException {
		return remove((Serializable)tinyURLId);
	}

	/**
	 * Removes the tiny u r l with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tiny u r l
	 * @return the tiny u r l that was removed
	 * @throws org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException if a tiny u r l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL remove(Serializable primaryKey)
		throws NoSuchTinyURLException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TinyURL tinyURL = (TinyURL)session.get(TinyURLImpl.class, primaryKey);

			if (tinyURL == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
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
	protected TinyURL removeImpl(TinyURL tinyURL) throws SystemException {
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
	public TinyURL updateImpl(
		org.hopeconsultants.portlet.tinyurl.model.TinyURL tinyURL)
		throws SystemException {
		tinyURL = toUnwrappedModel(tinyURL);

		boolean isNew = tinyURL.isNew();

		Session session = null;

		try {
			session = openSession();

			if (tinyURL.isNew()) {
				session.save(tinyURL);

				tinyURL.setNew(false);
			}
			else {
				session.merge(tinyURL);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TinyURLModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
			TinyURLImpl.class, tinyURL.getPrimaryKey(), tinyURL);

		clearUniqueFindersCache(tinyURL);
		cacheUniqueFindersCache(tinyURL);

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
	 * Returns the tiny u r l with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tiny u r l
	 * @return the tiny u r l
	 * @throws org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException if a tiny u r l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTinyURLException, SystemException {
		TinyURL tinyURL = fetchByPrimaryKey(primaryKey);

		if (tinyURL == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTinyURLException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tinyURL;
	}

	/**
	 * Returns the tiny u r l with the primary key or throws a {@link org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException} if it could not be found.
	 *
	 * @param tinyURLId the primary key of the tiny u r l
	 * @return the tiny u r l
	 * @throws org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException if a tiny u r l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL findByPrimaryKey(long tinyURLId)
		throws NoSuchTinyURLException, SystemException {
		return findByPrimaryKey((Serializable)tinyURLId);
	}

	/**
	 * Returns the tiny u r l with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tiny u r l
	 * @return the tiny u r l, or <code>null</code> if a tiny u r l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TinyURL tinyURL = (TinyURL)EntityCacheUtil.getResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
				TinyURLImpl.class, primaryKey);

		if (tinyURL == _nullTinyURL) {
			return null;
		}

		if (tinyURL == null) {
			Session session = null;

			try {
				session = openSession();

				tinyURL = (TinyURL)session.get(TinyURLImpl.class, primaryKey);

				if (tinyURL != null) {
					cacheResult(tinyURL);
				}
				else {
					EntityCacheUtil.putResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
						TinyURLImpl.class, primaryKey, _nullTinyURL);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TinyURLModelImpl.ENTITY_CACHE_ENABLED,
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
	 * Returns the tiny u r l with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tinyURLId the primary key of the tiny u r l
	 * @return the tiny u r l, or <code>null</code> if a tiny u r l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TinyURL fetchByPrimaryKey(long tinyURLId) throws SystemException {
		return fetchByPrimaryKey((Serializable)tinyURLId);
	}

	/**
	 * Returns all the tiny u r ls.
	 *
	 * @return the tiny u r ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TinyURL> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tiny u r ls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.hopeconsultants.portlet.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tiny u r ls
	 * @param end the upper bound of the range of tiny u r ls (not inclusive)
	 * @return the range of tiny u r ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TinyURL> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tiny u r ls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.hopeconsultants.portlet.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tiny u r ls
	 * @param end the upper bound of the range of tiny u r ls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tiny u r ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TinyURL> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<TinyURL> list = (List<TinyURL>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

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

					list = new UnmodifiableList<TinyURL>(list);
				}
				else {
					list = (List<TinyURL>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tiny u r ls from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TinyURL tinyURL : findAll()) {
			remove(tinyURL);
		}
	}

	/**
	 * Returns the number of tiny u r ls.
	 *
	 * @return the number of tiny u r ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TINYURL);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
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
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the tiny u r l persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.hopeconsultants.portlet.tinyurl.model.TinyURL")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TinyURL>> listenersList = new ArrayList<ModelListener<TinyURL>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TinyURL>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TinyURLImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TINYURL = "SELECT tinyURL FROM TinyURL tinyURL";
	private static final String _SQL_SELECT_TINYURL_WHERE = "SELECT tinyURL FROM TinyURL tinyURL WHERE ";
	private static final String _SQL_COUNT_TINYURL = "SELECT COUNT(tinyURL) FROM TinyURL tinyURL";
	private static final String _SQL_COUNT_TINYURL_WHERE = "SELECT COUNT(tinyURL) FROM TinyURL tinyURL WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tinyURL.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TinyURL exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TinyURL exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TinyURLPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code"
			});
	private static TinyURL _nullTinyURL = new TinyURLImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TinyURL> toCacheModel() {
				return _nullTinyURLCacheModel;
			}
		};

	private static CacheModel<TinyURL> _nullTinyURLCacheModel = new CacheModel<TinyURL>() {
			@Override
			public TinyURL toEntityModel() {
				return _nullTinyURL;
			}
		};
}