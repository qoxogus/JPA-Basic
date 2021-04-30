package hellojpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    @Id
    private Long id;
    @Column(unique = true, length = 10)
    private String name;

    public Member(){
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
