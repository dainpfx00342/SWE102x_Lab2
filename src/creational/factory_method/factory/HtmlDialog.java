package creational.factory_method.factory;

import creational.factory_method.buttons.Button;
import creational.factory_method.buttons.HtmlButton;

public class HtmlDialog extends Dialog {

    public Button createButton() {
        return new HtmlButton();
    }
}
