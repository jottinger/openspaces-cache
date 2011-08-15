package org.openspaces.cache;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceProperty;

import java.io.Serializable;

@SpaceClass
public class MapEntry implements Serializable {
    Object key;
    Object value;

    public MapEntry() {
    }

    public MapEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @SpaceId(autoGenerate = false)
    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    @SpaceProperty
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
