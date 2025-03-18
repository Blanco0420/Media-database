// package com.media.database.media_database.controllers;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.web.bind.annotation.*;

// import com.media.database.media_database.models.AuthRequest;
// import com.media.database.media_database.models.UserInfo;
// import com.media.database.media_database.models.dto.UserInfoDTO;
// import com.media.database.media_database.services.JwtService;
// import com.media.database.media_database.services.UserInfoService;

// @RestController
// @RequestMapping("/auth")
// public class UserController {

//     @Autowired
//     private UserInfoService service;

//     @Autowired
//     private JwtService jwtService;

//     @Autowired
//     private AuthenticationManager authenticationManager;

//     // @GetMapping("/welcome")
//     // public String welcome() {
//     //     return "Welcome this endpoint is not secure";
//     // }


//     @PostMapping("/user/new")
//     public ResponseEntity<UserInfoDTO> addNewUser(@RequestBody UserInfo userInfo) {
//         UserInfoDTO userInfoDTO = new UserInfoDTO(userInfo.getUsername(), userInfo.getEmail(), List.of("test"));
//         service.addUser(userInfo);
//         return ResponseEntity.ok().body(userInfoDTO);
//     }

//     @GetMapping("/user/profile")
//     // @PreAuthorize("hasAuthority('ROLE_USER')")
//     public UserInfoDTO userProfile() {
//         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         String username = authentication.getName();

//         UserDetails userDetails = service.loadUserByUsername(username);
//         List<String> roles = userDetails.getAuthorities().stream()
//             .map(GrantedAuthority::getAuthority)
//             .collect(Collectors.toList());
//         UserInfoDTO userInfoDTO = new UserInfoDTO(userDetails.getUsername(), "testEmail", roles);

//         return userInfoDTO;
            
        
//     }

//     @GetMapping("/admin/adminProfile")
//     @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//     public String adminProfile() {
//         return "Welcome to Admin Profile";
//     }

//     @PostMapping("/generateToken")
//     public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
//         Authentication authentication = authenticationManager.authenticate(
//             new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
//         );
//         if (authentication.isAuthenticated()) {
//             return jwtService.generateToken(authRequest.getUsername());
//         } else {
//             throw new UsernameNotFoundException("Invalid user request!");
//         }
//     }
// }
