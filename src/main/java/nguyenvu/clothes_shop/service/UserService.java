package nguyenvu.clothes_shop.service;

import nguyenvu.clothes_shop.payload.request.SignUpRequest;

public interface UserService {
    boolean addUser(SignUpRequest request);
}
