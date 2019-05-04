/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app.tables;


import javax.annotation.Generated;

import jooq.fancy.filter.app.Public;
import jooq.fancy.filter.app.tables.records.StDumpaspolygonsRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
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
public class StDumpaspolygons extends TableImpl<StDumpaspolygonsRecord> {

    private static final long serialVersionUID = 1596210916;

    /**
     * The reference instance of <code>public.st_dumpaspolygons</code>
     */
    public static final StDumpaspolygons ST_DUMPASPOLYGONS = new StDumpaspolygons();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StDumpaspolygonsRecord> getRecordType() {
        return StDumpaspolygonsRecord.class;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<StDumpaspolygonsRecord, Object> ST_DUMPASPOLYGONS_ = createField("st_dumpaspolygons", org.jooq.impl.DefaultDataType.getDefaultDataType("\"geomval\""), this, "");

    /**
     * Create a <code>public.st_dumpaspolygons</code> table reference
     */
    public StDumpaspolygons() {
        this(DSL.name("st_dumpaspolygons"), null);
    }

    /**
     * Create an aliased <code>public.st_dumpaspolygons</code> table reference
     */
    public StDumpaspolygons(String alias) {
        this(DSL.name(alias), ST_DUMPASPOLYGONS);
    }

    /**
     * Create an aliased <code>public.st_dumpaspolygons</code> table reference
     */
    public StDumpaspolygons(Name alias) {
        this(alias, ST_DUMPASPOLYGONS);
    }

    private StDumpaspolygons(Name alias, Table<StDumpaspolygonsRecord> aliased) {
        this(alias, aliased, new Field[3]);
    }

    private StDumpaspolygons(Name alias, Table<StDumpaspolygonsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> StDumpaspolygons(Table<O> child, ForeignKey<O, StDumpaspolygonsRecord> key) {
        super(child, key, ST_DUMPASPOLYGONS);
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
    public StDumpaspolygons as(String alias) {
        return new StDumpaspolygons(DSL.name(alias), this, parameters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StDumpaspolygons as(Name alias) {
        return new StDumpaspolygons(alias, this, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public StDumpaspolygons rename(String name) {
        return new StDumpaspolygons(DSL.name(name), null, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public StDumpaspolygons rename(Name name) {
        return new StDumpaspolygons(name, null, parameters);
    }

    /**
     * Call this table-valued function
     */
    public StDumpaspolygons call(Object rast, Integer band, Boolean excludeNodataValue) {
        return new StDumpaspolygons(DSL.name(getName()), null, new Field[] { 
              DSL.val(rast, org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"raster\""))
            , DSL.val(band, org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.INTEGER)))
            , DSL.val(excludeNodataValue, org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(org.jooq.impl.DSL.field("true", org.jooq.impl.SQLDataType.BOOLEAN)))
        });
    }

    /**
     * Call this table-valued function
     */
    public StDumpaspolygons call(Field<Object> rast, Field<Integer> band, Field<Boolean> excludeNodataValue) {
        return new StDumpaspolygons(DSL.name(getName()), null, new Field[] { 
              rast
            , band
            , excludeNodataValue
        });
    }
}
