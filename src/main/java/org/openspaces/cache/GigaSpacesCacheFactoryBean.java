package org.openspaces.cache;

import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class GigaSpacesCacheFactoryBean implements FactoryBean<GigaSpacesCache>,
        InitializingBean {
    GigaSpace gigaspace;
    String name;
    GigaSpacesCache cache;

    public void setGigaspace(GigaSpace gigaspace) {
        this.gigaspace = gigaspace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GigaSpacesCache getObject() throws Exception {
        return cache;
    }

    public Class<?> getObjectType() {
        return (cache != null ? cache.getClass() : GigaSpacesCache.class);
    }

    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        cache = new GigaSpacesCache(name, gigaspace);
    }
}
