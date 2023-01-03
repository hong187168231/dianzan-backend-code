INSERT INTO `likes`.`bd_user` (`accno`, `bdusername`, `phoneno`, `wechat`, `email`, `is_delete`, `create_user`, `create_time`, `update_user`, `update_time`, `acclogin`, `password`, `passwordmd5`, `loginnum`, `accstatus`, `clintipadd`, `lastlogindate`) VALUES ('28883d4a8d584128a9443111ac0c93fe', '后台管理员', '13800000001', '15800000001', '', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:20', '065d4aed0b4a47bc9406d39ae182g3e6', '2023-01-03 16:01:03', 'supermanage', '96e79218965eb72c92a549dd5a330112', '96e79218965eb72c92a549dd5a330112', '199', '1', '192.168.1.127', '2023-01-03 16:01:07');

INSERT INTO `likes`.`sys_roleinfo` (`sysrolename`, `sysrolestatus`) VALUES ('超级系统管理员', '0');
INSERT INTO `likes`.`sys_roleinfo` (`sysrolename`, `sysrolestatus`) VALUES ('运营管理', '0');


INSERT INTO `likes`.`sys_bduserrole` ( `sysroleid`, `accno`, `is_delete`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES ('1', '28883d4a8d584128a9443111ac0c93fe', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:15', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:15');
INSERT INTO `likes`.`sys_rolefunc` (`sysroleid`, `sfunid`, `is_delete`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES ('1', '1', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:48', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:48');