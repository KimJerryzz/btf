package kr.or.btf.web.domain.web.enums;

public enum FileDvType {
    ATTACH("첨부파일"), THUMB("썸네일"), MAINVOD("대표영상"), PC("PC배너"), MOBILE("모바일배너");

    final private String name;

    public String getName() {
        return name;
    }

    private FileDvType(String name){
        this.name = name;
    }
}
