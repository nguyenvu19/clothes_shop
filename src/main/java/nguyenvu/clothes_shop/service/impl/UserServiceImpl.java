package nguyenvu.clothes_shop.service.impl;

import nguyenvu.clothes_shop.entity.UserEntity;
import nguyenvu.clothes_shop.exception.CustomException;
import nguyenvu.clothes_shop.payload.request.SignUpRequest;
import nguyenvu.clothes_shop.repository.UserRepository;
import nguyenvu.clothes_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(SignUpRequest request) {
        boolean isSuccess = false;
        try {
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));

            userRepository.save(user);
            isSuccess = true;
        }catch (Exception e){
            throw new CustomException("Error add user: " + e.getMessage());
        }
        return isSuccess;
    }
}
