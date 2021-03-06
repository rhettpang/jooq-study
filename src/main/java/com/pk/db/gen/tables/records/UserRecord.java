/*
 * This file is generated by jOOQ.
*/
package com.pk.db.gen.tables.records;


import com.pk.db.gen.tables.User;

import java.time.LocalDateTime;

import javax.annotation.Generated;

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
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record5<Long, String, String, Byte, LocalDateTime> {

    private static final long serialVersionUID = 1325005609;

    /**
     * Setter for <code>jooqdb.user.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>jooqdb.user.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>jooqdb.user.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>jooqdb.user.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>jooqdb.user.password</code>.
     */
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>jooqdb.user.password</code>.
     */
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>jooqdb.user.sex</code>.
     */
    public void setSex(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>jooqdb.user.sex</code>.
     */
    public Byte getSex() {
        return (Byte) get(3);
    }

    /**
     * Setter for <code>jooqdb.user.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>jooqdb.user.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Long, String, String, Byte, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Long, String, String, Byte, LocalDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return User.USER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return User.USER.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return User.USER.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return User.USER.SEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field5() {
        return User.USER.CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component4() {
        return getSex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component5() {
        return getCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getSex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value5() {
        return getCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value3(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value4(Byte value) {
        setSex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value5(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord values(Long value1, String value2, String value3, Byte value4, LocalDateTime value5) {
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
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Long id, String name, String password, Byte sex, LocalDateTime created) {
        super(User.USER);

        set(0, id);
        set(1, name);
        set(2, password);
        set(3, sex);
        set(4, created);
    }
}
