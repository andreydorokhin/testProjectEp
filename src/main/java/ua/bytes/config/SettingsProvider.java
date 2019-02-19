/*
 * (C) Copyright 2019 Andrey Вщкщлршт
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
