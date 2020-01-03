package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.Post;
import com.xzit.garden.bean.entity.Staff;

public class GroupMemberDto {
    private Long id;

    private Group group;
    private Staff staff;
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return group.getName();
    }

    public String getMemberName() {
        return staff.getName();
    }

    public String getPostName() {
        if (post == null) return null;
        return post.getName();
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
