package cobol;

import parse.*;
import parse.tokens.*;

public class StringAssembler extends Assembler {

    public void workOn(Assembly assembly) {
        Cobol cobol = new Cobol();
        Token token = (Token) assembly.pop();
        cobol.setStringLength((int) (token.nval()));

        token = (Token) assembly.pop();

        token = (Token) assembly.pop();
        String variableType = token.sval();
        if(variableType.contains("x"))
            cobol.setStringType("string");

        token = (Token) assembly.pop();

        token = (Token) assembly.pop();
        cobol.setStringName(token.sval());
        token = (Token) assembly.pop();

        assembly.setTarget(cobol);
    }
}
