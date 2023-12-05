package com.umc.study.domain;

import com.umc.study.domain.common.BaseEntity;
import com.umc.study.domain.common.Gender;
import com.umc.study.domain.mapping.FavoriteFoodType;
import com.umc.study.domain.mapping.UserMissions;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private Date birthday;

    @Column(nullable = false, length = 256)
    private String address;

    @Column(nullable = false, length = 256)
    private String specAddress;

    @Column
    private Gender gender;

    @Column(nullable = false)
    private Long totalPoint;

    @Column(nullable = false, length = 20)
    private String state;

    private Date deletedDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<FavoriteFoodType> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<UserMissions> UserMissionList = new ArrayList<>();
}
