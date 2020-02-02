package com.ahmadmongo.ahmadmongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SysUserDto {

    @Id
    private Long id;
    private String username;
    private String password;
    private String token;

}
