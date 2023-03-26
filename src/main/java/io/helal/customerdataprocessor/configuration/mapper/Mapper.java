package io.helal.customerdataprocessor.configuration.mapper;

@FunctionalInterface
public interface Mapper<S, T> {
    T map(S source);
}
