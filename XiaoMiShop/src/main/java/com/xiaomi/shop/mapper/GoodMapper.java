package com.xiaomi.shop.mapper;

import com.xiaomi.shop.entity.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodMapper {

    @Select("SELECT * FROM good")
    public List<Good> selectAll();

    @Insert("INSERT INTO good(`title`,`src`,`price`,`desc`,`old_price`) VALUES('${title}','${src}',${price},'${desc}',${old_price})")
    public Boolean insert(@Param("title") String title, @Param("src") String src, @Param("price") double price, @Param("desc") String desc, @Param("old_price") double old_price);

    @Update("UPDATE good SET `title`='${title}',`src`='${src}',`price`=${price},`desc`='${desc}',`old_price`=${old_price} WHERE id=${id}")
    public Boolean update(@Param("id") int id, @Param("title") String title, @Param("src") String src, @Param("price") double price, @Param("desc") String desc, @Param("old_price") double old_price);

    @Delete("DELETE FROM good WHERE id=${id}")
    public Boolean delete(@Param("id") int id);

}
