/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app.tables;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.Generated;

import jooq.fancy.filter.app.Indexes;
import jooq.fancy.filter.app.Keys;
import jooq.fancy.filter.app.Public;
import jooq.fancy.filter.app.tables.records.AppUserRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AppUser extends TableImpl<AppUserRecord> {

    private static final long serialVersionUID = 1108896857;

    /**
     * The reference instance of <code>public.app_user</code>
     */
    public static final AppUser APP_USER = new AppUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AppUserRecord> getRecordType() {
        return AppUserRecord.class;
    }

    /**
     * The column <code>public.app_user.id</code>.
     */
    public final TableField<AppUserRecord, UUID> ID = createField("id", org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.app_user.display_name</code>.
     */
    public final TableField<AppUserRecord, String> DISPLAY_NAME = createField("display_name", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.app_user.age</code>.
     */
    public final TableField<AppUserRecord, Short> AGE = createField("age", org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.app_user.job_title</code>.
     */
    public final TableField<AppUserRecord, String> JOB_TITLE = createField("job_title", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.app_user.height_in_cm</code>.
     */
    public final TableField<AppUserRecord, Short> HEIGHT_IN_CM = createField("height_in_cm", org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.app_user.city_id</code>.
     */
    public final TableField<AppUserRecord, UUID> CITY_ID = createField("city_id", org.jooq.impl.SQLDataType.UUID, this, "");

    /**
     * The column <code>public.app_user.main_photo</code>.
     */
    public final TableField<AppUserRecord, String> MAIN_PHOTO = createField("main_photo", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.app_user.compatibility_score</code>.
     */
    public final TableField<AppUserRecord, BigDecimal> COMPATIBILITY_SCORE = createField("compatibility_score", org.jooq.impl.SQLDataType.NUMERIC(4, 3), this, "");

    /**
     * The column <code>public.app_user.contacts_exchanged</code>.
     */
    public final TableField<AppUserRecord, Short> CONTACTS_EXCHANGED = createField("contacts_exchanged", org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.app_user.favourite</code>.
     */
    public final TableField<AppUserRecord, Boolean> FAVOURITE = createField("favourite", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.app_user.religion</code>.
     */
    public final TableField<AppUserRecord, String> RELIGION = createField("religion", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.app_user</code> table reference
     */
    public AppUser() {
        this(DSL.name("app_user"), null);
    }

    /**
     * Create an aliased <code>public.app_user</code> table reference
     */
    public AppUser(String alias) {
        this(DSL.name(alias), APP_USER);
    }

    /**
     * Create an aliased <code>public.app_user</code> table reference
     */
    public AppUser(Name alias) {
        this(alias, APP_USER);
    }

    private AppUser(Name alias, Table<AppUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private AppUser(Name alias, Table<AppUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> AppUser(Table<O> child, ForeignKey<O, AppUserRecord> key) {
        super(child, key, APP_USER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.APP_USER_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AppUserRecord> getPrimaryKey() {
        return Keys.APP_USER_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AppUserRecord>> getKeys() {
        return Arrays.<UniqueKey<AppUserRecord>>asList(Keys.APP_USER_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<AppUserRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AppUserRecord, ?>>asList(Keys.APP_USER__APP_USER_CITY_ID_FKEY);
    }

    public City city() {
        return new City(this, Keys.APP_USER__APP_USER_CITY_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AppUser as(String alias) {
        return new AppUser(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AppUser as(Name alias) {
        return new AppUser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AppUser rename(String name) {
        return new AppUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AppUser rename(Name name) {
        return new AppUser(name, null);
    }
}
