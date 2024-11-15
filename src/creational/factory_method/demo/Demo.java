package creational.factory_method.demo;

import creational.factory_method.factory.Dialog;
import creational.factory_method.factory.HtmlDialog;
import creational.factory_method.factory.WindowsDialog;

import static java.lang.System.*;

public class Demo {
    private static Dialog dialog;
    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure() {
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("mac")) {
            dialog = new WindowsDialog();
        }else {
            dialog = new HtmlDialog();
        }
    }
    static void runBusinessLogic() {
        dialog.renderWindows();
    }
}
