package com.example.todo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserData {

    private Long id;

    private String name;

    private String email;
}
