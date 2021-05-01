package hellojpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

//    private Integer age;
//
//    @Enumerated(EnumType.STRING) //Enum타입이 ordinal(defualt) -> enum순서(숫자)를 데이터베이스에 저장 / string -> enum이름을 데이터베이스에 저장
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob //varchar를 넘어서는 큰 컨텐츠가 들어가야 할 컬럼
//    private String description;

    public Member(){
    }
}
