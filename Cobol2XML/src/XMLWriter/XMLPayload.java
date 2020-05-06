/*
 * @(#)XMLPayload.java	 0.1.0
 *
 * Copyright (c) 2019 Julian M. Bass
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */

package XMLWriter;

import cobol.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
//import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLPayload {
	Document document;
	Element rootElement;
	
	public XMLPayload() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			document = dBuilder.newDocument();
		 	// root element
        	rootElement = document.createElement("cobol");
        	document.appendChild(rootElement);
		
		 } catch (Exception e) {
	         e.printStackTrace();
	     }
		
	}
	
	
	public void addElements(Cobol cobol) {
		/*
		 * add remarksLine element
		 */
		String remarkLine = cobol.getRemarks();
		if (remarkLine != null) {
			this.addRemarkLineElement( remarkLine );
			//System.out.println("Got Section");
			// Add contents of procedure division
		} else {
			//System.out.println("Comment Line null");
		}

		/*
		 * add commentLine element
		 */
		String commentLine = cobol.getCommentLine();
		if (commentLine != null) {
			this.addCommentLineElement( commentLine );
		//System.out.println("Got Section");
		// Add contents of procedure division
		} else {
		//System.out.println("Comment Line null");
		}

		/*
		 * add constantValue element
		 */
		String constantName = cobol.getConstantName();
		if (constantName != null) {
			this.addConstantValueElement( constantName, cobol.getConstantValue(), cobol.getLineNumber() );
			//System.out.println("Got Section");
			// Add contents of procedure division
		}
		else {
			//System.out.println("Comment Line null");
		}


		/*
		 *  add sectionName element
		 */		
		String sectionName = cobol.getSectionName();
		if (sectionName != null) {
			this.addSectionElement( sectionName );
			//System.out.println("Got Section");
			// Add contents of procedure division
		} else {
			//System.out.println("Section Name null");
		}
		
		/*
		 *  add divisionName element
		 */		
		String divisionName = cobol.getDivisionName();
		if (divisionName != null) {
			this.addDivisionElement( divisionName );
			//System.out.println("Got Section");
			// Add contents of procedure division
		} else {
			//System.out.println("Division Name null");
		}
		
		/*
		 *  add ProgramID element
		 */		
		String programIDName = cobol.getProgram_ID();
		if (programIDName != null) {
			this.addProgram_IDElement( programIDName );
			//System.out.println("Got Section");
			// Add contents of procedure division
		} else {
			//System.out.println("Section Name null");
		}
		
		/*
		 *  add DateWritten element
		 */	
		// DayDateWritten
		int dayDateWritten = cobol.getDayDateWritten();
		if(dayDateWritten != 0) {
			this.addDayDateWrittenElement( dayDateWritten );
		}
		
		//MonthDateWritten
		String monthDateWritten = cobol.getMonthDateWritten();
		if (monthDateWritten != null) {
			this.addMonthDateWrittenElement( monthDateWritten );
			//System.out.println("Got Section");
			// Add contents of procedure division
		} else {
			//System.out.println("Section Name null");
		}

		// YearDateWritten
		int yearDateWritten = cobol.getYearDateWritten();
		if(yearDateWritten != 0) {
			this.addYearDateWrittenElement( yearDateWritten );
		}

	}

	private void addConstantValueElement(String constantName, double constantValue, int lineNumber) {
			// Program ID element
			if(constantName != null) {
				Element cobolname = document.createElement("Constant");
				// insert name of constant into XML file
				Element constID = document.createElement("Constant");
				Attr attrType2 = document.createAttribute("Name" );
				attrType2.setValue( constantName );
				constID.setAttributeNode(attrType2);
				cobolname.appendChild(constID);
				// insert line number of constant into XML file
				Element lineID = document.createElement(constantName);
				Attr attrType = document.createAttribute("Line_Number" );
				attrType.setValue( Integer.toString(lineNumber) );
				lineID.setAttributeNode(attrType);
				cobolname.appendChild(lineID);
				// insert value of constant into XML file
				Element constantID = document.createElement(constantName);
				Attr attrType1 = document.createAttribute("Value" );
				attrType1.setValue( Double.toString(constantValue) );
				constantID.setAttributeNode(attrType1);
				cobolname.appendChild(constantID);
				rootElement.appendChild(cobolname);
			}
		}


	void addProgram_IDElement(String stringElement) {
		//  Program ID element
		
		if(stringElement != null) {
			Element cobolname = document.createElement("Program-ID");
			cobolname.appendChild(document.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
 	
	void addCommentLineElement(String stringElement) {
		//  Comment Line element
		
		if(stringElement != null) {
			Element cobolname = document.createElement("comment");
			cobolname.appendChild(document.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}

	void addRemarkLineElement(String stringElement) {
		//  Comment Line element

		if(stringElement != null) {
			Element cobolname = document.createElement("remarks");
			cobolname.appendChild(document.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
 	
 	void addSectionElement(String stringElement) {
		//  Section element
		
		if(stringElement != null) {
			Element cobolname = document.createElement("section");
			cobolname.appendChild(document.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
 	
 	void addDivisionElement(String stringElement) {
		//  Division element
		if(stringElement != null) {
			Element cobolname = document.createElement("division");
			cobolname.appendChild(document.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
	
	void addDayDateWrittenElement(int intElement) {
		//  DayDateWritten element
		
		if(intElement != 0) {
			Element cobolname = document.createElement("day-date-written");
			String s = "" + intElement;
			cobolname.appendChild(document.createTextNode(s));
			rootElement.appendChild(cobolname);
		}
	}
 	
	void addMonthDateWrittenElement(String stringElement) {
		//  MonthWritten element
		
		if(stringElement != null) {
			Element cobolname = document.createElement("month-date-written");
			cobolname.appendChild(document.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}

	void addYearDateWrittenElement(int intElement) {
		//  YearDateWritten element
		
		if(intElement != 0) {
			Element cobolname = document.createElement("year-date-written");
			String s = "" + intElement;
			cobolname.appendChild(document.createTextNode(s));
			rootElement.appendChild(cobolname);
		}
	}
	
	public void writeFile(String filename) {
		try {
		// write the content into xml file
		// System.out.println("WriteFile Filename: " + filename);
        TransformerFactory transformerFactory =
        TransformerFactory.newInstance();
        Transformer transformer =
        transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        
        StreamResult result =
                new StreamResult(new File(filename));
        transformer.transform(source, result);
        
        // Output to console for testing
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);
        
		 } catch (Exception e) {
	         e.printStackTrace();
	     }
	}

}
