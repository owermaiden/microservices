package com.ower.user_service.VO;

import com.ower.user_service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTempleteVO {

    private User user;
    private Department department;
}
