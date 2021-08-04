package kr.or.btf.web.domain.web;

import kr.or.btf.web.domain.web.enums.MberDvType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_board_data")
public class BoardData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_pid")
    private Long id;

    private Integer thread;
    private Integer depth;

    @Column(name = "sntnc_head")
    private String sntncHead;

    private String ttl;
    private String cn;

    @Column(name = "wrter_nm")
    private String wrterNm;

    private String pwd;

    @Column(name = "read_cnt")
    private Integer readCnt;

    @Column(name = "wrter_ip")
    private String wrterIp;

    @Column(name = "prnt_pwd")
    private String prntPwd;

    @Column(name = "mst_pid")
    private Long mstPid;

    @Column(name = "reg_ps_id")
    private String regPsId;
    @Column(name = "reg_dtm")
    private LocalDateTime regDtm;
    @Column(name = "upd_ps_id")
    private String updPsId;
    @Column(name = "upd_dtm")
    private LocalDateTime updDtm;
    @Column(name = "ntce_dt")
    private LocalDateTime ntceDt;
    @Column(name = "del_at")
    private String delAt;
    @Column(name = "fixing_at")
    private String fixingAt;

    @Transient
    private String regPsNm;
    @Transient
    private String thumbFileNm;
    @Transient
    private Long downloadCnt;
    /*@Transient
    private String targetArr;*/
    @Transient
    private MberDvType target;
    @Transient
    private String targetList;
    @Transient
    private String prevNext;
    @Transient
    private Long likeCnt;
    @Transient
    private LocalDateTime commentDtm;
    @Transient
    private String hashTags;

    /*public LocalDateTime setNtceDt() {

        LocalDateTime dateTime = LocalDateTime.parse(ntceDt, DateTimeFormatter.ISO_DATE)

        return dateTime;
    }
    public String getNtceDt() {

        String date = ntceDt.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));

        return date;
    }*/
}
