package com.xiaomi.shop.mapper;

import com.xiaomi.shop.entity.Dropdown;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DropdownMapper {

    @Select("SELECT d.id,g.title,g.src,g.price,d.create_time,d.update_time FROM dropdown AS d JOIN good AS g ON d.gid=g.id WHERE d.sid=${sid}")
    public List<Dropdown> selectBySid(@Param("sid") int sid);

    @Select("SELECT * FROM dropdown")
    public List<Dropdown> selectAll();

    @Insert("INSERT INTO dropdown(sid,gid) VALUES(${sid},${gid})")
    public Boolean insert(@Param("sid") int sid, @Param("gid") int gid);

    @Update("UPDATE dropdown SET sid=${sid},gid=${gid} WHERE id=${id}")
    public Boolean update(@Param("id") int id, @Param("sid") int sid, @Param("gid") int gid);

    @Delete("DELETE FROM dropdown WHERE id=${id}")
    public Boolean delete(@Param("id") int id);

}
