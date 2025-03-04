package com.example.securityex4.service;

import com.example.securityex4.domain.Role;
import com.example.securityex4.domain.User;
import com.example.securityex4.domain.UserRegisterDTO;
import com.example.securityex4.repository.RoleRepository;
import com.example.securityex4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @Transactional
    public User registUser(User user) {
        Role role=roleRepository.findByName("USER").get();
        user.setRoles(Collections.singleton(role));

        //패스워드 암호화
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Transactional
    public boolean existUser(UserRegisterDTO registerDTO) {
        return userRepository.existsByUsername(registerDTO.getUsername());
    }

    @Transactional
    public User registUser(UserRegisterDTO registerDTO) {
        String encodePassword = passwordEncoder.encode(registerDTO.getPassword());
        Set<Role> roles= registerDTO.getRoles().stream()
                .map(roleRepository::findByName)
                .flatMap(Optional::stream) //Optional이 비어있다면 무시하고 값만 추출
                .collect(Collectors.toSet());

        User user=new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(encodePassword);
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
