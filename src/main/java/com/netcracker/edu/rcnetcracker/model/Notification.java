package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;
import java.util.Date;


@ObjectType(id = 13)
public class Notification extends BaseEntity {

    @Attribute(id = 32, valueType = ValueType.VALUE)
    private String text;

    @Attribute(id = 33, valueType = ValueType.DATE_VALUE)
    private Date date;

    @Attribute(id = 34, valueType = ValueType.VALUE)
    private String title;

    @Attribute(id = 35, clazz = Category.class)
    private Category category;

    @Attribute(id = 36, clazz = User.class)
    private User createdBy;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategoryId() {
        return category;
    }

    public void setCategoryId(Category category) {
        this.category = category;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
