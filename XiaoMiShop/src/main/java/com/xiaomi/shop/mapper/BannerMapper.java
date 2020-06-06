package com.xiaomi.shop.mapper;

import com.xiaomi.shop.entity.Banner;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BannerMapper {

    @Select("SELECT * FROM banner")
    public List<Banner> selectAll();

    @Insert("INSERT INTO banner(src,link) VALUES(${src},${link})")
    public Boolean insert(@Param("src") String src, @Param("link") String link);

    @Update("UPDATE banner SET src='${src}',link='${link}' WHERE id=${id}")
    public Boolean update(@Param("id") int id, @Param("src") String src, @Param("link") String link);

    @Delete("DELETE FROM banner WHERE id=${id}")
    public Boolean delete(@Param("id") int id);

}
