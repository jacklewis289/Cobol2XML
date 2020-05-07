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
//        String variableType = token.sval();
//        System.out.println(variableType);
//        if(variableType.contains("x"))
//        {
//        	cobol.setVariableType("string");
//        }
//        else if(variableType.contains("9"))
//        {
//        	cobol.setVariableType("integer");
//        }
        if(variableType == 9)
            cobol.setVariableType("integer");

        token = (Token) assembly.pop();
        token = (Token) assembly.pop();
        cobol.setVariableName(token.sval());
        token = (Token) assembly.pop();

        //System.out.println("Token string[2]: " + cobol.getLineNumber() );
        assembly.setTarget(cobol);
    }

//	public void workOn(Assembly assembly) {
//        Cobol cobol = new Cobol();
//        Token token = (Token) assembly.pop();
//        token = (Token) assembly.pop();
//        cobol.setVariableName(token.sval());
//        //System.out.println(cobol.getVariableName());
//        //System.out.println("Token string[4]: " + cobol.getConstantValue() );
//        token = (Token) assembly.pop();
//        token = (Token) assembly.pop();
//        //This should be the word "value" so we don't need any action here
//        String longString = token.sval();
//        System.out.println(longString);
//        String variableType = longString.split("\\(")[0];
//        if(variableType == "x")
//        {
//        	cobol.setVariableType("string");
//        }
//        else if(variableType == "9")
//        {
//        	cobol.setVariableType("integer");
//        }
//        String variableLength = longString.split("\\(")[1].split(")")[0];
//        cobol.setVariableLength(Integer.parseInt(variableLength));
//        //System.out.println("Token string[2]: " + cobol.getLineNumber() );
//        assembly.setTarget(cobol);
//    }
}


