package gov.weather;

import gov.weather.NdfdXMLBindingStub;
import gov.weather.NdfdXMLLocator;
import org.junit.Test;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import java.io.StringReader;

import static org.junit.Assert.*;

/**
 * Test Binding
 * Created by peter on 3/2/2017.
 */
public class NdfdXMLBindingStubTest {
    @Test
    public void LatLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        String result = binding.latLonListZipCode("53704");
        String latlon = unmarshall(result);
        assertEquals("Error in conversion ", "43.0798,-89.3875", latlon);
    }

    private String unmarshall(String response) throws Exception {

        JAXBContext context = JAXBContext.newInstance(DwmlType.class);

        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            DwmlType dwml = (DwmlType) unmarshaller.unmarshal(new StringReader(response));
            return dwml.getLatLonList();
        } catch (JAXBException e) { e.printStackTrace(); }
        return null;
    }

}