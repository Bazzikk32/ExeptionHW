public class Checker {

    public Service service;


    public Checker() {
        service = new Service();
    }

    public void checkerFormats(){
        service.checkIfString(service.fatherName);
        service.checkIfString(service.family);
        service.checkIfString(service.fatherName);
        service.checkGender(service.gender);
        service.checkIfNumber(service.phoneNumberStr);
        try {
            Service.isValidDate(service.birtDay);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
