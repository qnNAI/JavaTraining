package by.training.finalproject.entity;

import by.training.finalproject.entity.infoEnum.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User implements Entity {
    private Integer id;
    private String login;
    private String password;
    private Role role;
    private int state;
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String phone;
}
