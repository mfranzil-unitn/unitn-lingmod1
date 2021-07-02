package esame201806P;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TextContainer<T extends Integer> extends Text {
    private T associatedValue;
    private String associatedText;

    public TextContainer(String text, T associatedValue) {
        super(text + " = " + associatedValue.toString());
        this.associatedText = text;
        this.associatedValue = associatedValue;
        setFont(Font.font("Verdana", FontWeight.BOLD, 18));
    }

    public TextContainer(String text) {
        super(text + " = ");
        this.associatedText = text;
        setFont(Font.font("Verdana", FontWeight.BOLD, 18));
    }

    public void update(T value) {
        this.associatedValue = value;
        setText(associatedText + " = " + associatedValue.toString());
    }

    public T getAssociatedValue() {
        return associatedValue;
    }

    public void setAssociatedValue(T associatedValue) {
        this.associatedValue = associatedValue;
    }
}
