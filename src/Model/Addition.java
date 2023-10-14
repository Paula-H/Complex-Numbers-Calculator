package Model;
import Enum.Operation;

public class Addition extends ComplexExpression{

    public Addition( Complex[] args) {
        super(Operation.ADDITION, args);

    }

    @Override
    public Complex executeOneOperation() {
        Complex addedNums=args[0];
        for(int i=1;i<args.length;i++){
            addedNums.add(args[i]);
        }
        return addedNums;
    }
}
