package katahistograma;

class Email {
    private String address;

    public Email(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }

    public String getDomain(){
        return address.split("@")[1];
    }
}
