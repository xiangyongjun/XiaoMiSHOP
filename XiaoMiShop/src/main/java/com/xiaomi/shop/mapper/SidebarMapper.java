package com.xiaomi.shop.mapper;

import com.xiaomi.shop.entity.Sidebar;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SidebarMapper {

    @Select("SELECT * FROM sidebar")
    public List<Sidebar> selectAll();

    @Insert("INSERT INTO sidebar(title,link) VALUES(${title},${link})")
    public Boolean insert(@Param("title") String title, @Param("link") String link);

    @Update("UPDATE sidebar SET title='${title}',link='${link}' WHERE id=${id}")
    public Boolean update(@Param("id") int id, @Param("title") String title, @Param("link") String link);

    @Delete("DELETE FROM sidebar WHERE id=${id}")
    public Boolean delete(@Param("id") int id);

}
