package com.app.user.controller;

import com.app.ApiResponse;
import com.app.user.dto.UserDTO;
import com.app.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/findAll")
    @ApiOperation(value = "Tüm kullanıcı listesini getiren servis.")
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "Id'ye göre kullanıcı getiren servis.")
    public UserDTO findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Kullanıcı kaydeden servis.")
    public ApiResponse save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PostMapping("/saveAll")
    @ApiOperation(value = "Kullanıcı toplu kaydeden servis.")
    public ApiResponse saveAll(@RequestBody List<UserDTO> userDTOList) {
        return userService.saveAll(userDTOList);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Kullanıcı güncelleyen servis.")
    public ApiResponse update(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @PostMapping("/deleteById/{id}")
    @ApiOperation(value = "Id'ye göre kullanıcı silen servis.")
    public ApiResponse deleteById(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }

}
