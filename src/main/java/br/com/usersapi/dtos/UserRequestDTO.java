package br.com.usersapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -8953196753735778746L;

    @NotEmpty(message = "Required Field")
    private String name;
    @NotEmpty(message = "Required Field")
    private String key;
    @NotEmpty(message = "Required Field")
    private String email;
}
