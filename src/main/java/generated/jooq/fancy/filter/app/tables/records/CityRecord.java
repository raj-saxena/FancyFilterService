/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app.tables.records;


import java.util.UUID;

import javax.annotation.Generated;

import jooq.fancy.filter.app.tables.City;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;
import org.postgresql.geometric.PGpoint;


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
public class CityRecord extends UpdatableRecordImpl<CityRecord> implements Record3<UUID, String, PGpoint> {

    private static final long serialVersionUID = 1098482915;

    /**
     * Setter for <code>public.city.id</code>.
     */
    public CityRecord setId(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.city.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.city.city_name</code>.
     */
    public CityRecord setCityName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.city.city_name</code>.
     */
    public String getCityName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.city.coordinates</code>.
     */
    public CityRecord setCoordinates(PGpoint value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.city.coordinates</code>.
     */
    public PGpoint getCoordinates() {
        return (PGpoint) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<UUID, String, PGpoint> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<UUID, String, PGpoint> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UUID> field1() {
        return City.CITY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return City.CITY.CITY_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<PGpoint> field3() {
        return City.CITY.COORDINATES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UUID component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getCityName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PGpoint component3() {
        return getCoordinates();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UUID value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getCityName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PGpoint value3() {
        return getCoordinates();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CityRecord value1(UUID value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CityRecord value2(String value) {
        setCityName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CityRecord value3(PGpoint value) {
        setCoordinates(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CityRecord values(UUID value1, String value2, PGpoint value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CityRecord
     */
    public CityRecord() {
        super(City.CITY);
    }

    /**
     * Create a detached, initialised CityRecord
     */
    public CityRecord(UUID id, String cityName, PGpoint coordinates) {
        super(City.CITY);

        set(0, id);
        set(1, cityName);
        set(2, coordinates);
    }
}
