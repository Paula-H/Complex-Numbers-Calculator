package Testing;
import Parser.*;
import Model.*;

import static java.lang.Math.abs;

public class Testing {

    public void test(){
        String[] arguments=new String[3];
        arguments[0]="2+3.1*i";
        arguments[1]="+";
        arguments[2]="3.4+3.567i";
        ExpressionParser parsler=new ExpressionParser(arguments);
//----------------------------------------------------------------------------------------------------------------
        Complex n1=parsler.transformForTrueFloats("3+2*i");
        assert n1.getRe()==3;
        assert n1.getIm()==2;

        n1=parsler.transformForTrueFloats("3.4+2*i");
        assert (abs(n1.getRe()-3.4)<0.00001);
        assert n1.getIm()==2;

        n1=parsler.transformForTrueFloats("3.4+2.4*i");
        assert (abs(n1.getRe()-3.4)<0.00001);
        assert (abs(n1.getIm()-2.4)<0.00001);

        n1=parsler.transformForTrueFloats("3.42+2.43*i");
        assert (abs(n1.getRe()-3.42)<0.00001);
        assert (abs(n1.getIm()-2.43)<0.00001);

        n1=parsler.transformForTrueFloats("-3+2*i");
        assert n1.getRe()==-3;
        assert n1.getIm()==2;

        n1=parsler.transformForTrueFloats("-3.1+2*i");
        assert (abs(n1.getRe()+3.1)<0.00001);
        assert (abs(n1.getIm()-2)<0.00001);

        n1=parsler.transformForTrueFloats("-3.123+2.5123*i");
        assert (abs(n1.getRe()+3.123)<0.00001);
        assert (abs(n1.getIm()-2.5123)<0.00001);

        n1=parsler.transformForTrueFloats("-3-2*i");
        assert n1.getRe()==-3;
        assert n1.getIm()==-2;

        n1=parsler.transformForTrueFloats("-3.4-2*i");
        assert (abs(n1.getRe()+3.4)<0.00001);
        assert (abs(n1.getIm()+2)<0.00001);

        n1=parsler.transformForTrueFloats("-3.435-2.532243*i");
        assert (abs(n1.getRe()+3.435)<0.00001);
        assert (abs(n1.getIm()+2.53224)<0.00001);

        n1=parsler.transformForTrueFloats("-3.12345-2.56789*i");
        assert (abs(n1.getRe()+3.12345)<0.00001);
        assert (abs(n1.getIm()+2.56789)<0.00001);

        n1=parsler.transformForTrueFloats("3-67*i");
        assert n1.getRe()==3;
        assert n1.getIm()==-67;

        n1=parsler.transformForTrueFloats("3.67-67*i");
        assert (abs(n1.getRe()-3.67)<0.00001);
        assert n1.getIm()==-67;

        n1=parsler.transformForTrueFloats("3.67-67.123456*i");
        assert (abs(n1.getRe()-3.67)<0.00001);
        assert (abs(n1.getIm()+67.123456)<0.00001);

        n1=parsler.transformForTrueFloats("3-i");
        assert n1.getRe()==3;
        assert n1.getIm()==-1;

        n1=parsler.transformForTrueFloats("3.91919-i");
        assert (abs(n1.getRe()-3.91919)<0.00001);
        assert n1.getIm()==-1;

        n1=parsler.transformForTrueFloats("39+i");
        assert n1.getRe()==39;
        assert n1.getIm()==1;

        n1=parsler.transformForTrueFloats("39.9012+i");
        assert (abs(n1.getRe()-39.9012)<0.00001);
        assert n1.getIm()==1;

        n1=parsler.transformForTrueFloats("-73+i");
        assert n1.getRe()==-73;
        assert n1.getIm()==1;

        n1=parsler.transformForTrueFloats("-77.34+i");
        assert (abs(n1.getRe()+77.34)<0.00001);
        assert n1.getIm()==1;

        n1=parsler.transformForTrueFloats("-35-i");
        assert n1.getRe()==-35;
        assert n1.getIm()==-1;

        n1=parsler.transformForTrueFloats("-35.67-i");
        assert (abs(n1.getRe()+35.67)<0.00001);
        assert n1.getIm()==-1;

        n1=parsler.transformForTrueFloats("-35");
        assert n1.getRe()==-35;
        assert n1.getIm()==0;

        n1=parsler.transformForTrueFloats("-35.324789");
        assert (abs(n1.getRe()+35.324789)<0.00001);
        assert n1.getIm()==0;

        n1=parsler.transformForTrueFloats("635");
        assert n1.getRe()==635;
        assert n1.getIm()==0;

        n1=parsler.transformForTrueFloats("135.45");
        assert (abs(n1.getRe()-135.45)<0.00001);
        assert n1.getIm()==0;

        n1=parsler.transformForTrueFloats("32*i");
        assert n1.getRe()==0;
        assert n1.getIm()==32;

        n1=parsler.transformForTrueFloats("32.56*i");
        assert n1.getRe()==0;
        assert (abs(n1.getIm()-32.56)<0.01);

        n1=parsler.transformForTrueFloats("-32*i");
        assert n1.getRe()==0;
        assert n1.getIm()==-32;

        n1=parsler.transformForTrueFloats("-32.567*i");
        assert n1.getRe()==0;
        assert (abs(n1.getIm()+32.567)<0.01);

        n1=parsler.transformForTrueFloats("-i");
        assert n1.getRe()==0;
        assert n1.getIm()==-1;

        n1=parsler.transformForTrueFloats("i");
        assert n1.getRe()==0;
        assert n1.getIm()==1;


        assert parsler.validForTrueFloats();


    }
}
