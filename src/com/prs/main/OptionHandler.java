package com.prs.main;



import abstraction.cpar.enumic.ConstraintTypes;
import abstraction.cpar.interfaces.ICmdParser;
import abstraction.cpar.interfaces.IOptioned;
import abstraction.cpar.interfaces.ISubmit;

import java.util.stream.Collectors;


class OptionHandler implements IOptioned {

    private boolean _isMultipleValuesAccepted;
    private String _valueSeparator = " ";

    private String _expression;
    private Class<? extends Object> _dataType;
    private ConstraintTypes _cType;

    private String _meaningfulName;


    public OptionHandler(String _expression, Class<? extends Object> _dataType, ConstraintTypes _cType) {
        this._expression = _expression;
        this._dataType = _dataType;
        this._cType = _cType;
    }


    @Override
    public ICmdParser submit(String giveMeaningfulName) throws Exception {
        _meaningfulName = giveMeaningfulName;

        if(CParser.Utility.getOptions().stream().collect(Collectors.toList()).contains(_expression)){

            throw new Exception("Error:..." + _expression + " option already defined");

        }

        CParser.Utility.addOption(new Option(_isMultipleValuesAccepted,
                _valueSeparator,_expression,_dataType, _cType,_meaningfulName));
        return new CParser();
    }

    @Override
    public ISubmit multipleValues(String valueSeparator) {
        _valueSeparator = valueSeparator;
        _isMultipleValuesAccepted = true;
        return this;
    }

}
