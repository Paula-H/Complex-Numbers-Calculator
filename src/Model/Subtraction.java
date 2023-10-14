package Model;
import Enum.Operation;

public class Subtraction extends ComplexExpression{

    public Subtraction( Complex[] args) {
        super(Operation.SUBSTRACTION, args);
    }

    @Override
    public Complex executeOneOperation() {
        Complex subtractedNums=args[0];
        for(int i=1;i<args.length;i++){
            subtractedNums.subtract(args[i]);
        }
        return subtractedNums;
    }
}

