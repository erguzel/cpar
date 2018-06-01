package com.erg.cpaar.data;

import com.erg.abst.cpaar.prepare.IOption;

public class Option implements IOption {
    private Class<?> _dataType;
    private String _regex;
    private String _name;
    private boolean _isMandatory;

    public Option( String _regex, Class<?> _dataType, boolean _isMandatory) {
        this._dataType = _dataType;
        this._regex = _regex;
        this._isMandatory = _isMandatory;
    }

    @Override
    public Class<?> getDataType() {
        return _dataType;
    }

    @Override
    public void setDataType(Class<?> type) {
        _dataType = type;
    }

    @Override
    public boolean getIsMandatory() {
        return _isMandatory;
    }

    @Override
    public void setIsMandatory(boolean isMandatory) {
        _isMandatory = isMandatory;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public String getRegex() {
        return _regex;
    }

    @Override
    public void setRegex(String expression) {
        _regex = expression;
    }
}