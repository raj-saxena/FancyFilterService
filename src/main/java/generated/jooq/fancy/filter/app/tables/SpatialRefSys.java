/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jooq.fancy.filter.app.Indexes;
import jooq.fancy.filter.app.Keys;
import jooq.fancy.filter.app.Public;
import jooq.fancy.filter.app.tables.records.SpatialRefSysRecord;

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
public class SpatialRefSys extends TableImpl<SpatialRefSysRecord> {

    private static final long serialVersionUID = -1759460540;

    /**
     * The reference instance of <code>public.spatial_ref_sys</code>
     */
    public static final SpatialRefSys SPATIAL_REF_SYS = new SpatialRefSys();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SpatialRefSysRecord> getRecordType() {
        return SpatialRefSysRecord.class;
    }

    /**
     * The column <code>public.spatial_ref_sys.srid</code>.
     */
    public final TableField<SpatialRefSysRecord, Integer> SRID = createField("srid", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.spatial_ref_sys.auth_name</code>.
     */
    public final TableField<SpatialRefSysRecord, String> AUTH_NAME = createField("auth_name", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>public.spatial_ref_sys.auth_srid</code>.
     */
    public final TableField<SpatialRefSysRecord, Integer> AUTH_SRID = createField("auth_srid", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.spatial_ref_sys.srtext</code>.
     */
    public final TableField<SpatialRefSysRecord, String> SRTEXT = createField("srtext", org.jooq.impl.SQLDataType.VARCHAR(2048), this, "");

    /**
     * The column <code>public.spatial_ref_sys.proj4text</code>.
     */
    public final TableField<SpatialRefSysRecord, String> PROJ4TEXT = createField("proj4text", org.jooq.impl.SQLDataType.VARCHAR(2048), this, "");

    /**
     * Create a <code>public.spatial_ref_sys</code> table reference
     */
    public SpatialRefSys() {
        this(DSL.name("spatial_ref_sys"), null);
    }

    /**
     * Create an aliased <code>public.spatial_ref_sys</code> table reference
     */
    public SpatialRefSys(String alias) {
        this(DSL.name(alias), SPATIAL_REF_SYS);
    }

    /**
     * Create an aliased <code>public.spatial_ref_sys</code> table reference
     */
    public SpatialRefSys(Name alias) {
        this(alias, SPATIAL_REF_SYS);
    }

    private SpatialRefSys(Name alias, Table<SpatialRefSysRecord> aliased) {
        this(alias, aliased, null);
    }

    private SpatialRefSys(Name alias, Table<SpatialRefSysRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SpatialRefSys(Table<O> child, ForeignKey<O, SpatialRefSysRecord> key) {
        super(child, key, SPATIAL_REF_SYS);
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
        return Arrays.<Index>asList(Indexes.SPATIAL_REF_SYS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SpatialRefSysRecord> getPrimaryKey() {
        return Keys.SPATIAL_REF_SYS_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SpatialRefSysRecord>> getKeys() {
        return Arrays.<UniqueKey<SpatialRefSysRecord>>asList(Keys.SPATIAL_REF_SYS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpatialRefSys as(String alias) {
        return new SpatialRefSys(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpatialRefSys as(Name alias) {
        return new SpatialRefSys(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SpatialRefSys rename(String name) {
        return new SpatialRefSys(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SpatialRefSys rename(Name name) {
        return new SpatialRefSys(name, null);
    }
}
