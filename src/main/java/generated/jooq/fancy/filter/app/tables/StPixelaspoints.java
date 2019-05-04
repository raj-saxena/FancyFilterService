/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app.tables;


import javax.annotation.Generated;

import jooq.fancy.filter.app.Public;
import jooq.fancy.filter.app.tables.records.StPixelaspointsRecord;

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
public class StPixelaspoints extends TableImpl<StPixelaspointsRecord> {

    private static final long serialVersionUID = 1654995035;

    /**
     * The reference instance of <code>public.st_pixelaspoints</code>
     */
    public static final StPixelaspoints ST_PIXELASPOINTS = new StPixelaspoints();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StPixelaspointsRecord> getRecordType() {
        return StPixelaspointsRecord.class;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<StPixelaspointsRecord, Object> GEOM = createField("geom", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""), this, "");

    /**
     * The column <code>public.st_pixelaspoints.val</code>.
     */
    public final TableField<StPixelaspointsRecord, Double> VAL = createField("val", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>public.st_pixelaspoints.x</code>.
     */
    public final TableField<StPixelaspointsRecord, Integer> X = createField("x", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.st_pixelaspoints.y</code>.
     */
    public final TableField<StPixelaspointsRecord, Integer> Y = createField("y", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>public.st_pixelaspoints</code> table reference
     */
    public StPixelaspoints() {
        this(DSL.name("st_pixelaspoints"), null);
    }

    /**
     * Create an aliased <code>public.st_pixelaspoints</code> table reference
     */
    public StPixelaspoints(String alias) {
        this(DSL.name(alias), ST_PIXELASPOINTS);
    }

    /**
     * Create an aliased <code>public.st_pixelaspoints</code> table reference
     */
    public StPixelaspoints(Name alias) {
        this(alias, ST_PIXELASPOINTS);
    }

    private StPixelaspoints(Name alias, Table<StPixelaspointsRecord> aliased) {
        this(alias, aliased, new Field[3]);
    }

    private StPixelaspoints(Name alias, Table<StPixelaspointsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> StPixelaspoints(Table<O> child, ForeignKey<O, StPixelaspointsRecord> key) {
        super(child, key, ST_PIXELASPOINTS);
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
    public StPixelaspoints as(String alias) {
        return new StPixelaspoints(DSL.name(alias), this, parameters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StPixelaspoints as(Name alias) {
        return new StPixelaspoints(alias, this, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public StPixelaspoints rename(String name) {
        return new StPixelaspoints(DSL.name(name), null, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public StPixelaspoints rename(Name name) {
        return new StPixelaspoints(name, null, parameters);
    }

    /**
     * Call this table-valued function
     */
    public StPixelaspoints call(Object rast, Integer band, Boolean excludeNodataValue) {
        return new StPixelaspoints(DSL.name(getName()), null, new Field[] { 
              DSL.val(rast, org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"raster\""))
            , DSL.val(band, org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.INTEGER)))
            , DSL.val(excludeNodataValue, org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(org.jooq.impl.DSL.field("true", org.jooq.impl.SQLDataType.BOOLEAN)))
        });
    }

    /**
     * Call this table-valued function
     */
    public StPixelaspoints call(Field<Object> rast, Field<Integer> band, Field<Boolean> excludeNodataValue) {
        return new StPixelaspoints(DSL.name(getName()), null, new Field[] { 
              rast
            , band
            , excludeNodataValue
        });
    }
}