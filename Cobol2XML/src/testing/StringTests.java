package testing;

import cobol.Cobol;
import cobol.CobolParser;
import org.junit.Test;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

import static org.junit.Assert.assertEquals;

public class StringTests {

    @Test
    public void testStrings() {
        Tokenizer tokenizer = CobolParser.tokenizer();
        Parser parser = CobolParser.start();
        tokenizer.setString("01  hex_dec_data                        pic x(48) value 000101202303404505606707808909A10B11C12D13E14F15.");
        Assembly in = new TokenAssembly(tokenizer);
        Assembly out = parser.bestMatch(in);
        Cobol cobol = new Cobol();
        cobol = (Cobol) out.getTarget();
        assertEquals(cobol.getStringName(), "hex_dec_data");
        assertEquals(cobol.getStringLength(), 48);
    }

}
