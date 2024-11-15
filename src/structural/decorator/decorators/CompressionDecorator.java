package structural.decorator.decorators;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator{
    private int compLevel = 6;

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    public int getCompressionLevel() {
        return compLevel;
    }

    public void setCompressionLevel(int value) {
            compLevel = value;
    }

    @Override
    public void writeData(String data){
        super.writeData(compress(data));
    }
    @Override
    public String readData(){
        return decompress(super.readData());
    }



    private String compress(String stringData){
        byte[] data = stringData.getBytes();
        try{
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel));
            dos.write(data);
            dos.close();
            bout.flush();
            return Base64.getEncoder().encodeToString(bout.toByteArray());
        }catch(IOException e){
            return null;
        }
    }

    private String decompress(String stringDataq) {
        byte[] data = Base64.getDecoder().decode(stringDataq);
        try{
            InputStream in = new ByteArrayInputStream(data);
            InflaterInputStream iin = new InflaterInputStream(in, new Inflater());
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            int b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            in.close();
            iin.close();
            bout.close();
            return new String(bout.toByteArray());
        }catch (Exception e){
            return null;
        }
    }
}
