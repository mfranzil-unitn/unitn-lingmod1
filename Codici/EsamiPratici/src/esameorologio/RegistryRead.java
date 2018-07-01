package esameorologio;

import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class RegistryRead {
    /**
     * @param location path in the registry
     * @param key      registry key
     * @return registry value or null if not found
     */
    public static final String readRegistry(String location, String key) {
        try {
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
        } catch (Exception e) {
        }

        return null;
    }

    public static Color getAccentColor() {
        String value = RegistryRead.readRegistry("HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\DWM",
                "AccentColor");

        assert value != null;

        value = value.substring(2);

        int r = Integer.valueOf(value.substring(0, 2), 16);
        int g = Integer.valueOf(value.substring(2, 4), 16);
        int b = Integer.valueOf(value.substring(4, 6), 16);
        int a = Integer.valueOf(value.substring(6, 8), 16);
        return Color.rgb(r, g, b, a/255.0);
    }

    static class StreamReader extends Thread {
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
            }
        }

        public String getResult() {
            return sw.toString();
        }
    }
}
