package com.prs.test;

import abstraction.cpar.enumic.ConstraintTypes;
import abstraction.cpar.interfaces.IFlag;
import abstraction.cpar.interfaces.IKeyValPair;
import abstraction.cpar.interfaces.IOption;
import com.prs.main.CParser;

import java.util.List;


class Run {

    public static void main(String []args) throws Exception {

        CParser cm = new CParser();
        cm.AddOption("--top",int.class,ConstraintTypes.Optional)
                .submit("TopDisplay")
                .AddFlag("-c")
                .submit("CSVMode")
                .AddKeyValuePair("-std","=",String.class,ConstraintTypes.Optional)
                .submit("stdValue")
                .AddOption("-np",int.class,ConstraintTypes.Optional)
                .submit("Number of Players")
                .parse(args);

        List<IOption> ide = CParser.Utility.getOptions();

        List<IFlag> fld = CParser.Utility.getFlags();

        List<IKeyValPair> kp = CParser.Utility.getKvPairs();

        for(IOption iop : CParser.Utility.getOptions()){

            iop.getValues().forEach(a->System.out.println(iop.get_meaningfulName()+ ": " + a.toString()));
        }

        for(IKeyValPair kvp : kp){

            System.out.println(kvp.get_meaningfulName()+": " + kvp.getValue());
        }

        for (IFlag ff : fld){

            System.out.println(ff.get_meaningfulName() + " :" + ff.getValue());
        }

        for(String nv : CParser.Utility.getNakedValues()){

            System.out.println("naked val: " + nv.toString());
        }


    }


}
