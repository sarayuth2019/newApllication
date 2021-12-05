//package com.powergroup.controller;
//
//import com.powergroup.model.bean.APIResponse;
//import com.powergroup.model.service.UserBackupNotifyRepository;
//import com.powergroup.model.table.UserBackupNotify;
//import com.powergroup.util.ContextUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/UserBackup")
//public class UserBackupNotifyController {
//    @Autowired
//    private UserBackupNotifyRepository backupRepository;
//    @Autowired
//    private ContextUtil contextUtil;
//    @PostMapping("/save")
//    public Object save(UserBackupNotify backupNotify) {
//        APIResponse res = new APIResponse();
//        backupRepository.save(backupNotify);
//        res.setData(backupNotify);
//        res.setMessage("save success...");
//        res.setStatus(1);
//        return res;
//    }
//
//    @GetMapping("/list")
//    public Object list() {
//        APIResponse res = new APIResponse();
//        List<UserBackupNotify> getList = backupRepository.findAll();
//        res.setData(getList);
//        res.setMessage("List All...");
//        return res;
//    }
//
//    @PostMapping("/list/user")
//    public Object listUser(int user) {
//        APIResponse res = new APIResponse();
//        //Optional<UserEntity> dataUser = contextUtil.getUserDataFromContext();
//        List<UserBackupNotify> getList = backupRepository.findByUserId(user);
//        res.setStatus(1);
//        res.setData(getList);
//        res.setMessage("List User...");
//        return res;
//    }
//
//}
