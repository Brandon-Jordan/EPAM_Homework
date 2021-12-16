package main.ua.university.finalTask.bll.xsdValidation;

import main.ua.university.finalTask.dal.FilePath;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDValidator {

    public static void XSDValidate() {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = FilePath.pathDir + FilePath.countriesFile;
        String schemaName = FilePath.pathDir + FilePath.xsdSchema;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.setErrorHandler(new CountriesErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            System.err.println(fileName + " is not correct or valid");
        }
    }
}