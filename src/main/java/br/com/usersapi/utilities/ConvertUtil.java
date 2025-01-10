package br.com.usersapi.utilities;

import java.util.UUID;

public class ConvertUtil {

    public static UUID convertStringToUUID(String uuid) {
        StringToUUIDConverter uuidConverter = new StringToUUIDConverter();
        return uuid != null ? uuidConverter.convert(uuid) :  null;
    }

    public static String convertUUIDToString(UUID uuid) {
        return uuid != null ? uuid.toString() : null;
    }
}
