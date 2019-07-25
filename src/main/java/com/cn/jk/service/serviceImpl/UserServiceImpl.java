/**
 * <p>Title: UserServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/2/14
 */
package com.cn.jk.service.serviceImpl;

import com.cn.jk.entity.TbUser;
import com.cn.jk.mapper.TbUserMapper;
import com.cn.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Override
    public Map getListUser(Integer page, Integer size) {
        Map map=new HashMap<>();//存查看用户分页的参数
        Map map2=new HashMap<>();//存返回值
        Integer beginIndex=0;//查看数据库用户列表列表开始的索引
        List<TbUser> userList=new ArrayList<>();//存分页中返回的退款单
        Integer prePage=0;//保存是否有前一页
        Integer nextPage=0;//保存是否有后一页
        Integer pageCount=1;
        List<TbUser> users= tbUserMapper.getAllUserList();
        if(!users.isEmpty()){
            Integer count=users.size();//总共的用户信息记录条数
            pageCount=count/size;//总共的页数
            if(count%size!=0){
                pageCount++;
            }
            if(page<1){
                page=1;
            }
            if(page>pageCount){
                page=pageCount;
            }
            beginIndex=(page-1)*size;
            if(page>1){
                prePage=1;//表示有前一页
            }
            if(page<pageCount){
                nextPage=1;//表示有下一页
            }
            map.put("beginIndex",beginIndex);
            map.put("size",size);
            userList= tbUserMapper.getAllUserListIndex(map);//获得当页查看到的退款单
            map2.put("page",page);
        }else{
            map2.put("page",1);
        }
        Integer pageSize[]=new Integer[pageCount];
        map2.put("userList",userList);
        map2.put("pageCount",pageCount);
        map2.put("prePage",prePage);
        map2.put("nextPage",nextPage);
        map2.put("pageSize",pageSize);
        map2.put("dataSize",users.size());
        return map2;
    }
}
