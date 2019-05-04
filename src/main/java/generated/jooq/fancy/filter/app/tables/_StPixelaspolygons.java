/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app.tables;


import javax.annotation.Generated;

import jooq.fancy.filter.app.Public;
import jooq.fancy.filter.app.tables.records._StPixelaspolygonsRecord;

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
public class _StPixelaspolygons extends TableImpl<_StPixelaspolygonsRecord> {

    private static final long serialVersionUID = 385036079;

    /**
     * The reference instance of <code>public._st_pixelaspolygons</code>
     */
    public static final _StPixelaspolygons _ST_PIXELASPOLYGONS = new _StPixelaspolygons();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<_StPixelaspolygonsRecord> getRecordType() {
        return _StPixelaspolygonsRecord.class;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<_StPixelaspolygonsRecord, Object> GEOM = createField("geom", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""), this, "");

    /**
     * The column <code>public._st_pixelaspolygons.val</code>.
     */
    public final TableField<_StPixelaspolygonsRecord, Double> VAL = createField("val", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>public._st_pixelaspolygons.x</code>.
     */
    public final TableField<_StPixelaspolygonsRecord, Integer> X = createField("x", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public._st_pixelaspolygons.y</code>.
     */
    public final TableField<_StPixelaspolygonsRecord, Integer> Y = createField("y", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>public._st_pixelaspolygons</code> table reference
     */
    public _StPixelaspolygons() {
        this(DSL.name("_st_pixelaspolygons"), null);
    }

    /**
     * Create an aliased <code>public._st_pixelaspolygons</code> table reference
     */
    public _StPixelaspolygons(String alias) {
        this(DSL.name(alias), _ST_PIXELASPOLYGONS);
    }

    /**
     * Create an aliased <code>public._st_pixelaspolygons</code> table reference
     */
    public _StPixelaspolygons(Name alias) {
        this(alias, _ST_PIXELASPOLYGONS);
    }

    private _StPixelaspolygons(Name alias, Table<_StPixelaspolygonsRecord> aliased) {
        this(alias, aliased, new Field[5]);
    }

    private _StPixelaspolygons(Name alias, Table<_StPixelaspolygonsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> _StPixelaspolygons(Table<O> child, ForeignKey<O, _StPixelaspolygonsRecord> key) {
        super(child, key, _ST_PIXELASPOLYGONS);
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
    public _StPixelaspolygons as(String alias) {
        return new _StPixelaspolygons(DSL.name(alias), this, parameters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public _StPixelaspolygons as(Name alias) {
        return new _StPixelaspolygons(alias, this, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public _StPixelaspolygons rename(String name) {
        return new _StPixelaspolygons(DSL.name(name), null, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public _StPixelaspolygons rename(Name name) {
        return new _StPixelaspolygons(name, null, parameters);
    }

    /**
     * Call this table-valued function
     */
    public _StPixelaspolygons call(Object rast, Integer band, Integer columnx, Integer rowy, Boolean excludeNodataValue) {
        return new _StPixelaspolygons(DSL.name(getName()), null, new Field[] { 
              DSL.val(rast, org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"raster\""))
            , DSL.val(band, org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.INTEGER)))
            , DSL.val(columnx, org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL::integer", org.jooq.impl.SQLDataType.INTEGER)))
            , DSL.val(rowy, org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL::integer", org.jooq.impl.SQLDataType.INTEGER)))
            , DSL.val(excludeNodataValue, org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(org.jooq.impl.DSL.field("true", org.jooq.impl.SQLDataType.BOOLEAN)))
        });
    }

    /**
     * Call this table-valued function
     */
    public _StPixelaspolygons call(Field<Object> rast, Field<Integer> band, Field<Integer> columnx, Field<Integer> rowy, Field<Boolean> excludeNodataValue) {
        return new _StPixelaspolygons(DSL.name(getName()), null, new Field[] { 
              rast
            , band
            , columnx
            , rowy
            , excludeNodataValue
        });
    }
}