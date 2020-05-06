package cobol;

import parse.*;
import parse.tokens.*;
public class CommentLineAssembler extends Assembler {
    /**
     * Pop a string, and set the target DataDivision to this
     * string.
     *
     * @param Assembly the assembly to work on
     */
    public void workOn(Assembly assembly) {
        //System.out.println("commentLineAssembler");
        //System.out.println("Comment Line, remaining text: " + assembly.remainder(" "));
        Cobol cobol = new Cobol();
        Token token = (Token) assembly.pop(); // hopefully the token following the comment

        if (token.sval() != null) {
            cobol.setCommentLine(token.sval().trim() + defaultDelimiter() + assembly.remainder(defaultDelimiter()));
            assembly.setTarget(cobol);
        }
    }

    public String defaultDelimiter() {
        return " ";
    }
}


