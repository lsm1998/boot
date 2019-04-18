package test.domain;

import com.lsm1998.ibatis.annotation.MyColumn;
import com.lsm1998.ibatis.annotation.MyEntry;
import com.lsm1998.ibatis.annotation.MyId;
import com.lsm1998.ibatis.annotation.MyTable;
import com.lsm1998.ibatis.enums.AutoIncrement;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/1/10-22:36
 * @说明：用户实体
 */
@MyEntry
@MyTable(name = "boot_user")
public class User implements Serializable
{
    @MyId
    private Long id;
    private String nickName;
    @MyColumn(value = "userName",type = "varchar",length = 55,index = true,unique = true)
    private String userName;
    @MyColumn(value = "passWord",type = "varchar",length = 255,index = true)
    private String passWord;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
