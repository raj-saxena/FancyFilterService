/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app.tables.records;


import javax.annotation.Generated;

import jooq.fancy.filter.app.tables.StPixelaspoints;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;


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
public class StPixelaspointsRecord extends TableRecordImpl<StPixelaspointsRecord> implements Record4<Object, Double, Integer, Integer> {

    private static final long serialVersionUID = -2145863684;

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public StPixelaspointsRecord setGeom(Object value) {
        set(0, value);
        return this;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public Object getGeom() {
        return get(0);
    }

    /**
     * Setter for <code>public.st_pixelaspoints.val</code>.
     */
    public StPixelaspointsRecord setVal(Double value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.st_pixelaspoints.val</code>.
     */
    public Double getVal() {
        return (Double) get(1);
    }

    /**
     * Setter for <code>public.st_pixelaspoints.x</code>.
     */
    public StPixelaspointsRecord setX(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.st_pixelaspoints.x</code>.
     */
    public Integer getX() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.st_pixelaspoints.y</code>.
     */
    public StPixelaspointsRecord setY(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.st_pixelaspoints.y</code>.
     */
    public Integer getY() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Object, Double, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Object, Double, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public Field<Object> field1() {
        return StPixelaspoints.ST_PIXELASPOINTS.GEOM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field2() {
        return StPixelaspoints.ST_PIXELASPOINTS.VAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return StPixelaspoints.ST_PIXELASPOINTS.X;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return StPixelaspoints.ST_PIXELASPOINTS.Y;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public Object component1() {
        return getGeom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component2() {
        return getVal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getX();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getY();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public Object value1() {
        return getGeom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value2() {
        return getVal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getX();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getY();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public StPixelaspointsRecord value1(Object value) {
        setGeom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StPixelaspointsRecord value2(Double value) {
        setVal(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StPixelaspointsRecord value3(Integer value) {
        setX(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StPixelaspointsRecord value4(Integer value) {
        setY(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StPixelaspointsRecord values(Object value1, Double value2, Integer value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StPixelaspointsRecord
     */
    public StPixelaspointsRecord() {
        super(StPixelaspoints.ST_PIXELASPOINTS);
    }

    /**
     * Create a detached, initialised StPixelaspointsRecord
     */
    public StPixelaspointsRecord(Object geom, Double val, Integer x, Integer y) {
        super(StPixelaspoints.ST_PIXELASPOINTS);

        set(0, geom);
        set(1, val);
        set(2, x);
        set(3, y);
    }
}
