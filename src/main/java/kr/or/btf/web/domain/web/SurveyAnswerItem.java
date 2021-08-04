package kr.or.btf.web.domain.web;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_survey_answer_item")
@DynamicUpdate
public class SurveyAnswerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asw_pid")
    private Long id;


    @Column(name="answer_cnts")
    private String answerCnts;


    @Column(name = "reg_ps_id")
    private String regPsId;
    @Column(name = "reg_dtm")
    private LocalDateTime regDtm;
    @Column(name = "upd_ps_id")
    private String updPsId;
    @Column(name = "upd_dtm")
    private LocalDateTime updDtm;
    @Column(name = "del_at")
    private String delAt;


    @Column(name="qesitm_pid")
    private Long qesitmPid;

    @Transient
    private String regPsNm;

    @Transient
    private String responseAnswerCnts;

    @Transient
    private Long responseAswPid;

}
