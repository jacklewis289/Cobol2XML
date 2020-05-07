package testing;

import cobol.Cobol;
import cobol.CobolParser;
import org.junit.Test;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

import static org.junit.Assert.assertEquals;

public class RemarksTests {

    @Test
    public void testComments() {
        Tokenizer tokenizer = CobolParser.tokenizer();
        Parser parser = CobolParser.start();
        tokenizer.setString("remarks. This program convert a value of a generic system base to a numeric value and viceversa .");
        Assembly in = new TokenAssembly(tokenizer);
        Assembly out = parser.bestMatch(in);
        Cobol cobol;
        cobol = (Cobol) out.getTarget();
        assertEquals(cobol.getRemarks(), "This program convert a value of a generic system base to a numeric value and viceversa .");
    }


}


