package Parser;
import Model.*;
import Factory.*;
import Enum.Operation;

public class ExpressionParser {
    private String[] args;


    public ExpressionParser(String[] args){
        this.args=args;
    }

    public boolean validForTrueFloats(){
        for(int i=1;i<args.length;i+=2){
            if(!args[i].equals("+")&&!args[i].equals("-")&&!args[i].equals("*")&&!args[i].equals("/"))
                return false;
        }
        for(int i=0;i<args.length;i+=2){
            if(!args[i].matches("^[-+]?(\\d+\\.?\\d*[-+]{1}){1}\\d*\\.?\\d*\\**i$")&&!args[i].matches("^[-+]?\\d+\\.?\\d*\\*i$")&&!args[i].matches("^[-+]?\\d+\\.?\\d*$"))
                return false;
        }
        return true;

    }

    public Complex transformForTrueFloats(String seq){
        Complex newNum=new Complex(0,0);
        //i'll have more cases when there's a minus in front of the real part;

        //the real part is positive and the imaginary part is greater than 1
        if(seq.matches("^(\\d+\\.?\\d*\\+){1}\\d+\\.?\\d*\\*i$")){
            String[] parts=seq.split("\\+");
            float realPart=Float.parseFloat(parts[0]);
            String[] imaginaryParts=parts[1].split("\\*");
            float imaginaryPart=Float.parseFloat(imaginaryParts[0]);

            newNum.setRe(realPart);
            newNum.setIm(imaginaryPart);
        }

        //the real part is positive and the imaginary part is lower than 0
        else if(seq.matches("^(\\d+\\.?\\d*\\-){1}\\d+\\.?\\d*\\*i$")){
            String[] parts=seq.split("\\-");
            float realPart=Float.parseFloat(parts[0]);
            String[] imaginaryParts=parts[1].split("\\*");
            float imaginaryPart=Float.parseFloat(imaginaryParts[0])*(-1);

            newNum.setRe(realPart);
            newNum.setIm(imaginaryPart);
        }

        //the real part is less than 0, but the imaginary part is greater than 1
        else if(seq.matches("^\\-(\\d+\\.?\\d*\\+){1}\\d+\\.?\\d*\\*i$")){
            String[] elMinus=seq.split("\\-");
            String[] parts=elMinus[1].split("\\+");
            float realPart=Float.parseFloat(parts[0])*(-1);
            String[] imaginaryParts=parts[1].split("\\*");
            float imaginaryPart=Float.parseFloat(imaginaryParts[0]);

            newNum.setRe(realPart);
            newNum.setIm(imaginaryPart);
        }

        //the real part is less than 0 and the imaginary part is less than 0
        else if(seq.matches("^\\-(\\d+\\.?\\d*\\-){1}\\d+\\.?\\d*\\*i$")){
            String[] parts=seq.split("\\-");
            float realPart=Float.parseFloat(parts[1])*(-1);
            String[] imaginaryParts=parts[2].split("\\*");
            float imaginaryPart=Float.parseFloat(imaginaryParts[0])*(-1);

            newNum.setRe(realPart);
            newNum.setIm(imaginaryPart);
        }

        //

        //the real part is positive and the imaginary part is exactly 1
        else if(seq.matches("^(\\d+\\.?\\d*\\+){1}i$")){
            String[] parts=seq.split("\\+");
            float realPart=Float.parseFloat(parts[0]);
            float imaginaryPart=1;

            newNum.setRe(realPart);
            newNum.setIm(imaginaryPart);
        }

        //the real part is negative and the imaginary part is exactly 1
        else if(seq.matches("^\\-(\\d+\\.?\\d*\\+){1}i$")){
            String[] elMinus=seq.split("\\-");
            String[] parts=elMinus[1].split("\\+");
            float realPart=Float.parseFloat(parts[0])*(-1);
            float imaginaryPart=1;

            newNum.setRe(realPart);
            newNum.setIm(imaginaryPart);
        }

        //the real part is positive and the imaginary part is exactly -1
        else if(seq.matches("^(\\d+\\.?\\d*\\-){1}i$")){
            String[] parts=seq.split("\\-");
            float realPart=Float.parseFloat(parts[0]);
            float imaginaryPart=-1;

            newNum.setRe(realPart);
            newNum.setIm(imaginaryPart);
        }

        //the real part is negative and the imaginary part is exactly -1
        else if(seq.matches("^\\-(\\d+\\.?\\d*\\-?){1}i$")){
            String[] parts=seq.split("\\-");
            float realPart=Float.parseFloat(parts[1])*(-1);
            float imaginaryPart=-1;

            newNum.setRe(realPart);
            newNum.setIm(imaginaryPart);
        }


        //the imaginary part is 0
        else if(seq.matches("^[-+]?\\d+\\.?\\d*$")){
            float realPart=Float.parseFloat(seq);
            newNum.setRe(realPart);
        }

        //the real part is 0 but the imaginary part is positive
        else if(seq.matches("^\\d+\\.?\\d*\\*i$")){
            String[] parts=seq.split("\\*");
            float im=Float.parseFloat(parts[0]);
            newNum.setIm(im);

        }
        else if(seq.matches("^\\-\\d+\\.?\\d*\\*i$")){
            String[] elMinus=seq.split("\\-");
            String[] parts=elMinus[1].split("\\*");
            float im=Float.parseFloat(parts[0])*(-1);
            newNum.setIm(im);

        }

        else if(seq.equals("i")){
            newNum.setIm(1);
        }
        else if(seq.equals("-i")){
            newNum.setIm(-1);
        }

        return newNum;
    }


    public Complex resultforTrueFloats(){

        if(!validForTrueFloats())
            return null;

        ExpressionFactory expressionFactory = new Expression();
        Complex resultNum = transformForTrueFloats(args[0]);

        for (int i = 2; i < args.length; i += 2) {
            Complex[] numbers = { resultNum, transformForTrueFloats(args[i]) };

            if (args[i - 1].equals("+")) {
                ComplexExpression expression = expressionFactory.createExpression(Operation.ADDITION, numbers);
                resultNum = expression.execute();
            } else if (args[i - 1].equals("-")) {
                ComplexExpression expression = expressionFactory.createExpression(Operation.SUBSTRACTION, numbers);
                resultNum = expression.execute();
            } else if (args[i - 1].equals("*")){
                ComplexExpression expression = expressionFactory.createExpression(Operation.MULTIPLICATION, numbers);
                resultNum = expression.execute();
            }
            else{
                ComplexExpression expression = expressionFactory.createExpression(Operation.DIVISION_BY, numbers);
                resultNum = expression.execute();
            }
        }

        return resultNum;
    }

}
