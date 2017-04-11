import java.io.{File, InputStream}
import java.net.URL
import java.nio.charset.StandardCharsets

import org.apache.commons.io.IOUtils._
import org.scalatest.FunSuite

import scala.io.Source
import scala.xml.XML
import scala.xml.pull.XMLEventReader
import org.apache.commons.io.input.BOMInputStream

class XMLParsingTest extends FunSuite {

  def filePath = {
    new File(this.getClass.getClassLoader.getResource("ikea_nl.html").toURI).getPath
  }

  var in: InputStream = null
  try {
    val xmlString = Source.fromURL(new URL("http://www.ikea.com/nl/nl/catalog/categories/departments/eating/18865/")).mkString
    // TODO: Bring data as bytes to guess the charset with commons-io's XmlStreamReader
    in = new BOMInputStream(toInputStream(xmlString, StandardCharsets.UTF_8))
    val source = Source.fromInputStream(in)
//    val xml = new XMLEventReader(source)

    val factory = javax.xml.parsers.SAXParserFactory.newInstance()

    factory.setValidating(false)
    factory.setFeature("http://xml.org/sax/features/validation", false)
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false)
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false)
    factory.setFeature("http://xml.org/sax/features/external-general-entities", false)
    factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false)

    val elem = scala.xml.XML.withSAXParser(factory.newSAXParser).load(in)

    elem.map(x =>{
      x
    })

    //  val xml = XML.loadString(xmlString)
    //
    //  val x = xml.map(x => {
    //    val t = x \"div"\@"productLists"
    //    print(t)
    //  })

  }
}
