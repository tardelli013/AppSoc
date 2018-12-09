package br.com.soc.tardelli.model;

public enum ExamTypesEnum {

    MAMOGRAFIA(1, "Mamografia","C11"),
    RAIO_X(2, "Raio X","S03.7"),
    RESSONANCIA(3, "Ressonância","C11.0"),
    TOMOGRAFIA(4, "Tomografia","T11.2"),
    ECODOPLER(5, "Ecodopler","C11.3"),
    HEMOGRAMA(6, "Hemograma","C11.8"),
    ENDOSCOPYIA(7, "Endoscopia","Z01.9"),
    CEFALOMETRIA(8, "Cefalometria","P11.9"),
    ULTRASSONOGRAFIA(9, "Ultrassonografia","A21.7");


    ExamTypesEnum(Integer id, String name, String cid) {
        this.id = id;
        this.name = name;
        this.cid=cid;
    }

    private Integer id;
    private String name;
    private String cid;

    public static String getNameById(Integer id) {
        for (ExamTypesEnum e : ExamTypesEnum.values()) {
            if (e.getId().equals(id)) {
                return e.getName();
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCid() {
        return cid;
    }
}
