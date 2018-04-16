package com.pjx.mvvmdemo.entiry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author by xie on 2018/2/24.
 *         更新者：
 *         更新时间：
 *         功能描述：
 */
@Entity
public class Teacher {
    @Id
    private long id;
    private String name;
    private String age;

    @Generated(hash = 673924946)
    public Teacher(long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Generated(hash = 1630413260)
    public Teacher() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
