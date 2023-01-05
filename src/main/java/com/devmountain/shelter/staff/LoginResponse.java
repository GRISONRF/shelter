package com.devmountain.shelter.staff;
import lombok.Data;
import java.util.List;

@Data
public class LoginResponse {
    boolean isSuccessful;
    List<String> response;
}
