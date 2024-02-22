package com.library.api.dto;

import com.library.api.models.User;
import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String first_name;
    private String last_name;
    private String email;

    public static class UserDtoBuilder{
        public static UserDto fromUser(User user){
            UserDto dto = new UserDto();
            dto.setEmail(user.getEmail());
            dto.setId(user.getId());
            dto.setFirst_name(user.getFirst_name());
            dto.setLast_name(user.getLast_name());
            return dto;
        }
    }
}
