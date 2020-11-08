package com.lbt.designPattern.generic;

public interface GenericIFactory<T,N> {
    T nextObject();
    N nextNumber();
}
