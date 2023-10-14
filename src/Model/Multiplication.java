package Model;
import Enum.Operation;

public class Multiplication extends ComplexExpression{


    public Multiplication( Complex[] args) {
        super(Operation.MULTIPLICATION, args);

    }

    @Override
    public Complex executeOneOperation() {
        Complex multiplicatedNums=args[0];
        for(int i=1;i<args.length;i++){
            multiplicatedNums.multiply(args[i]);
        }
        return multiplicatedNums;
    }
}
