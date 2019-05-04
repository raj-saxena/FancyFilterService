/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app.tables;


import javax.annotation.Generated;

import jooq.fancy.filter.app.Public;
import jooq.fancy.filter.app.tables.records.StDumpRecord;

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
public class StDump extends TableImpl<StDumpRecord> {

    private static final long serialVersionUID = -1262737690;

    /**
     * The reference instance of <code>public.st_dump</code>
     */
    public static final StDump ST_DUMP = new StDump();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StDumpRecord> getRecordType() {
        return StDumpRecord.class;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<StDumpRecord, Object> ST_DUMP_ = createField("st_dump", org.jooq.impl.DefaultDataType.getDefaultDataType("\"geometry_dump\""), this, "");

    /**
     * Create a <code>public.st_dump</code> table reference
     */
    public StDump() {
        this(DSL.name("st_dump"), null);
    }

    /**
     * Create an aliased <code>public.st_dump</code> table reference
     */
    public StDump(String alias) {
        this(DSL.name(alias), ST_DUMP);
    }

    /**
     * Create an aliased <code>public.st_dump</code> table reference
     */
    public StDump(Name alias) {
        this(alias, ST_DUMP);
    }

    private StDump(Name alias, Table<StDumpRecord> aliased) {
        this(alias, aliased, new Field[1]);
    }

    private StDump(Name alias, Table<StDumpRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> StDump(Table<O> child, ForeignKey<O, StDumpRecord> key) {
        super(child, key, ST_DUMP);
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
    public StDump as(String alias) {
        return new StDump(DSL.name(alias), this, parameters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StDump as(Name alias) {
        return new StDump(alias, this, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public StDump rename(String name) {
        return new StDump(DSL.name(name), null, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public StDump rename(Name name) {
        return new StDump(name, null, parameters);
    }

    /**
     * Call this table-valued function
     */
    public StDump call(Object __1) {
        return new StDump(DSL.name(getName()), null, new Field[] { 
              DSL.val(__1, org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""))
        });
    }

    /**
     * Call this table-valued function
     */
    public StDump call(Field<Object> __1) {
        return new StDump(DSL.name(getName()), null, new Field[] { 
              __1
        });
    }
}
