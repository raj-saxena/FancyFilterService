/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app;


import javax.annotation.Generated;

import jooq.fancy.filter.app.tables.AppUser;
import jooq.fancy.filter.app.tables.City;
import jooq.fancy.filter.app.tables.FlywaySchemaHistory;
import jooq.fancy.filter.app.tables.SpatialRefSys;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index APP_USER_PKEY = Indexes0.APP_USER_PKEY;
    public static final Index CITY_PKEY = Indexes0.CITY_PKEY;
    public static final Index FLYWAY_SCHEMA_HISTORY_PK = Indexes0.FLYWAY_SCHEMA_HISTORY_PK;
    public static final Index FLYWAY_SCHEMA_HISTORY_S_IDX = Indexes0.FLYWAY_SCHEMA_HISTORY_S_IDX;
    public static final Index SPATIAL_REF_SYS_PKEY = Indexes0.SPATIAL_REF_SYS_PKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index APP_USER_PKEY = Internal.createIndex("app_user_pkey", AppUser.APP_USER, new OrderField[] { AppUser.APP_USER.ID }, true);
        public static Index CITY_PKEY = Internal.createIndex("city_pkey", City.CITY, new OrderField[] { City.CITY.ID }, true);
        public static Index FLYWAY_SCHEMA_HISTORY_PK = Internal.createIndex("flyway_schema_history_pk", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
        public static Index FLYWAY_SCHEMA_HISTORY_S_IDX = Internal.createIndex("flyway_schema_history_s_idx", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS }, false);
        public static Index SPATIAL_REF_SYS_PKEY = Internal.createIndex("spatial_ref_sys_pkey", SpatialRefSys.SPATIAL_REF_SYS, new OrderField[] { SpatialRefSys.SPATIAL_REF_SYS.SRID }, true);
    }
}
