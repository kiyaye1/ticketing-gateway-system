package com.synex.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.synex.domain.Employee;
import com.synex.domain.Role;
import com.synex.repository.EmployeeRepository;
import com.synex.repository.RoleRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(EmployeeRepository empRepo, RoleRepository roleRepo, BCryptPasswordEncoder encoder) {
        return args -> {
            // Create roles if not present
            Role userRole = roleRepo.findByName("USER").orElseGet(() -> roleRepo.save(new Role(null, "USER")));
            Role managerRole = roleRepo.findByName("MANAGER").orElseGet(() -> roleRepo.save(new Role(null, "MANAGER")));
            Role adminRole = roleRepo.findByName("ADMIN").orElseGet(() -> roleRepo.save(new Role(null, "ADMIN")));

            // Only create users if none exist
            if (empRepo.count() == 0) {
                Employee user = new Employee();
                user.setName("Regular User");
                user.setEmail("user@user.com");
                user.setPassword(encoder.encode("user123"));
                user.setDepartment("IT");
                user.setProject("Support");
                user.setRoles(List.of(userRole));
                empRepo.save(user);

                Employee manager = new Employee();
                manager.setName("Team Manager");
                manager.setEmail("manager@manager.com");
                manager.setPassword(encoder.encode("manager123"));
                manager.setDepartment("IT");
                manager.setProject("Support");
                manager.setRoles(List.of(managerRole));
                empRepo.save(manager);

                Employee admin = new Employee();
                admin.setName("System Admin");
                admin.setEmail("admin@admin.com");
                admin.setPassword(encoder.encode("admin123"));
                admin.setDepartment("IT");
                admin.setProject("Support");
                admin.setRoles(List.of(adminRole));
                empRepo.save(admin);
            }
        };
    }
}
