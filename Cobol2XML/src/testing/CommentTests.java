package testing;

import cobol.Cobol;
import cobol.CobolParser;
import org.junit.Test;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

import static org.junit.Assert.assertEquals;

public class CommentTests {

    @Test
    public void testConstant() {
        Tokenizer t = CobolParser.tokenizer();
        Parser p = CobolParser.start();
        t.setString("***---  convert from base to dicimal system");
        Assembly in = new TokenAssembly(t);
        Assembly out = p.bestMatch(in);
        Cobol c = new Cobol();
        c = (Cobol) out.getTarget();
        assertEquals(c.getCommentLine(), "convert from base to dicimal system");
    }


}
