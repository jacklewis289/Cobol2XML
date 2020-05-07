package cobol;

import parse.*;
import parse.tokens.*;

public class VariableAssembler extends Assembler {

    public void workOn(Assembly assembly) {
        Cobol cobol = new Cobol();
        Token token = (Token) assembly.pop();
        cobol.setVariableLength((int) (token.nval()));

        token = (Token) assembly.pop();
        token = (Token) assembly.pop();
        int variableType = (int) token.nval();

        if(variableType == 9)
            cobol.setVariableType("integer");

        token = (Token) assembly.pop();
        token = (Token) assembly.pop();
        cobol.setVariableName(token.sval());
        token = (Token) assembly.pop();

        assembly.setTarget(cobol);
    }

}


