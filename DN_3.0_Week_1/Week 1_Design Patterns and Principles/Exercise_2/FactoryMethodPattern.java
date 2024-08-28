public class FactoryMethodPattern {

    // Document interface
    public interface Document {
        void open();
        void save();
        void close();
    }

    // Concrete Document classes
    public static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Word document...");
        }

        @Override
        public void save() {
            System.out.println("Saving Word document...");
        }

        @Override
        public void close() {
            System.out.println("Closing Word document...");
        }
    }

    public static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening PDF document...");
        }

        @Override
        public void save() {
            System.out.println("Saving PDF document...");
        }

        @Override
        public void close() {
            System.out.println("Closing PDF document...");
        }
    }

    public static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Excel document...");
        }

        @Override
        public void save() {
            System.out.println("Saving Excel document...");
        }

        @Override
        public void close() {
            System.out.println("Closing Excel document...");
        }
    }

    // DocumentFactory abstract class
    public static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    // Concrete Factory classes
    public static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    public static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    public static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Main method to demonstrate the Factory Method Pattern
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDocument = wordFactory.createDocument();
        wordDocument.open();
        wordDocument.save();
        wordDocument.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.open();
        pdfDocument.save();
        pdfDocument.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDocument = excelFactory.createDocument();
        excelDocument.open();
        excelDocument.save();
        excelDocument.close();
    }
}
