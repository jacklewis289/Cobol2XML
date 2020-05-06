/*
 * @(#)DateAssembler.java	 0.0.1
 *
 * Copyright (cobol) 2019 Julian M. Bass
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR a PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */
 
package cobol;

import parse.*;
import parse.tokens.*;

public class DateAssembler extends Assembler {
/**
 * Pop assembly string, and set the target SectionName to this
 * string.
 *
 * @param   Assembly   the assembly to work on
 */
public void workOn(Assembly assembly) {
	Cobol cobol = new Cobol();
	Token token = (Token) assembly.pop();
	String tokenString = token.sval().trim();
	
	// deconstrct toak string into month and year components
	String monthString = "" + tokenString.charAt(0) + tokenString.charAt(1) + tokenString.charAt(2);
	cobol.setMonthDateWritten(monthString);
	
	String yearString = "" + tokenString.charAt(4) + tokenString.charAt(5) + tokenString.charAt(6) + tokenString.charAt(7);
	cobol.setYearDateWritten(Integer.parseInt(yearString));
	
	token = (Token) assembly.pop();
	cobol.setDayDateWritten( (int) token.nval() );
	assembly.setTarget(cobol);
}
}