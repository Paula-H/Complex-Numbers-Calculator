package Model;
import Enum.Operation;
public class DivisionBy extends ComplexExpression{
    public DivisionBy( Complex[] args) {
        super(Operation.DIVISION_BY, args);

    }

    @Override
    public Complex executeOneOperation() {
        Complex addedNums=args[0];
        for(int i=1;i<args.length;i++){
            addedNums.divisionBy(args[i]);
        }
        return addedNums;
    }
}
