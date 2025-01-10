package br.com.usersapi.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserViewDTO {

    private String id;
    private String name;
    private String key;
    private String email;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
