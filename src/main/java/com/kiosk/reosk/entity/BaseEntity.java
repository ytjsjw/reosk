package com.kiosk.reosk.entity;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass //이 어노테이션이 적용되면 테이블을 생성안함
@EntityListeners(value = { AuditingEntityListener.class})  //특정 엔티티에 이벤트 발생 시 적용될 리스너(Listener) 클래스를 지정하는데 사용됩니다.
@Getter
public class BaseEntity {

	@CreatedDate
	@Column(name ="regdate" , updatable =false)
	private LocalDateTime regDate;
	
	@LastModifiedDate
	@Column( name ="moddate")
	private LocalDateTime modDate;
}