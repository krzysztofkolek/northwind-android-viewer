package kolek.krzysztof.pum.temp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class GetDataHelper {
    private static final int BUFFER_SIZE = 4096; //4096 = 4kb, you can have it as you wish 4kb & 8kb are preferred.

    public static String getResponseInFile(String address, File file) throws IOException {
        String dataString = "";


        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            URL url = new URL(address);
            URLConnection connection = url.openConnection();

            inputStream = connection.getInputStream();


            byte[] data;
            if (inputStream.available() > BUFFER_SIZE) {
                data = new byte[BUFFER_SIZE];
            } else {
                data = new byte[inputStream.available()];
            }

            int dataCount;
            while ((dataCount = inputStream.read(data)) > 0) {
                outputStream.write(data, 0, dataCount);
            }



            OutputStream output = new OutputStream()
            {
                private StringBuilder string = new StringBuilder();
                @Override
                public void write(int b) throws IOException {
                    this.string.append((char) b );
                }

                //Netbeans IDE automatically overrides this toString()
                public String toString(){
                    return this.string.toString();
                }
            };
            output.write(data);


            dataString = output.toString();


        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
            try {
                outputStream.close();
            } catch (Exception e) {
            }
        }








        return dataString;
    }
}
