package test.domain;

import com.lsm1998.ibatis.annotation.MyColumn;
import com.lsm1998.ibatis.annotation.MyEntry;
import com.lsm1998.ibatis.annotation.MyId;
import com.lsm1998.ibatis.annotation.MyTable;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/1/13-11:28
 * @说明：购物车实体
 */
@MyEntry
@MyTable(name = "boot_cart")
public class Cart implements Serializable
{
    @MyId
    private Long id;
    @MyColumn(value = "user_id", type = "int", length = 11, index = true)
    private Long userId;
    @MyColumn(value = "pets_id", type = "int", length = 11, index = true)
    private Long petsId;
    private Integer number;
    private Double sum;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getPetsId()
    {
        return petsId;
    }

    public void setPetsId(Long petsId)
    {
        this.petsId = petsId;
    }

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public Double getSum()
    {
        return sum;
    }

    public void setSum(Double sum)
    {
        this.sum = sum;
    }

    @Override
    public String toString()
    {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", petsId=" + petsId +
                ", number=" + number +
                ", sum=" + sum +
                '}';
    }
}
