package cn.asyysy.core.service.impl;

import cn.asyysy.core.model.User;
import cn.asyysy.core.mapper.UserMapper;
import cn.asyysy.core.service.UserService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyaoyu
 * @since 2019-05-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Page<User> selectPage(User user, Page<User> page) {

        return null;
    }
}
