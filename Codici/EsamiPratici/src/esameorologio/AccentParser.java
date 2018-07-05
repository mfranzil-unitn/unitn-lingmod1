package esameorologio;

import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class AccentParser {
    public static Color getAccentColor() {
        String value = null;
        try {
            value = new AccentParser().readRegistry("HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\DWM",
                    "ColorizationColor");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        assert value != null;

        if (value.length() == 10) {
            value = value.substring(4);
        } else {
            value = value.substring(2);
        }

        int r = Integer.valueOf(value.substring(0, 2), 16);
        System.out.println(value.substring(0, 2));
        int g = Integer.valueOf(value.substring(2, 4), 16);
        int b = Integer.valueOf(value.substring(4, 6), 16);
        //     int a = Integer.valueOf(value.substring(6, 8), 16);
        return Color.rgb(r, g, b, 1);
    }

    /**
     * @param location path in the registry
     * @param key      registry key
     * @return registry value or null if not found
     */
    public String readRegistry(String location, String key) throws IOException, InterruptedException {
        // Run reg query, then read output with StreamReader (internal class)
        Process process = Runtime.getRuntime().exec("reg query " +
                '"' + location + "\" /v " + key);

        StreamReader reader = new StreamReader(process.getInputStream());
        reader.start();
        process.waitFor();
        reader.join();

        // Parse out the value
        String[] parsed = reader.getResult().split("\\s+");
        if (parsed.length > 1) {
            return parsed[parsed.length - 1];
        }
        return null;
    }

    class StreamReader extends Thread {
        private InputStream is;
        private StringWriter sw = new StringWriter();

        public StreamReader(InputStream is) {
            this.is = is;
        }

        public void run() {
            try {
                int c;
                while ((c = is.read()) != -1)
                    sw.write(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getResult() {
            return sw.toString();
        }
    }
}
