/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app.tables.records;


import javax.annotation.Generated;

import jooq.fancy.filter.app.tables.SpatialRefSys;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class SpatialRefSysRecord extends UpdatableRecordImpl<SpatialRefSysRecord> implements Record5<Integer, String, Integer, String, String> {

    private static final long serialVersionUID = -888784822;

    /**
     * Setter for <code>public.spatial_ref_sys.srid</code>.
     */
    public SpatialRefSysRecord setSrid(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.spatial_ref_sys.srid</code>.
     */
    public Integer getSrid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.spatial_ref_sys.auth_name</code>.
     */
    public SpatialRefSysRecord setAuthName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.spatial_ref_sys.auth_name</code>.
     */
    public String getAuthName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.spatial_ref_sys.auth_srid</code>.
     */
    public SpatialRefSysRecord setAuthSrid(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.spatial_ref_sys.auth_srid</code>.
     */
    public Integer getAuthSrid() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.spatial_ref_sys.srtext</code>.
     */
    public SpatialRefSysRecord setSrtext(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.spatial_ref_sys.srtext</code>.
     */
    public String getSrtext() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.spatial_ref_sys.proj4text</code>.
     */
    public SpatialRefSysRecord setProj4text(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.spatial_ref_sys.proj4text</code>.
     */
    public String getProj4text() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, Integer, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, Integer, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return SpatialRefSys.SPATIAL_REF_SYS.SRID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SpatialRefSys.SPATIAL_REF_SYS.AUTH_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return SpatialRefSys.SPATIAL_REF_SYS.AUTH_SRID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return SpatialRefSys.SPATIAL_REF_SYS.SRTEXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return SpatialRefSys.SPATIAL_REF_SYS.PROJ4TEXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getSrid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getAuthName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getAuthSrid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getSrtext();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getProj4text();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getSrid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAuthName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getAuthSrid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getSrtext();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getProj4text();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpatialRefSysRecord value1(Integer value) {
        setSrid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpatialRefSysRecord value2(String value) {
        setAuthName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpatialRefSysRecord value3(Integer value) {
        setAuthSrid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpatialRefSysRecord value4(String value) {
        setSrtext(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpatialRefSysRecord value5(String value) {
        setProj4text(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpatialRefSysRecord values(Integer value1, String value2, Integer value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SpatialRefSysRecord
     */
    public SpatialRefSysRecord() {
        super(SpatialRefSys.SPATIAL_REF_SYS);
    }

    /**
     * Create a detached, initialised SpatialRefSysRecord
     */
    public SpatialRefSysRecord(Integer srid, String authName, Integer authSrid, String srtext, String proj4text) {
        super(SpatialRefSys.SPATIAL_REF_SYS);

        set(0, srid);
        set(1, authName);
        set(2, authSrid);
        set(3, srtext);
        set(4, proj4text);
    }
}
