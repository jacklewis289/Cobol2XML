package cobol;

import parse.*;
import parse.tokens.*;

public class RemarksValueAssembler extends Assembler {
    /**
     * Pop a string, and set the target Remarks to this
     * string.
     *
     * @param assembly the assembly to work on
     */
    public void workOn(Assembly assembly) {
        Cobol cobol = new Cobol();
        Token token = (Token) assembly.pop();

        if (token.sval() != null) {
            cobol.setRemarks(token.sval().trim() + defaultDelimiter() + assembly.remainder(defaultDelimiter()));
            assembly.setTarget(cobol);
        }
    }

    public String defaultDelimiter() {
        return " ";
    }
}


