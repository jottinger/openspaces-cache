package org.openspaces.cache;

import org.openspaces.core.GigaSpace;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.DefaultValueWrapper;

public class GigaSpacesCache implements Cache {
    String name;
    GigaSpace map;
    private static final Object NULL_HOLDER = "org.openspaces.cache.GigaSpacesCache.NULL.HOLDER";
    private final boolean allowNullValues;

    public GigaSpacesCache(String name, GigaSpace map) {
        this.name = name;
        this.map = map;
        allowNullValues = false;
    }

    @Override
    public String getName() {
        return name;
    }

    public ValueWrapper get(Object key) {
        MapEntry v = map.readById(MapEntry.class, key);
        return (v != null ? new DefaultValueWrapper(filterNull(v.getValue())) : null);
    }

    public void put(Object key, Object value) {
        if (allowNullValues && value == null) {
            map.write(new MapEntry(key, NULL_HOLDER));
        } else {
            map.write(new MapEntry(key, value));
        }
    }

    public void evict(Object key) {
        map.takeById(MapEntry.class, key);
    }

    @Override
    public Object getNativeCache() {
        return null;
    }

    @Override
    public void clear() {
        map.clear(new MapEntry());
    }

    protected Object filterNull(Object val) {
        if (allowNullValues && val == NULL_HOLDER) {
            return null;
        }
        return val;
    }
}
