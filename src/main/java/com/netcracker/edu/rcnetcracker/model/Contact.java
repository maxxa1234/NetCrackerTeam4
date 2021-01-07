package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

@ObjectType(id = 11)
public class Contact extends BaseEntity {

    @Attribute(id = 29, valueType = ValueType.VALUE)
    private String value;

    @Attribute(id = 30, clazz = ContactType.class)
    private ContactType contactType;

    @Attribute(id = 31, clazz = User.class)
    private User user;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ContactType getContactTypeId() {
        return contactType;
    }

    public void setContactTypeId(ContactType contactType) {
        this.contactType = contactType;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User userId) {
        this.user = user;
    }
}
