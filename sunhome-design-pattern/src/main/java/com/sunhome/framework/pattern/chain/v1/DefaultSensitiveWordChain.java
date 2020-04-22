package com.sunhome.framework.pattern.chain.v1;

import com.sunhome.framework.util.CommonServiceLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午3:20
 */
public class DefaultSensitiveWordChain implements SensitiveWordChain {


    private final List<SensitiveWordFilter> filters = new ArrayList<SensitiveWordFilter>();

    private int index = -1;

    public DefaultSensitiveWordChain() {
        List<SensitiveWordFilter> candidateFilters = CommonServiceLoader.loadProvider(SensitiveWordFilter.class);
        if (!candidateFilters.isEmpty()) {
            this.filters.addAll(candidateFilters);
        }
    }

    public DefaultSensitiveWordChain(List<? extends SensitiveWordFilter> filters) {
        if (filters != null) {
            this.filters.addAll(filters);
        }
    }

    @Override
    public String filter(String word) {
        SensitiveWordFilter filter = getNext();
        if (filter == null) {
            return word;
        }
        try {
            return filter.doFilter(word, this);
        } finally {

        }
    }

    private SensitiveWordFilter getNext() {
        if (this.index > this.filters.size()) {
            throw new IllegalStateException("index gt filters size ");
        }
        if (this.index == (this.filters.size() - 1)) {
            return null;
        }

        this.index++;
        return this.filters.get(this.index);
    }


}
