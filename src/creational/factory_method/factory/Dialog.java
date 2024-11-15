package creational.factory_method.factory;

import creational.factory_method.buttons.Button;

public abstract class Dialog {
    public void renderWindows(){
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
