package br.com.usersapi.utilities;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class StringToUUIDConverter implements Converter<String, UUID> {

    @Override
    public UUID convert(String source) {
        if (StringUtils.hasLength(source)) {
            return UUID.fromString(source.trim());
        }
        return null;
    }
}
