package dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// CREATE TABLE todotbl (
// 	NO NUMBER(8) PRIMARY KEY,
// 	title nvarchar2(100) NOT NULL,
// 	create_at DATE DEFAULT sysdate,
// 	completed char(1) DEFAULT '0',
// 	dscription nvarchar2(1000)
// );

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ToDoDto {
    // table 구조와 동일하게 작성
    private int no;
    private String title;
    private LocalDateTime create_at;
    private boolean completed;
    private String dscription;

}
