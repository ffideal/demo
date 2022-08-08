package cn.ffideal.user.web;

import cn.ffideal.user.config.PatternProperties;
import cn.ffideal.user.pojo.User;
import cn.ffideal.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope   // 配置自动刷新
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatternProperties patternProperties;

//    // 注入nacos中的配置属性
//    @Value("${pattern.dateformat}")
//    private String dateformat;
//    // 编写controller，通过日期格式化器来格式化现在时间并返回
    @GetMapping("/now")
    public String now(){
        return LocalDateTime.now().format(
            DateTimeFormatter.ofPattern(patternProperties.getDateformat(), Locale.CHINA)
        );
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
