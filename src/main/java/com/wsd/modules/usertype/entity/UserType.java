package com.wsd.modules.usertype.entity;


import com.wsd.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity(name = "user_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class UserType extends BaseEntity implements Serializable {
    private String name;
}
