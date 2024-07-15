package CreationalPatterns.FactoryMethod.Test1;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName XMLUtil
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/11/1 21:12
 */

public class XMLUtil {

    public static Object getBean() throws IOException, SAXException {
        try {
            DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dfactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("src//main//java//CreationalPatterns//FactoryMethod//Test1//config.xml"));

            NodeList n1 = doc.getElementsByTagName("className");
            Node classNode = n1.item(0).getFirstChild();
            String cName = classNode.getNodeName();

            Class<?> clazz = Class.forName(cName);
            Object obj = clazz.getDeclaredConstructor().newInstance();
            return obj;

        } catch (ParserConfigurationException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
