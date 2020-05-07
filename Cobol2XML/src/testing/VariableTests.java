package testing;

import cobol.Cobol;
import cobol.CobolParser;
import org.junit.Test;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

import static org.junit.Assert.assertEquals;

public class VariableTests {

    @Test
    public void testVariables() {
        Tokenizer tokenizer = CobolParser.tokenizer();
        Parser parser = CobolParser.start();
        tokenizer.setString("01  w_number                            pic 9(16).");
        Assembly in = new TokenAssembly(tokenizer);
        Assembly out = parser.bestMatch(in);
        Cobol cobol = new Cobol();
        cobol = (Cobol) out.getTarget();
        assertEquals(cobol.getVariableName(), "w_number");
        assertEquals(cobol.getVariableLength(), 16);
    }

}
