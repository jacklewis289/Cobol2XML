package cobol;

import parse.*;
import parse.tokens.*;

public class RemarksValueAssembler extends Assembler {
    /**
     * Pop a string, and set the target Remarks to this
     * string.
     *
     * @param a the assembly to work on
     */
    public void workOn(Assembly a) {
        Cobol c = new Cobol();
        Token t = (Token) a.pop();

        if (t.sval() != null) {
            c.setRemarks(t.sval().trim() + defaultDelimiter() + a.remainder(defaultDelimiter()));
            a.setTarget(c);
        }
    }

    public String defaultDelimiter() {
        return " ";
    }
}


