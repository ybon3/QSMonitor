/**
 * This class is generated by jOOQ
 */
package com.dtc.test.qsm.server.dao.orm;


import com.dtc.test.qsm.server.dao.orm.tables.Author;
import com.dtc.test.qsm.server.dao.orm.tables.Contacts;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in PUBLIC
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>PUBLIC.CONTACTS</code>.
     */
    public static final Contacts CONTACTS = com.dtc.test.qsm.server.dao.orm.tables.Contacts.CONTACTS;

    /**
     * The table <code>PUBLIC.AUTHOR</code>.
     */
    public static final Author AUTHOR = com.dtc.test.qsm.server.dao.orm.tables.Author.AUTHOR;
}