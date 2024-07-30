interface Document{
    void type();
}

class WordDocument implements Document{
     @Override
     public void type(){
        System.out.println("Word Document");
    }
}

class PdfDocument implements Document{
    @Override
    public void type(){
        System.out.println("PDF Document");
    }
}

class ExcelDocument implements Document{
    @Override
    public void type(){
        System.out.println("Excel Document");
    }
}


abstract class DocumentFactory{
    abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument(){
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument(){
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument(){
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample{

    public static void main(String[] args) {

        WordDocumentFactory wordFactory = new WordDocumentFactory();
        PdfDocumentFactory pdfFactory = new PdfDocumentFactory();
        ExcelDocumentFactory excelFactory = new ExcelDocumentFactory();

        Document word = wordFactory.createDocument();
        Document pdf = pdfFactory.createDocument();
        Document excel = excelFactory.createDocument();

        word.type();
        pdf.type();
        excel.type();

    }
}

