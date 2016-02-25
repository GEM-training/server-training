package com.gem.nhom1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by vanhop on 2/25/16.
 */

public class Constant {

    private int maxPageSize;

    public Constant(int maxPageSize) {
        this.maxPageSize = maxPageSize;
    }

    public int getMaxPageSize() {
        return maxPageSize;
    }

    public void setMaxPageSize(int maxPageSize) {
        this.maxPageSize = maxPageSize;
    }
}
