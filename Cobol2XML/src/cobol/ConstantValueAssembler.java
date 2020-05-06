package cobol;

import parse.*;
import parse.tokens.*;

public class ConstantValueAssembler extends Assembler {

    public void workOn(Assembly assembly) {
        Cobol cobol = new Cobol();
        Token token = (Token) assembly.pop();
        cobol.setConstantValue( token.nval() );
        //System.out.println("Token string[4]: " + cobol.getConstantValue() );
        token = (Token) assembly.pop();
        //This should be the word "value" so we don't need any action here
        //String tokenString = token.sval();
        //System.out.println("Token string[3]: " + tokenString );
        token = (Token) assembly.pop();
        cobol.setConstantName(token.sval() );
        //System.out.println("Token string[2]: " + cobol.getConstantName() );
        token = (Token) assembly.pop();
        cobol.setLineNumber( (int) Math.round(token.nval()) );
        //System.out.println("Token string[2]: " + cobol.getLineNumber() );
        assembly.setTarget(cobol);
    }
}