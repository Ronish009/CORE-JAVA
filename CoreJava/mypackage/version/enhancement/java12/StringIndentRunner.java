package mypackage.version.enhancement.java12;

public class StringIndentRunner {
    public static void main(String[] args) {
        String text = "Java\nFeatures\nIndentation";
        String indentedText = text.indent(4);
        String reducedIndentationText = indentedText.indent(-2);
        System.out.println("Orignal String: \n"+text);
        System.out.println("Indent String: \n"+indentedText);
        System.out.println("Indent String: \n"+reducedIndentationText);
    }
}
