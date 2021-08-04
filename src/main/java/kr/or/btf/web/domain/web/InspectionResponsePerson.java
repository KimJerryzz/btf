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
@Table(name = "tbl_inspection_response_person")
@DynamicUpdate
public class InspectionResponsePerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rsp_ps_pid")
    private Long id;


    @Column(name="login_id")
    private String loginId;

    private String nm;

    @Column(name="mber_dv_ty")
    private String mberDvty;

    @Column(name="inspct_dv_ty")
    private String inspctDvTy;

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

    @Column(name="inspct_pid")
    private Long inspctPid;
    @Column(name = "atnlc_req_pid")
    private Long atnlcReqPid;

    @Transient
    private String regPsNm;
}
