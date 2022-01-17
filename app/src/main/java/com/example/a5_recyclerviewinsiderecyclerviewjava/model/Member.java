package com.example.a5_recyclerviewinsiderecyclerviewjava.model;

import java.util.List;

public class Member {
    private String name;
    private String about;
    private List<MemberSub> memberSubs;
    public Member(String name, String about, List<MemberSub> memberSubs){
        this.name = name;
        this.about = about;
        this.memberSubs = memberSubs;
    }

    public List<MemberSub> getMemberSubs() {
        return memberSubs;
    }

    public void setMemberSubs(List<MemberSub> memberSubs) {
        this.memberSubs = memberSubs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
