package fei.stuba.sk.generate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Import {

    public Document importe(String way) throws JAXBException, FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(way);
        JAXBContext jaxbContext = JAXBContext.newInstance(Document.class); //document from generate
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (Document) jaxbUnmarshaller.unmarshal(inputStream);
    }
}