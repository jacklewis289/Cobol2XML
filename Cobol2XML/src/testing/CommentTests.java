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
    public void testComments() {
        Tokenizer tokenizer = CobolParser.tokenizer();
        Parser parser = CobolParser.start();
        tokenizer.setString("***---  convert from base to decimal system");
        Assembly in = new TokenAssembly(tokenizer);
        Assembly out = parser.bestMatch(in);
        Cobol cobol;
        cobol = (Cobol) out.getTarget();
        assertEquals(cobol.getCommentLine(), "convert from base to decimal system");
    }


}


