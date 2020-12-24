package com.netcracker.edu.rcnetcracker.servicies.requestBuilder;

import com.netcracker.edu.rcnetcracker.db.annotations.Attr;
import com.netcracker.edu.rcnetcracker.db.annotations.Processor;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

import java.util.List;

/**
 * Этот класс хранит начальный зарос, тут желательно ничего не менять
 * */

public class Request {

    protected List<Attr> attributes;

    StringBuilder selectBlock = new StringBuilder("SELECT * FROM ( SELECT o.object_id \"id\", o.name \"name\", o.description \"description\" ");
    StringBuilder fromBlock = new StringBuilder("FROM OBJECTS o ");
    StringBuilder whereBlock;
    StringBuilder filterBlock = new StringBuilder(") WHERE 1=1");

    public Request(Class clazz) {
        whereBlock = new StringBuilder("WHERE o.object_type_id = " + Processor.getObjtypeId(clazz) + " ");
        attributes = Processor.getAttributes(clazz);

        for (int i = 0; i < attributes.size(); i++) {
            if (attributes.get(i).valueType == ValueType.BASE_VALUE
                    || attributes.get(i).valueType == ValueType.LIST_VALUE) {
                continue;
            }
            selectBlock.append(", a").append(i).append(".").append(attributes.get(i).valueType.getValueType())
                    .append(" \"").append(attributes.get(i).field.getName()).append("\" ");
            fromBlock.append(", ").append(attributes.get(i).valueType.getTable()).append(" a").append(i).append(" ");
            whereBlock.append("AND o.object_id = a").append(i).append(".object_id ").append("AND a")
                    .append(i).append(".attr_id = ").append(attributes.get(i).id).append(" ");

        }
    }

    public StringBuilder getSelectBlock() {
        return selectBlock;
    }

    public void setSelectBlock(StringBuilder selectBlock) {
        this.selectBlock = selectBlock;
    }

    public StringBuilder getFilterBlock() {
        return filterBlock;
    }

    public void setFilterBlock(StringBuilder filterBlock) {
        this.filterBlock = filterBlock;
    }

    /**
     * Возвращает готовую строку запроса
     * */
    @Override
    public String toString() {
        return selectBlock.toString() + fromBlock.toString() + whereBlock.toString() + filterBlock.toString();
    }
}
