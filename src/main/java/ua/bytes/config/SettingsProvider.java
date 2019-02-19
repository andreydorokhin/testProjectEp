package ua.bytes.config;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SettingsProvider {
    private static SettingsProvider ourInstance = new SettingsProvider();
    private Settings settings;

    public static SettingsProvider getInstance() {
        return ourInstance;
    }

    private SettingsProvider() {
        Gson gson=new Gson();
        gson.serializeNulls();
        String json = null;

        try {
            json = new String(Files.readAllBytes(Paths.get("config.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        settings = gson.fromJson(json, Settings.class);
        System.out.println(settings.toString());
    }

    public Settings getSettings() {
        return settings;
    }
}
