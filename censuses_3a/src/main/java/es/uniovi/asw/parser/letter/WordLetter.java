package es.uniovi.asw.parser.letter;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Jc;
import org.docx4j.wml.JcEnumeration;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.PPr;

import es.uniovi.asw.model.Voter;

/**
 * @author Dario Rodríguez García (@dariorg)
 *
 */
public class WordLetter {
	
	/**
	 * Método que permite generar las cartas (formato Word (docx))a ser enviadas a los usuarios
	 * con los datos personales que les permitan emitir su voto electrónico 
	 * 
	 * @param voter, votante para el que generar la carta
	 * @throws Docx4JException
	 */
	public void generateLetter( Voter voter ) throws Docx4JException{
		WordprocessingMLPackage letter = WordprocessingMLPackage.createPackage();
		letter.getMainDocumentPart().addStyledParagraphOfText("Title", "Datos de censo electoral para voto electrónico");
		letter.getMainDocumentPart()
			.addStyledParagraphOfText("Subtitle", "Estimado " 
					+ voter.getNombre() + " con NIF: " + voter.getNif()
					+ ", a continuación se le comunican los datos que le permitirán emitir su voto de manera electrónica:");
		letter.getMainDocumentPart().addParagraphOfText("USUARIO: " + voter.getEmail()).setPPr(paragraphFormat());
		letter.getMainDocumentPart().addParagraphOfText("CONTRASEÑA: " + voter.getPassword()).setPPr(paragraphFormat());
		letter.getMainDocumentPart().addStyledParagraphOfText("Subtitle", "DATOS DEL CENSO");
		letter.getMainDocumentPart().addParagraphOfText("COLEGIO ELECTORAL: " 
				+ voter.getPollingStationCode()).setPPr(paragraphFormat());
		letter.getMainDocumentPart().addStyledParagraphOfText("Subtitle", 
				"NOTA: Los datos mostrados arriba son personales. Por seguridad no"
				+ " se los comunique a terceras personas");
		letter.save(new java.io.File("src/main/resources/letters/" + voter.getNif() + ".docx"));
	}
	
	public PPr paragraphFormat(){
		ObjectFactory factory = new ObjectFactory();
		PPr p = factory.createPPr();
		Jc justification = factory.createJc();
		justification.setVal(JcEnumeration.CENTER);
		p.setJc(justification);
		return p;
	}

}
