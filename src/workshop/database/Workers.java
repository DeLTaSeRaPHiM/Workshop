package workshop.database;

public class Workers {
    private String worker_ID;
    private String surname;
    private String name;
    private String patronymic;
    private String workshopName;

    public Workers(String worker_ID, String surname, String name, String patronymic, String workshopName) {
        this.worker_ID = worker_ID;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.workshopName = workshopName;
    }

    public Workers() {

    }

    public String getWorker_ID() {
        return worker_ID;
    }

    public void setWorker_ID(String worker_ID) {
        this.worker_ID = worker_ID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }
}
