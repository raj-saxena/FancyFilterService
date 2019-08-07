/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app.tables;


import com.example.fancyFilterService.configs.PostgresPointJooqConverter;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.Generated;

import jooq.fancy.filter.app.Indexes;
import jooq.fancy.filter.app.Keys;
import jooq.fancy.filter.app.Public;
import jooq.fancy.filter.app.tables.records.CityRecord;

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
public class City extends TableImpl<CityRecord> {

    private static final long serialVersionUID = -359461026;

    /**
     * The reference instance of <code>public.city</code>
     */
    public static final City CITY = new City();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CityRecord> getRecordType() {
        return CityRecord.class;
    }

    /**
     * The column <code>public.city.id</code>.
     */
    public final TableField<CityRecord, UUID> ID = createField("id", org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.city.city_name</code>.
     */
    public final TableField<CityRecord, String> CITY_NAME = createField("city_name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.city.coordinates</code>.
     */
    public final TableField<CityRecord, PGpoint> COORDINATES = createField("coordinates", org.jooq.impl.DefaultDataType.getDefaultDataType("\"pg_catalog\".\"point\"").nullable(false), this, "", new PostgresPointJooqConverter());

    /**
     * Create a <code>public.city</code> table reference
     */
    public City() {
        this(DSL.name("city"), null);
    }

    /**
     * Create an aliased <code>public.city</code> table reference
     */
    public City(String alias) {
        this(DSL.name(alias), CITY);
    }

    /**
     * Create an aliased <code>public.city</code> table reference
     */
    public City(Name alias) {
        this(alias, CITY);
    }

    private City(Name alias, Table<CityRecord> aliased) {
        this(alias, aliased, null);
    }

    private City(Name alias, Table<CityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> City(Table<O> child, ForeignKey<O, CityRecord> key) {
        super(child, key, CITY);
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
        return Arrays.<Index>asList(Indexes.CITY_PKEY, Indexes.IDX_CITY_NAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CityRecord> getPrimaryKey() {
        return Keys.CITY_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CityRecord>> getKeys() {
        return Arrays.<UniqueKey<CityRecord>>asList(Keys.CITY_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public City as(String alias) {
        return new City(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public City as(Name alias) {
        return new City(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public City rename(String name) {
        return new City(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public City rename(Name name) {
        return new City(name, null);
    }
}
