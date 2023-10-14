package Model;

import Enum.Operation;

public abstract class ComplexExpression {
    private Operation operation;
    protected Complex[] args;

    public abstract Complex executeOneOperation();

    public ComplexExpression(Operation operation, Complex[] args){
        this.operation=operation;
        this.args=args;
    }

    public final Complex execute(){
        return executeOneOperation();
    }



}
