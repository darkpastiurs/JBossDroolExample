package sv.edu.unab.drools.message;

public class Message {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        return getType() != null ? getType().equals(message.getType()) : message.getType() == null;
    }

    @Override
    public int hashCode() {
        return getType() != null ? getType().hashCode() : 0;
    }

    public void printMessage(){
        System.out.println("Type: " + getType());
    }
}
