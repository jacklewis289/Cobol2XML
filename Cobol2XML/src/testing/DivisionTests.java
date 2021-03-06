package testing;

import cobol.Cobol;
import cobol.CobolParser;
import org.junit.Test;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;
import static org.junit.Assert.assertEquals;

public class DivisionTests {

    @Test
    public void testDivisionId() {
        Tokenizer tokenizer = CobolParser.tokenizer();
        Parser parser = CobolParser.start();
        tokenizer.setString("identification division.");
        Assembly in = new TokenAssembly(tokenizer);
        Assembly out = parser.bestMatch(in);
        Cobol cobol = new Cobol();
        cobol = (Cobol) out.getTarget();
        assertEquals(cobol.getDivisionName(), "identification");
    }


}
