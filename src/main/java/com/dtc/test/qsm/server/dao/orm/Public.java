/**
 * This class is generated by jOOQ
 */
package com.dtc.test.qsm.server.dao.orm;


import com.dtc.test.qsm.server.dao.orm.tables.Author;
import com.dtc.test.qsm.server.dao.orm.tables.Contacts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1372500237;

    /**
     * The reference instance of <code>PUBLIC</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>PUBLIC.CONTACTS</code>.
     */
    public final Contacts CONTACTS = com.dtc.test.qsm.server.dao.orm.tables.Contacts.CONTACTS;

    /**
     * The table <code>PUBLIC.AUTHOR</code>.
     */
    public final Author AUTHOR = com.dtc.test.qsm.server.dao.orm.tables.Author.AUTHOR;

    /**
     * No further instances allowed
     */
    private Public() {
        super("PUBLIC", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Contacts.CONTACTS,
            Author.AUTHOR);
    }
}