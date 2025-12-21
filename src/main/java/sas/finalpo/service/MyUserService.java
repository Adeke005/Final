package sas.finalpo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sas.finalpo.entity.Permission;
import sas.finalpo.entity.User;
import sas.finalpo.repository.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService implements UserDetailsService {

    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void registr(User model) {
        model.setPassword(passwordEncoder.encode(model.getPassword()));
        model.setPermissions(List.of(new Permission(null, "USER")));
        userRepository.save(model);
    }
}
