package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass //공동매핑 정보가 필요할 때 사용한다     이 클래스를 다른 엔티티에 상속 시키면 테이블에 이 컬럼들이 추가된다
public abstract class BaseEntity {

    private String createBy;
    private LocalDateTime createDate;
    private String lastmodifiedBy;
    private LocalDateTime lastModifiedDate;
}

