package structural.decorator.demo;

import structural.decorator.decorators.*;

public class Demo {
    public static void main(String[] args) {
        String salaryRecords ="Name, Salary\nJohn Smith, 10000\nSteven Jobs, 91200";
        DataSourceDecorator encoder = new CompressionDecorator(
                                        new EncryptionDecorator(
                                           new FileDataSource("out/OutputDemo.txt")));
        encoder.writeData(salaryRecords);
        DataSource plan = new FileDataSource("out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plan.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoder.readData());
    }
}
