package org.openspaces.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

public class GigaSpacesCacheManager extends AbstractCacheManager {
    private Collection<Cache> caches;

    @Override
    protected Collection<Cache> loadCaches() {
        return caches;
    }

    public void setCaches(Collection<Cache> caches) {
        this.caches = caches;
    }
}
