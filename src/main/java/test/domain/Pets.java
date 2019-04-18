package test.domain;

import com.lsm1998.ibatis.annotation.MyEntry;
import com.lsm1998.ibatis.annotation.MyId;
import com.lsm1998.ibatis.annotation.MyTable;

import java.io.Serializable;

/**
 * @作者：刘时明
 * @时间：2019/1/13-11:22
 * @说明：宠物实体
 */
@MyEntry
@MyTable(name = "boot_pets")
public class Pets implements Serializable
{
    @MyId
    private Long id;
    private String name;
    private String type;
    private Double price;
    private String info;
    private String img;

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    @Override
    public String toString()
    {
        return "Pets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
