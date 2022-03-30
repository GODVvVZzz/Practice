package url;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author HP
 * @date 2022/3/29
 */
public class UrlDown {
    public static void main(String[] args) throws Exception {
        //下载地址
        URL url = new URL("");

        //连接到这个资源 Http
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream outputStream = new FileOutputStream("");

        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }

        outputStream.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
